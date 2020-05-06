package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.myapplication.data.gitDataModel
import com.example.myapplication.data.weatherDataModel
import com.example.myapplication.util.weatherOKHttpRestofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_weather_sample.*
import kotlinx.android.synthetic.main.gitdata_recycleview_items.view.*

class WeatherSampleActivity : AppCompatActivity() {

    val TAG: String = "mong WeatherSampleActivity"
    private val APPID = "71471abb1288c92287fa3a13f6b3a06e";

    @SuppressLint("CheckResult", "LongLogTag")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_sample)

        initUI()

        // RxJava get data https://api.openweathermap.org/data/2.5/weather?lat={latitude}&lon={longtitude}&appid={appidkey}
        val adapter = weatherOKHttpRestofit.getInstance()
        adapter.getCurrentWeatherData("37.503582","126.765932",APPID)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Error")
            }
            .subscribe { result ->
                Log.d(TAG, "subscribe good")
                Log.d(TAG, "coord : " + result.getCoord()?.getlat())
                Log.d(TAG, "Description : " + result.getWeather()?.get(0)?.getDescription())
                Log.d(TAG, "country : " + result.getSys()?.getCountry())
                Log.d(TAG, "city : " + result.getName())

                var iCon = result.getWeather()?.get(0)?.getIcon().toString()
                var location = result.getSys()?.getCountry() + " ," + result.getName()
                var descript = result.getWeather()?.get(0)?.getDescription().toString()
                setCurWeather(iCon, location, descript)
            }
    }





    ////////////////////////////////////////////////////////////////
    // UI set
    ////////////////////////////////////////////////////////////////
    private fun initUI() {
        sample3_PrevButton.setOnClickListener{
            val prevActivityIntnent = Intent(this, RestfulSampleActivity::class.java)
            prevActivityIntnent.putExtra("prevTestString","prev sec activity -> first activity")
            prevActivityIntnent.putExtra("precTestInt",1)
            startActivity(prevActivityIntnent)
        }

        sample3_NextButton.setOnClickListener{
            val nextActivityIntnent = Intent(this, WeatherSampleActivity::class.java)
            nextActivityIntnent.putExtra("nextTestString","next sec activity -> third activity")
            nextActivityIntnent.putExtra("nextTestInt",3)
            startActivity(nextActivityIntnent)
        }

        sample3_textview_sample?.text = "openWeathermap api - RxJava + Retrofit2.0 + OKHTTP 3.0"
    }

    @SuppressLint("LongLogTag")
    private fun setCurWeather(icon : String, location : String, description : String) {
        Log.d(TAG, "icon : " + icon)
        Log.d(TAG, "location : " + location)
        Log.d(TAG, "description : " + description)

        var image_icon = "https://openweathermap.org/img/wn/" + icon + "@2x.png"

        // glide - show weather api image
        Glide
            .with(this)
            .load(image_icon)
            .override(200, 200)
            .into(sample3_imageview_icon)
        sample3_textview_location?.text = location
        sample3_textview_description?.text = description

    }
}
