package com.example.businesscard.ui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.businesscard.data.BusinessCard
import com.example.businesscard.databinding.ItemBusinessCardBinding

class BusinessCardAdapter :
    ListAdapter<BusinessCard, BusinessCardAdapter.ViewHolder>(DiffCallback()) {

    var listenerShare: (View) -> Unit = {}

    inner class ViewHolder(
        private val binding: ItemBusinessCardBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun binding(item: BusinessCard) {
            binding.tvNome.text = item.nome
            binding.tvEmail.text = item.email
            binding.tvTelefone.text = item.telefone
            binding.tvEmpresa.text = item.empresa
            binding.mcvContent.setCardBackgroundColor(Color.parseColor(item.fundoPersonalizado))
            binding.mcvContent.setOnClickListener { listenerShare(it) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBusinessCardBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding(getItem(position))
    }
}

class DiffCallback : DiffUtil.ItemCallback<BusinessCard>() {
    override fun areItemsTheSame(oldItem: BusinessCard, newItem: BusinessCard): Boolean =
        oldItem == newItem

    override fun areContentsTheSame(oldItem: BusinessCard, newItem: BusinessCard) =
        oldItem.id == newItem.id
}