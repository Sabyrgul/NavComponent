package com.geektech.navcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.NavHostFragment
import com.geektech.navcomponent.databinding.FragmentNoteBinding

class NoteFragment : Fragment() {
    lateinit var binding: FragmentNoteBinding
    lateinit var adapter: NoteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("note") { _, bundle ->
            val note = bundle.getSerializable("newNote") as Note
            note.title
            adapter.addItem(note)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNoteBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = NoteAdapter()
        binding.recycler.adapter=adapter
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val controller = navHostFragment.navController
        binding.open.setOnClickListener {
            controller.navigate(R.id.addNoteFragment)
        }
    }
}