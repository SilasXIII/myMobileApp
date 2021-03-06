package com.example.esiea_3a.presentation.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea_3a.R
import com.example.esiea_3a.presentation.SingletonAPI
import com.example.esiea_3a.presentation.api.JikanSeasonalResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = AnimeAdapter(listOf(),::onClickedAnime)


    private val layoutManager = LinearLayoutManager(context)

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.anime_recyclerview)


        recyclerView.apply {
            layoutManager = this@AnimeListFragment.layoutManager
            adapter = this@AnimeListFragment.adapter
        }

        callAPI()
        
    }


    private fun callAPI() {
        SingletonAPI.jikanApi.getCurrentSeasonals()
            .enqueue(object : Callback<JikanSeasonalResponse> {
                override fun onFailure(call: Call<JikanSeasonalResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

                override fun onResponse(
                    call: Call<JikanSeasonalResponse>,
                    response: Response<JikanSeasonalResponse>
                ) {
                    if (response.isSuccessful && response.body() != null) {
                        val jikanResponse: JikanSeasonalResponse = response.body()!!
                        adapter.UpdateList(jikanResponse.anime)
                    }
                }

            })
    }

    private fun onClickedAnime(anime: Anime) {
        findNavController().navigate(R.id.navigateToAnimeDetailFragment, bundleOf(
            "title" to anime.title,
            "image_url" to anime.image_url,
            "synopsis" to anime.synopsis
        ))
    }
}