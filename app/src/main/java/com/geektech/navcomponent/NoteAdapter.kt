package com.geektech.navcomponent

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.navcomponent.databinding.FragmentNoteBinding
import com.geektech.navcomponent.databinding.ItemRowBinding


class NoteAdapter : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    var list: MutableList<Note> = ArrayList()
    lateinit var binding: ItemRowBinding

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note: Note) {
            binding.itemText.text = note.title
            binding.itemTextDesc.text = note.desc
            notifyDataSetChanged()

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding=ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    fun edit(pos: Int, note: Note) {
        list.set(pos, note)
        notifyItemChanged(pos)
    }

    fun addItem(note: Note) {
        list.add(note)
        notifyDataSetChanged()
    }


}