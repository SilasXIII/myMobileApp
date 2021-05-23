package com.example.esiea_3a.presentation.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea_3a.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AnimeListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private val adapter = AnimeAdapter(listOf())
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
        val animeList: ArrayList<Anime> = arrayListOf<Anime>().apply {
            add(Anime("Lucky Star"))
            add(Anime ("Cowboy Bepop"))
            add(Anime ("Vivy: Fluorite Eye's Song"))
        }

        adapter.UpdateList(animeList)
    }
}