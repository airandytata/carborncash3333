package com.example.carborncash

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.carborncash.databinding.ActivityMainBinding
import com.example.carborncash.fragment.MainFragment
import com.example.carborncash.fragment.loginFragment
import com.example.carborncash.fragment.appRankFragment
import com.example.carborncash.fragment.carbonRankFragment
import com.example.carborncash.fragment.pointStoreFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(loginFragment())


        binding.navigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.pointStoreFragment -> replaceFragment(pointStoreFragment())
                R.id.mainFragment -> replaceFragment(MainFragment())
                R.id.appRankFragment-> replaceFragment(appRankFragment())
                R.id.carbonRankFragment-> replaceFragment(carbonRankFragment())

                else ->{
                }
            }
            true
        }


    }


    fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.mainFrameLayout,fragment)
        fragmentTransaction.commit()
        if (fragment is loginFragment) {
            binding.navigationView.visibility = View.GONE
        } else {
            binding.navigationView.visibility = View.VISIBLE
        }
    }

}


