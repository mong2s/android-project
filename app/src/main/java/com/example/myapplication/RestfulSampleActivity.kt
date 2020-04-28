package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.myapplication.util.Contributors
import com.example.myapplication.util.OKHttpRetrofit
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class RestfulSampleActivity : AppCompatActivity() {

    val TAG: String = "mong2s"

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restful_sample)

        val adapter = OKHttpRetrofit.getInstance()
        adapter.requestContributors("mong2s", "GetPackagesName")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                Toast.makeText(this, "doOnError", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "doOnError")
            }
            .unsubscribeOn(Schedulers.io())
            .onErrorReturn { t: Throwable ->
                Log.d(TAG, "onErrorReturn : " + t.message)
                arrayOf(Contributors())
            }
            .subscribe { result ->
                if ("User" == result[0].getType()) {
                    Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show()
                    Log.d(TAG, "subscribe good")
                } else {
                    Log.d(TAG, "subscribe bad")
                }
            }


    }
}
