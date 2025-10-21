package com.example.s4679306assignment2.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.s4679306assignment2.data.remote.DashboardEntity
import com.example.s4679306assignment2.databinding.ActivityDashboardBinding
import com.example.s4679306assignment2.ui.details.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_KEYPASS = "extra_keypass"
    }

    private lateinit var binding: ActivityDashboardBinding
    private val vm: DashboardViewModel by viewModels()
    private val adapter = EntityAdapter(::onEntityClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Recycler
        binding.recycler.layoutManager = LinearLayoutManager(this)
        binding.recycler.adapter = adapter

        val keypass = intent.getStringExtra(EXTRA_KEYPASS).orEmpty()
        vm.load(keypass)

        vm.state.observe(this) { s ->
            // You already have tvInfo in your layout
            binding.tvInfo.isVisible = true
            binding.tvInfo.text = when {
                s.loading -> "Loading dashboard..."
                !s.error.isNullOrBlank() -> s.error
                else -> "Total: ${s.total}"
            }

            adapter.submitList(s.entities)
        }
    }

    private fun onEntityClick(item: DashboardEntity) {
        val i = Intent(this, DetailsActivity::class.java)
        i.putExtra(DetailsActivity.EXTRA_ENTITY, item)   // <-- single Parcelable extra
        startActivity(i)
    }
}
