package com.gog.finalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.gog.finalapp.fragments.AboutFragment
import com.gog.finalapp.fragments.HomeFragment
import com.gog.finalapp.fragments.InfoFragment
import com.gog.finalapp.fragments.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val infoFragment = InfoFragment()
    private val aboutFragment = AboutFragment()
    private val listFragment = ListFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_info -> replaceFragment(infoFragment)
                R.id.ic_about -> replaceFragment(aboutFragment)
                R.id.ic_list -> replaceFragment(listFragment)
            }
            true
        }
    }

    private fun replaceFragment(fragment: Fragment){
        if(fragment !=null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}