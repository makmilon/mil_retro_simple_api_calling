package com.milon.retrofitapicalling

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.milon.retrofitapicalling.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getData()
        binding.memeBtn.setOnClickListener {
            //simple array api calling
            getData()
        }

    }



    private fun getData() {
             RetrofitInstance.apiInterface.getMeme().enqueue(object : Callback<responseDataModel?> {
                 override fun onResponse(
                     call: Call<responseDataModel?>,
                     response: Response<responseDataModel?>
                 ) {
                     binding.memeTitle.text= response.body()?.title
                     binding.memeAuthor.text= response.body()?.author
                     Glide.with(this@MainActivity).load(response.body()?.url).into(binding.memeImage);

                 }

                 override fun onFailure(call: Call<responseDataModel?>, t: Throwable) {
                     Toast.makeText(this@MainActivity, "${t.localizedMessage}", Toast.LENGTH_SHORT).show()
                 }
             })
    }
}