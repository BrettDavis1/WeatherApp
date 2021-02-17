package com.example.weatherapp

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weatherapp.adapter.DailyWeatherAdapter
import com.example.weatherapp.adapter.HourlyWeatherAdapter
import com.example.weatherapp.databinding.FragmentWeatherBinding
import com.example.weatherapp.viewmodel.WeatherFragmentViewModel
import java.text.SimpleDateFormat
import java.util.*

class WeatherFragment : Fragment() {
   private lateinit var binding: FragmentWeatherBinding
    private val viewModel by viewModels<WeatherFragmentViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentWeatherBinding.inflate(
        inflater,
        container,
        false
    ).also { binding = it }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getNameWeather()
        viewModel.nameWeather.observe(this.viewLifecycleOwner, androidx.lifecycle.Observer {
            binding.tvHigh.text = "H:${it.main?.tempMax}°"
            binding.tvCity.text = it.name
            binding.tvDegree.text = "${it.main?.temp}°"
            binding.tvLow.text = "L:${it.main?.tempMin}°"
            binding.tvWeatherType.text = it.weather?.get(0)?.main
            it.coord?.lat?.let { lat -> it.coord.lon?.let { lon ->
                viewModel.getWeatherLatLon(lat, lon)
            } }
        })
        // dont need this if getWeatherLatLon works
//        viewModel.getWeather()
        viewModel.weather.observe(this.viewLifecycleOwner, androidx.lifecycle.Observer {
            //set adapters
            binding.rvDaily.layoutManager = LinearLayoutManager(this.context)
            binding.rvDaily.adapter = it.daily?.let { daily -> DailyWeatherAdapter(daily) }
            val linearLayoutManager = LinearLayoutManager(this.context)
            linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
            binding.rvHourly.layoutManager = linearLayoutManager
            binding.rvHourly.adapter = it.hourly?.let { hourly -> HourlyWeatherAdapter(hourly) }
            if(!it.alerts.isNullOrEmpty()) {
                var alertMsg = ""
                it.alerts.forEach { alert ->
                    alertMsg.plus(alert.event+ " ")
                }
                binding.tvNationalWeatherService.text = alertMsg
            }
        })
    }
}