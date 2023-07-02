package com.example.homework3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private var count = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref = getSharedPreferences("Default", MODE_PRIVATE)
        pref.getInt(ARG_COUNT, -1).takeIf { it > -1 }?.let {
            count = it
        }
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("ARG_COUNT", count)
    }

    companion object {
        private const val ARG_COUNT = "ARG_COUNT"
    }

}