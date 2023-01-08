package com.geektech.navcomponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.NavHostFragment
import com.geektech.navcomponent.databinding.FragmentAddNoteBinding

class AddNoteFragment : Fragment() {

    lateinit var binding: FragmentAddNoteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentAddNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navHostFragment =
            requireActivity().supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val controller = navHostFragment.navController
        binding.send.setOnClickListener {
            val bundle=Bundle()
            var newNote=Note(binding.editText.text.toString(),binding.editText2.text.toString())
            bundle.putSerializable(newNote.title,newNote.desc)
            setFragmentResult("note",bundle)
            controller.navigateUp()
        }
    }
}