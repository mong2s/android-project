package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.GitData
import com.example.myapplication.util.Contributors
import com.example.myapplication.util.OKHttpRetrofit
import com.example.myapplication.view.ReCycleAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_restful_sample.*

class RestfulSampleActivity : AppCompatActivity() {

    val TAG: String = "mong2s"

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restful_sample)

        initUI()

        // RxJava get data api.github.com/user/username
        val adapter = OKHttpRetrofit.getInstance()
        adapter.requestContributors("mong2s", "android-project")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .doOnError {
                Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                Log.d(TAG, "Error")
            }
            .unsubscribeOn(Schedulers.io())
            .onErrorReturn { t: Throwable ->
                Log.d(TAG, "ErrorReturn : " + t.message)
                arrayOf(Contributors())
            }
            .subscribe { result ->
                if ("User" == result[0].getType()) {
                    Log.d(TAG, "subscribe good")
                    Log.d(TAG, "LogIn : " + result[0].getLogin())
                    Log.d(TAG, "ID : " + result[0].getId())
                    Log.d(TAG, "Node ID : " + result[0].getNodeId())
                    Log.d(TAG, "URL : " + result[0].getUrl())
                    Log.d(TAG, "html : " + result[0].getHtmlUrl())
                    Log.d(TAG, "type : " + result[0].getType())

                    val gitDataList = arrayListOf<GitData>()
                    gitDataList.add(GitData("Login", result[0].getLogin().toString(), "login"))
                    gitDataList.add(GitData("ID", result[0].getId().toString(), ""))
                    gitDataList.add(GitData("URL", result[0].getUrl().toString(), ""))
                    gitDataList.add(GitData("html", result[0].getHtmlUrl().toString(), ""))


                    val mAdapter = ReCycleAdapter(this, gitDataList)
                    sample2_recycleview.adapter = mAdapter

                    val lm = LinearLayoutManager(this)
                    sample2_recycleview.layoutManager = lm
                    sample2_recycleview.setHasFixedSize(true)
                } else {
                    Log.d(TAG, "subscribe bad")
                }
            }
    }



    ////////////////////////////////////////////////////////////////
    // UI set
    ////////////////////////////////////////////////////////////////
    private fun initUI() {
        sample2_PrevButton.setOnClickListener{
            val prevActivityIntnent = Intent(this, MainActivity::class.java)
            prevActivityIntnent.putExtra("prevTestString","prev sec activity -> first activity")
            prevActivityIntnent.putExtra("precTestInt",1)
            startActivity(prevActivityIntnent)
        }

        sample2_NextButton.setOnClickListener{
            val nextActivityIntnent = Intent(this, MainActivity::class.java)
            nextActivityIntnent.putExtra("nextTestString","next sec activity -> third activity")
            nextActivityIntnent.putExtra("nextTestInt",3)
            startActivity(nextActivityIntnent)
        }
    }
}
