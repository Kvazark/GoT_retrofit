package com.example.gameofthrones_retrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gameofthrones_retrofit.models.Hero
import com.example.gameofthrones_retrofit.services.Common
import com.example.gameofthrones_retrofit.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), ActivityCompat.OnRequestPermissionsResultCallback {
    private lateinit var retService: RetrofitService
    lateinit var heroAdapter: HeroAdapter
    lateinit var layouManager: LinearLayoutManager
    private lateinit var heroRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        retService = Common.retrofitService
        heroRecyclerView = findViewById(R.id.content)
        layouManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        heroRecyclerView.layoutManager = layouManager

        requestData(11)
    }

    @SuppressLint("SuspiciousIndentation")
    private fun requestData(_page: Int) {

        var page = _page
        val heroes: MutableList<Hero> = mutableListOf()

        retService.getHeroesList(page,50)
            .enqueue(object : Callback<MutableList<Hero>> {
                override fun onResponse(
                    call: Call<MutableList<Hero>>,
                    response: Response<MutableList<Hero>>
                ) {
                    heroes.addAll(response.body()!!.toList())

                    heroAdapter =
                        HeroAdapter(this@MainActivity, heroes)
                    heroRecyclerView.adapter = heroAdapter
                    heroAdapter.notifyDataSetChanged()
                }
                override fun onFailure(call: Call<MutableList<Hero>>, t: Throwable) {}
            })

    }
}