package com.geektech.navcomponent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.navcomponent.databinding.FragmentNoteBinding


class NoteAdapter(val listener: IItemClick) : RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    private var list: MutableList<Note> = ArrayList()

    fun getList(): MutableList<Note>{
        return list
    }

        inner class ViewHolder(private val binding: FragmentNoteBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind(note: Note){
                binding.textView.text = note.title
                binding.textView2.text = note.desc

            }
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = FragmentNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


fun edit(pos: Int, note: Note) {
    list.set(pos,note)
    notifyItemChanged(pos)
}

    fun addItem(note: Note) {
        list.add(note)
        notifyItemInserted(list.size)
    }


}