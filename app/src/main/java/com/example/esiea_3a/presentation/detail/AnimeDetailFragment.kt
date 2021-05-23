package com.example.esiea_3a.presentation.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea_3a.R


class AnimeDetailFragment : Fragment() {

    private lateinit var textViewTitle: TextView
    //private lateinit var textViewTitle: TextView
    //private lateinit var textViewTitle: TextView


    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val title: String = arguments?.getString("title") ?: "no title"

        textViewTitle = view.findViewById(R.id.anime_detail_title)
        textViewTitle.text = title

        view.findViewById<Button>(R.id.button_back_to_list).setOnClickListener {
            findNavController().navigate(R.id.navigateToAnimeListFragment)
        }
    }
}