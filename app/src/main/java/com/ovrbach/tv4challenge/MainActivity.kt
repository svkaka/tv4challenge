package com.ovrbach.tv4challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ovrbach.tv4challenge.ui.main.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container, HomeFragment.newInstance())
                    .commitNow()
        }
    }
}