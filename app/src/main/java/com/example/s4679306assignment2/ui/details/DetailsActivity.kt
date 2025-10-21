package com.example.s4679306assignment2.ui.details

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.s4679306assignment2.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_P1 = "p1"
        const val EXTRA_P2 = "p2"
        const val EXTRA_DESC = "desc"
    }

    private lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvP1.text = intent.getStringExtra(EXTRA_P1) ?: ""
        binding.tvP2.text = intent.getStringExtra(EXTRA_P2) ?: ""
        binding.tvDesc.text = intent.getStringExtra(EXTRA_DESC) ?: ""
    }
}
