package com.example.weatherapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.databinding.HourlyItemBinding
import com.example.weatherapp.model.Hourly
import java.util.*

class HourlyWeatherAdapter(val hourlyWeather: List<Hourly>):
    RecyclerView.Adapter<HourlyWeatherAdapter.HourlyWeatherHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyWeatherHolder {
        val binding : HourlyItemBinding = HourlyItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return HourlyWeatherHolder(binding)
    }

    override fun getItemCount(): Int {
        return hourlyWeather.size
    }

    override fun onBindViewHolder(holder: HourlyWeatherHolder, position: Int) {
        holder.setHourly(hourlyWeather[position])
    }
    class HourlyWeatherHolder(val binding: HourlyItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun setHourly(hourly: Hourly) {
            //°
            binding.tvDegree.text = "${hourly.temp}°"
            if(hourly.pop != 0.0) {
                binding.tvRain.text = "${(hourly.pop?.times(100))?.toInt()}%"
            }
            binding.tvTime.text = hourly.dt?.let { getHour(it) }
            Glide.with(this.itemView)
                .load("http://openweathermap.org/img/wn/${hourly.weather?.get(0)?.icon}@2x.png")
                .into(binding.svCloud)
        }
        private fun getHour(time: Long) : String {
            val cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
            cal.timeInMillis = (time * 1000L)
            return if(cal[Calendar.HOUR_OF_DAY] == 0) {
                "12PM"
            } else if(cal[Calendar.HOUR_OF_DAY] > 12) {
                "${cal[Calendar.HOUR_OF_DAY]-12}PM"
            } else {
                "${cal[Calendar.HOUR_OF_DAY]}AM"
            }
        }
    }
}