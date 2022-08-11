package com.example.businesscard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard.databinding.ActivityAddBusinessBinding

class AddBusinessActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        insertListener()
    }

    private fun insertListener() {
        binding.btnClose.setOnClickListener {
            finish()
        }
        binding.btnOk.setOnClickListener {

        }
    }
}