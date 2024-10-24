package com.mvvmcleanarchitecturedemo.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mvvmcleanarchitecturedemo.R
import com.mvvmcleanarchitecturedemo.databinding.FragmentMealDetailsBinding

class MealDetailsFragment : Fragment() {
    private lateinit var binding: FragmentMealDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_meal_details, container, false)
    }
}