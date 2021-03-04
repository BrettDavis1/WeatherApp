package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.weatherapp.viewmodel.WeatherFragmentViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<WeatherFragmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}