package com.example.talkerbanda.search

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.fragment.app.Fragment
import com.example.talkerbanda.R
import com.example.talkerbanda.databinding.FragmentSearchBinding

class SearchFragment : Fragment(R.layout.fragment_search) {

    private lateinit var binding: FragmentSearchBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSearchBinding.bind(view)

        val filterAuthor: CheckBox = binding.filterAuthor
        val filterInterests: CheckBox = binding.filterInterests
        val filterCountry: CheckBox = binding.filterCountry

        val spinnerAuthor: Spinner = binding.spinnerAuthor
        val spinnerInterests: Spinner = binding.spinnerInterests
        val spinnerCountry: Spinner = binding.spinnerCountry

        val searchField: EditText = binding.searchField
        val filterLayout: LinearLayout = binding.filterLayout

        // Sample data for spinners
        val cityList = listOf("Eminem", "Rihanna", "Jay-Z")
        val interestsList = listOf("Поп", "Рок", "Танцевальная")
        val genderList = listOf("Русские", "Зарубежные")

        // Adapters for spinners
        spinnerAuthor.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, cityList)
        spinnerInterests.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, interestsList)
        spinnerCountry.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, genderList)

        // Toggle spinner visibility based on checkbox state
        filterAuthor.setOnCheckedChangeListener { _, isChecked ->
            spinnerAuthor.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        filterInterests.setOnCheckedChangeListener { _, isChecked ->
            spinnerInterests.visibility = if (isChecked) View.VISIBLE else View.GONE
        }
        filterCountry.setOnCheckedChangeListener { _, isChecked ->
            spinnerCountry.visibility = if (isChecked) View.VISIBLE else View.GONE
        }

        // Show filters on search field click
        searchField.setOnClickListener {
            if (filterLayout.visibility == View.GONE) {
                filterLayout.visibility = View.VISIBLE
                // Optional: Add animation
                filterLayout.animate().alpha(1.0f).setDuration(300).start()
            }
        }
    }
}






