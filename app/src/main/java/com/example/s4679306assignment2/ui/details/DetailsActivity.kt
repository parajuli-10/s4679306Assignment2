package com.example.s4679306assignment2.ui.details

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.s4679306assignment2.data.remote.DashboardEntity
import com.example.s4679306assignment2.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ENTITY = "extra_entity"
    }

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // ✅ Setup toolbar with back navigation
        setSupportActionBar(binding.topAppBar)
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        // ✅ Retrieve entity object passed from Dashboard
        val entity = intent.getParcelableExtra<DashboardEntity>(EXTRA_ENTITY)

        if (entity != null) {
            // Display entity data safely
            binding.tvP1.text = entity.property1?.takeIf { it.isNotBlank() } ?: "No Property 1 available"
            binding.tvP2.text = entity.property2?.takeIf { it.isNotBlank() } ?: "No Property 2 available"
            binding.tvDesc.text = entity.description?.takeIf { it.isNotBlank() } ?: "No description available"
        } else {
            // Handle missing data gracefully
            binding.tvP1.text = "Invalid entity data"
            binding.tvP2.isVisible = false
            binding.tvDesc.isVisible = false
        }
    }
}
