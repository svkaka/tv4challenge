package com.ovrbach.tv4challenge.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ovrbach.tv4challenge.R
import com.ovrbach.tv4challenge.feature.home.HomeFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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