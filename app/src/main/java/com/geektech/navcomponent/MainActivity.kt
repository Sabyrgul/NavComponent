package com.geektech.navcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.geektech.navcomponent.databinding.ActivityMainBinding
import com.geektech.navcomponent.databinding.FragmentNoteBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}