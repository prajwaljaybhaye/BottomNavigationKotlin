package com.codewithandro.bottomnavigationviewday28

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        //home,video,my connection,notifications,jobs

        //create function -> bottomNavigationSetup
        bottomNavigationSetup()//calling
    }

//start -> bottomNavigationSetup function
    private fun bottomNavigationSetup() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        bottomNavigationView.setOnItemSelectedListener {
            //bottom items ids fetch all -> it.itemId
            when(it.itemId){

                //each Item Id Replace the fragmentation pass the -> Fragmentations in parameters
                R.id.homeItem ->replaceFragmentation(homeFragment())
                R.id.videoItem ->replaceFragmentation(videoFragment())
                R.id.connectionsItem ->replaceFragmentation(connectionsFragment())
                R.id.notificationsItem ->replaceFragmentation(notificationsFragment())
                R.id.jobsItem ->replaceFragmentation(jobFragment())

            }
            true
        }
    }
    //start replaceFragmentation Function

    private fun replaceFragmentation(fragment: Fragment) {

        val fragmentManager = supportFragmentManager  //call the supportFragmentManager
        val transactionFragment = fragmentManager.beginTransaction() //manager begin trasations
        transactionFragment.replace(R.id.fragmentView,fragment)//replase the fragment argument
        transactionFragment.commit()
        //create successfully fragments

    }
}