package com.mvvmcleanarchitecturedemo.presentation.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.mvvmcleanarchitecturedemo.databinding.FragmentMealSerachBinding
import com.mvvmcleanarchitecturedemo.presentation.viewmodel.MealSearchViewModel
import com.mvvmcleanarchitecturedemo.utils.ApiResponseCallBack
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class MealSearchFragment : Fragment() {

    private lateinit var binding: FragmentMealSerachBinding
    val mealSearchViewModel: MealSearchViewModel by viewModels()
    private lateinit var myContext: Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.myContext = context
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMealSerachBinding.inflate(inflater, container, false)
        observerSearchData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.searchView.setOnQueryTextListener(object :
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    mealSearchViewModel.searchMeal(query)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }

    private fun observerSearchData() {

        lifecycleScope.launch {
            mealSearchViewModel.mealSearch.collect {
                when (it) {
                    is ApiResponseCallBack.Failed -> {
                        binding.progress.visibility = View.GONE
                        Toast.makeText(myContext, it.message, Toast.LENGTH_SHORT).show()
                    }

                    is ApiResponseCallBack.Loading -> {
                        binding.progress.visibility = View.VISIBLE
                    }

                    is ApiResponseCallBack.Success -> {
                        binding.progress.visibility = View.GONE
                        Log.d("data", "observerSearchData: ${it.data}")
                    }
                }

            }
        }
    }

}