package com.example.s4679306assignment2.ui.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
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
    private lateinit var adapter: EntityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = EntityAdapter { entity ->
            navigateToDetails(entity)
        }
        binding.recycler.apply {
            layoutManager = LinearLayoutManager(this@DashboardActivity)
            adapter = this@DashboardActivity.adapter
        }

        val keypass = intent.getStringExtra(EXTRA_KEYPASS) ?: ""
        vm.load(keypass)

        vm.state.observe(this) { state ->
            binding.tvInfo.text = when {
                state.loading -> "Loading dashboard..."
                state.error != null -> state.error
                else -> "Total: ${state.total}"
            }
            adapter.submitList(state.entities)
        }
    }

    private fun navigateToDetails(entity: DashboardEntity) {
        startActivity(Intent(this, DetailsActivity::class.java).apply {
            putExtra(DetailsActivity.EXTRA_P1, entity.property1 ?: "")
            putExtra(DetailsActivity.EXTRA_P2, entity.property2 ?: "")
            putExtra(DetailsActivity.EXTRA_DESC, entity.description ?: "")
        })
    }
}
