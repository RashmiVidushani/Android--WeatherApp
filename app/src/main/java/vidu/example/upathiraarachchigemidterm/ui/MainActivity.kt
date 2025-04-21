package vidu.example.upathiraarachchigemidterm.ui

import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsetsController
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import vidu.example.upathiraarachchigemidterm.R
import vidu.example.upathiraarachchigemidterm.vm.WeatherViewModel
import vidu.example.upathiraarachchigemidterm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var weatherViewModel: WeatherViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        weatherViewModel = ViewModelProvider(this)[WeatherViewModel::class.java]


        binding.buttonSubmit.setOnClickListener {
            val city = binding.editTextCity.text.toString()
            weatherViewModel.fetchWeather(city)
        }

        weatherViewModel.weatherData.observe(this) { data ->
            binding.progressBar.visibility = View.GONE
            val weatherInfo = StringBuilder()
            if (data != null) {
                weatherInfo.append("${data.resolvedAddress} on ${data.currentConditions.datetime}\n")
                weatherInfo.append("Current Temperature: ${data.currentConditions.temp}°C at ${data.currentConditions.datetime}\n")
                weatherInfo.append("Today's Maximum Temperature: ${data.days[0].tempmax}°C\n")
                weatherInfo.append("Today's Minimum Temperature: ${data.days[0].tempmin}°C\n")
                weatherInfo.append("Probability of Precipitation: ${data.days[0].precipprob}\n")
                weatherInfo.append("Today's description: ${data.days[0].description}\n")
            } else {
                weatherInfo.append("Error fetching data.")
            }
            binding.textViewWeather.text = weatherInfo.toString()


        }

        weatherViewModel.isLoading.observe(this) { isLoading ->
            binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
            binding.textViewWeather.visibility = if (isLoading) View.GONE else View.VISIBLE
        }
    }
}