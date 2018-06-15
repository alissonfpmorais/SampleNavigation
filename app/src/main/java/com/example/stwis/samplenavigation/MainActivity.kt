package com.example.stwis.samplenavigation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavigationUI.setupActionBarWithNavController(this, findNavController(R.id.mainNavHost), drawerLayout)
        NavigationUI.setupWithNavController(navigation, findNavController(R.id.mainNavHost))

        floatingBt.setOnClickListener {
            val transactionId = R.id.transactionListFragment
            val navController = findNavController(R.id.mainNavHost)

            if (navController.currentDestination.id != transactionId) navController.navigate(transactionId)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        NavigationUI.navigateUp(drawerLayout, findNavController(R.id.mainNavHost))
        return super.onSupportNavigateUp()
    }
}
