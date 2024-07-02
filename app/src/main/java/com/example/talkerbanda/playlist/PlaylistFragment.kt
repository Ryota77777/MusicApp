package com.example.talkerbanda.playlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.talkerbanda.R
import com.example.talkerbanda.databinding.FragmentPlaylistBinding
import com.example.talkerbanda.viewmodel.PlaylistViewModel

class PlaylistFragment : Fragment() {

    private lateinit var binding: FragmentPlaylistBinding
    private lateinit var viewModel: PlaylistViewModel
    private lateinit var adapter: TrackAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_playlist, container, false)
        viewModel = ViewModelProvider(this)[PlaylistViewModel::class.java]

        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        adapter = TrackAdapter(requireContext())
        binding.playlistList.adapter = adapter

        viewModel.tracks.observe(viewLifecycleOwner) { tracks ->
            adapter.updateData(tracks)
        }

        return binding.root
    }
}













