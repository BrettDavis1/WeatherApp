package com.example.weatherapp.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.*
import com.example.weather_model.AllWeatherRepo
import com.example.weather_model.model.AllWeather
import com.example.weather_model.model.NameWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val _weather = MutableLiveData<AllWeather>()
    val weather: LiveData<AllWeather> get() = _weather

    private val _nameWeather = MutableLiveData<NameWeather>()
    val nameWeather: LiveData<NameWeather> get() = _nameWeather
    //only fetch data from api every 10 minutes
    fun getWeather(context: Context, lat: Double, lon: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            val allWeather = AllWeatherRepo.getAllWeather(getApplication(), lat, lon)
            Log.d("WEATHERFRAGMODEL", "getWeather data: $allWeather")
            _weather.postValue(allWeather)
        }
    }
    fun getWeatherLatLon(lat: Double, lon: Double) {
        viewModelScope.launch(Dispatchers.IO) {
            val allWeather = AllWeatherRepo.allWeatherService.getAllWeatherLatLon(lat, lon)
            _weather.postValue(allWeather)
        }
    }
    fun getNameWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            val myNameWeather = AllWeatherRepo.allWeatherService.getNameWeather()
            _nameWeather.postValue(myNameWeather)
        }
    }
}