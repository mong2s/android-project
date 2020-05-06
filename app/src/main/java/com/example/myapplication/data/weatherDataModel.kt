package com.example.myapplication.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class weatherDataModel {

    @SerializedName("coord")
    @Expose
    private var coord: Coord? = null
    @SerializedName("sys")
    @Expose
    private var sys: Sys? = null
    @SerializedName("weather")
    @Expose
    private var weather: ArrayList<Weather>? = null
    @SerializedName("main")
    @Expose
    private var main: Main? = null
    @SerializedName("wind")
    @Expose
    private var wind: Wind? = null
    @SerializedName("rain")
    @Expose
    private var rain: Rain? = null
    @SerializedName("clouds")
    @Expose
    private var clouds: Clouds? = null
    @SerializedName("dt")
    @Expose
    private var dt: Float? = null
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("name")
    @Expose
    private var name: String? = null
    @SerializedName("cod")
    @Expose
    private var cod: Int? = null


    fun getCoord(): Coord? {
        return coord
    }

    fun setCoord(coord: Coord) {
        this.coord = coord
    }

    fun getSys(): Sys? {
        return sys
    }

    fun setSys(sys: Sys) {
        this.sys = sys
    }

    fun getWeather(): ArrayList<Weather>? {
        return weather
    }

    fun setWeather(weather: ArrayList<Weather>?) {
        this.weather = weather
    }

    fun getMain(): Main? {
        return main
    }

    fun setMain(main: Main) {
        this.main = main
    }

    fun getWind(): Wind? {
        return wind
    }

    fun setWind(wind: Wind) {
        this.wind = wind
    }

    fun getRain(): Rain? {
        return rain
    }

    fun setRain(rain: Rain) {
        this.rain = rain
    }

    fun getClouds(): Clouds? {
        return clouds
    }

    fun setClouds(clouds: Clouds) {
        this.clouds = clouds
    }


    fun getDt(): Float? {
        return dt
    }

    fun setDt(dt: Float) {
        this.dt = dt
    }

    fun getId(): Int? {
        return id
    }

    fun setId(id: Int) {
        this.id = id
    }

    fun getName(): String? {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }

    fun getCod(): Int? {
        return cod
    }

    fun setLogin(cod: Int) {
        this.cod = cod
    }
}


class Coord {
    @SerializedName("lon")
    @Expose
    private var lon: Float? = null
    @SerializedName("lat")
    @Expose
    private var lat: Float? = null

    fun getlon(): Float? {
        return lon
    }

    fun setlon(lon: Float) {
        this.lon = lon
    }

    fun getlat(): Float? {
        return lat
    }

    fun setlat(lat: Float) {
        this.lat = lon
    }
}

class Sys {
    @SerializedName("country")
    @Expose
    private var country: String? = null
    @SerializedName("sunrise")
    @Expose
    private var sunrise: Long? = null
    @SerializedName("sunset")
    @Expose
    private var sunset: Long? = null

    fun getCountry(): String? {
        return country
    }

    fun setCountry(country : String) {
        this.country = country
    }

    fun getSunrise(): Long? {
        return sunrise
    }

    fun setSunrise(sunrise : Long) {
        this.sunrise = sunrise
    }

    fun getSunset(): Long? {
        return sunset
    }

    fun setSunset(sunset : Long) {
        this.sunset = sunset
    }

}

class Weather {
    @SerializedName("id")
    @Expose
    private var id: Int? = null
    @SerializedName("main")
    @Expose
    private var main: String? = null
    @SerializedName("description")
    @Expose
    private var description: String? = null
    @SerializedName("icon")
    @Expose
    private var icon: String? = null

    fun getId() : Int? {
        return id
    }

    fun setId(id : Int) {
        this.id = id
    }

    fun getMain() : String? {
        return main
    }

    fun setMain(main : String) {
        this.main = main
    }

    fun getDescription() : String? {
        return description
    }

    fun setDescription(description : String) {
        this.description = description
    }

    fun getIcon() : String? {
        return icon
    }

    fun setIcon(icon : String) {
        this.icon = icon
    }
}

class Main {
    @SerializedName("temp")
    @Expose
    private var temp: Float? = null
    @SerializedName("humidity")
    @Expose
    private var humidity: Float? = null
    @SerializedName("pressure")
    @Expose
    private var pressure: Float? = null
    @SerializedName("temp_min")
    @Expose
    private var temp_min: Float? = null
    @SerializedName("temp_max")
    @Expose
    private var temp_max: Float? = null

    fun getTemp() : Float? {
        return temp
    }

    fun setTemp(temp: Float) {
        this.temp = temp
    }

    fun getHumidity() : Float? {
        return humidity
    }

    fun setHumidity(humidity: Float) {
        this.humidity = humidity
    }

    fun getPressure() : Float? {
        return pressure
    }

    fun setPressure(pressure: Float) {
        this.pressure = pressure
    }

    fun getTemp_min() : Float? {
        return temp_min
    }

    fun setTemp_min(temp_min: Float) {
        this.temp_min = temp_min
    }

    fun getTemp_max() : Float? {
        return temp_max
    }

    fun setTemp_max(temp_max: Float) {
        this.temp_max = temp_max
    }
}

class Wind {
    @SerializedName("speed")
    @Expose
    private var speed: Float? = null
    @SerializedName("deg")
    @Expose
    private var deg: Float? = null

    fun getSpeed() : Float? {
        return speed
    }

    fun setSpeed(speed: Float) {
        this.speed = speed
    }

    fun getDeg() : Float? {
        return deg
    }

    fun setDeg(deg: Float) {
        this.deg = deg
    }
}

class Rain {
    @SerializedName("r3h")
    @Expose
    private var r3h: Float? = null

    fun getRain() : Float? {
        return r3h
    }

    fun setRain(r3h: Float) {
        this.r3h = r3h
    }
}

class Clouds {
    @SerializedName("all")
    @Expose
    private var all: Float? = null

    fun getClouds() : Float? {
        return all
    }

    fun setClouds(all: Float) {
        this.all = all
    }
}