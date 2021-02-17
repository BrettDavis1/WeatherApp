package com.example.weatherapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.model.AllWeather
import com.example.weatherapp.model.NameWeather
import com.example.weatherapp.repo.AllWeatherRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WeatherFragmentViewModel : ViewModel() {
    private val _weather = MutableLiveData<AllWeather>()
    val weather: LiveData<AllWeather> get() = _weather

    private val _nameWeather = MutableLiveData<NameWeather>()
    val nameWeather: LiveData<NameWeather> get() = _nameWeather

    fun getWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            val allWeather = AllWeatherRepo.allWeatherService.getAllWeather()
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