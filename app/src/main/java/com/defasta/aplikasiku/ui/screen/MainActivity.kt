package com.defasta.aplikasiku.ui.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.defasta.aplikasiku.R
import com.defasta.aplikasiku.data.response.MovieResponse
import com.defasta.aplikasiku.data.response.Search
import com.defasta.aplikasiku.network.ApiServiceBuilder
import com.defasta.aplikasiku.network.MovieApiService
import com.defasta.aplikasiku.ui.adapter.MovieAdapter
import com.defasta.aplikasiku.ui.model.ModelSepeda
import com.defasta.aplikasiku.ui.adapter.SepedaAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_row.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() , RecyclerViewClickListener{
    private val sepedaList = ArrayList<ModelSepeda>()
    private lateinit var sepedaAdapter: SepedaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "Belajar Kotlin"

        loadMovies()

        btnToProfile.isVisible = false
        btnToProfileWithData.isVisible = false

        btnToProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }

        btnToProfileWithData.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            intent.putExtra("key1", "Data dari main activity")
            startActivity(intent)
        }
    }

    private fun prepareDataSepeda(){
        var sepeda = ModelSepeda("Sepeda AA", "BMX", "2022")
        sepedaList.add(sepeda)
        sepeda = ModelSepeda("Sepeda AA", "BMX", "2022")
        sepedaList.add(sepeda)
        sepedaAdapter.notifyDataSetChanged()
    }

    override fun onItemClicked(view: View, modelSepeda: ModelSepeda) {
        val intent = Intent(this, ProfileActivity::class.java)
        intent.putExtra("key1", "Data dari item ${modelSepeda.getNama()}")
        startActivity(intent)
    }

    override fun onItemMovieClicked(view: View, itemMovie: Search) {
        TODO("Not yet implemented")
    }

    private fun loadMovies(){
        //initiate the service
        val destinationService  = ApiServiceBuilder.buildService(MovieApiService::class.java)
        val requestCall = destinationService.getMovies("69021349", "starwars")
        //make network call asynchronously
        requestCall.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful){
                    val countryList  = response.body()!!.search
                    Log.d("Response", "countrylist size : ${countryList.size}")
                    recyclerView.apply {
                        setHasFixedSize(true)
                        layoutManager = LinearLayoutManager(this@MainActivity)
                        adapter = MovieAdapter(response.body()!!.search)
                    }
                }else{
                    Toast.makeText(this@MainActivity, "Something went wrong ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }
            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Something went wrong $t", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
