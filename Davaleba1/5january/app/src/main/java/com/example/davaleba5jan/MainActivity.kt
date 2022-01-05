package com.example.davaleba5jan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.davaleba5jan.fragment.fragment_first
import com.example.davaleba5jan.fragment.fragment_fourth
import com.example.davaleba5jan.fragment.fragment_second
import com.example.davaleba5jan.fragment.fragment_third
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragmentContainerView)
        val appBar = AppBarConfiguration(setOf(R.id.fragment_first, R.id.fragment_second, R.id.fragment_third, R.id.fragment_fourth))
        setupActionBarWithNavController(navController,appBar)

        bottomNavigationView.setupWithNavController(navController)
    }


}