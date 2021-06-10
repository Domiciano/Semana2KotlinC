package edu.co.icesi.semana2kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeActivity : AppCompatActivity() {

    private lateinit var navigator: BottomNavigationView
    private lateinit var listItemFragment: ListItemFragment
    private lateinit var newItemFragment: NewItemFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        navigator = findViewById(R.id.navigator)

        listItemFragment = ListItemFragment.newInstance()
        newItemFragment = NewItemFragment.newInstance()

        //Suscripción (Patrón observer)
        newItemFragment.listener = listItemFragment

        showFragment(newItemFragment)

        navigator.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.newitem -> showFragment(newItemFragment)
                R.id.listitem -> showFragment(listItemFragment)
            }
            true
        }
    }

    private fun showFragment(fragment: Fragment?) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment!!)
        transaction.commit()
    }
}