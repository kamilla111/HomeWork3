package com.example.homework3

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.homework3.databinding.FragmentBlankBinding
import com.example.homework3.utils.showSnackbar
import kotlin.random.Random

class BlankFragment : Fragment(R.layout.fragment_blank) {

    private var binding: FragmentBlankBinding? = null
    private var adapter: AnimalAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentBlankBinding.bind(view)

        val name = arguments?.getString(ARG_NAME)
        Log.e("BlankFragment", name.orEmpty())

        val pref: SharedPreferences = requireContext().getSharedPreferences("Default", MODE_PRIVATE)

        requireContext().getColor(R.color.white)

        initAdapter()

        binding?.tvTitle?.setOnClickListener {
            adapter?.updateDataset(
                AnimalRepository.list.subList(0, Random.nextInt(8))
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun initAdapter() {
        adapter = AnimalAdapter(
            list = AnimalRepository.list,
            glide = Glide.with(this),
            onItemClick = { city ->
                binding?.root?.showSnackbar(city.name)
            }
        )
        binding?.rvAnimal?.adapter = adapter
        binding?.rvAnimal?.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    companion object {

        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_AGE = "ARG_AGE"

        fun createBundle(name: String, age: Int): Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_NAME, name)
            bundle.putInt(ARG_AGE, age)
            return bundle
        }
    }
}