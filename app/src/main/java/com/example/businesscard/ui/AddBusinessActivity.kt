package com.example.businesscard.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.businesscard.App
import com.example.businesscard.R
import com.example.businesscard.data.BusinessCard
import com.example.businesscard.databinding.ActivityAddBusinessBinding

class AddBusinessActivity : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessBinding.inflate(layoutInflater) }

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

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
            val businessCard = BusinessCard(
                nome = binding.tilName.text.toString(),
                empresa = binding.tilWork.text.toString(),
                telefone = binding.tilTelephone.text.toString(),
                email = binding.tilEmail.text.toString(),
                fundoPersonalizado = binding.tilCor.text.toString(),
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}