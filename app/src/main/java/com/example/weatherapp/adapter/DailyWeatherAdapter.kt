package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.databinding.DailyItemBinding
import com.example.weatherapp.model.Daily
import java.util.*

class DailyWeatherAdapter(val dailyWeather: List<Daily>):
    RecyclerView.Adapter<DailyWeatherAdapter.DailyWeatherHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyWeatherHolder {
        val binding: DailyItemBinding = DailyItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DailyWeatherHolder(binding)
    }

    override fun getItemCount(): Int {
        return dailyWeather.size
    }

    override fun onBindViewHolder(holder: DailyWeatherHolder, position: Int) {
        holder.setDaily(dailyWeather[position])
    }
    class DailyWeatherHolder(val binding: DailyItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setDaily(daily: Daily) {
            binding.tvHigh.text = "${daily.temp?.max}"
            binding.tvLow.text = "${daily.temp?.min}"
            if(daily.pop != 0.0) {
                binding.tvRain.text = "${((daily.pop)?.times(100))?.toInt()}%"
            }
            binding.tvDay.text = daily.dt?.let { getDay(it) }
            Glide.with(binding.root.context)
                .load("http://openweathermap.org/img/wn/${daily.weather?.get(0)?.icon}.png")
                .into(binding.svCloud)
        }
        private fun getDay(time: Long) : String {
            val cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            cal.timeInMillis = (time * 1000L)
            return when(cal[Calendar.DAY_OF_WEEK]) {
                1 -> "Sunday"
                2 -> "Monday"
                3 -> "Tuesday"
                4 -> "Wednesday"
                5 -> "Thursday"
                6 -> "Friday"
                7 -> "Saturday"
                else -> { return "Incorrect Day of Week"}
            }
        }
    }

}