package vidu.example.upathiraarachchigemidterm.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vidu.example.upathiraarachchigemidterm.repostiory.WeatherRepository
import vidu.example.upathiraarachchigemidterm.model.WeatherData

class WeatherViewModel : ViewModel() {
    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData: LiveData<WeatherData> get() = _weatherData
    private val weatherRepository = WeatherRepository()


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> get() = _isLoading

    fun fetchWeather(city: String) {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val data = weatherRepository.getWeather(city)
                _weatherData.value = data
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
}