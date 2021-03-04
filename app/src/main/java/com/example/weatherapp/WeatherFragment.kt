package com.example.weatherapp

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
import com.example.weather_model.BuildConfig
import java.util.*

class WeatherFragment : Fragment() {
   private lateinit var binding: FragmentWeatherBinding
    private val viewModel by viewModels<WeatherFragmentViewModel>()
    private var startTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startTime = Calendar.getInstance().timeInMillis
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
//            binding.tvHigh.text = "H:${it.main?.tempMax}°"
            binding.tvHigh.text = String.format("H:%d°", it.main?.tempMin?.toInt())
            binding.tvCity.text = it.name
            binding.tvDegree.text = String.format("H:%d°", it.main?.temp?.toInt())
            binding.tvLow.text = String.format("H:%d°", it.main?.tempMax?.toInt())
//            binding.tvLow.text = "L:${it.main?.tempMin}°"
            binding.tvWeatherType.text = it.weather?.get(0)?.main
            it.coord?.lat?.let { lat -> it.coord!!.lon?.let { lon ->
                viewModel.getWeather(requireContext(),lat, lon)
            } }
        })
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
                it.alerts!!.forEach { alert ->
                    alertMsg.plus(alert.event+ " ")
                }
                binding.tvNationalWeatherService.text = alertMsg
            }
        })
    }
}
// possible datastore method
//    val dataStore: DataStore<Preferences> = requireContext().createDataStore(
//            name = "start_time"
//    )
//    val MY_START_TIME = preferencesKey<Long>("my_start_time")
//    val myStartTime: Flow<Long> = dataStore.data
//            .map { currentPreferences ->
//                currentPreferences[MY_START_TIME] ?: 0
//            }
//    suspend fun setTime() {
//        dataStore.edit { startTime ->
//            startTime[MY_START_TIME] = Calendar.getInstance().timeInMillis
//        }
//    }