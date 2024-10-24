package com.mvvmcleanarchitecturedemo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mvvmcleanarchitecturedemo.presentation.viewmodel.MealSearchViewModel

class MainActivity : AppCompatActivity() {
    val mealSearchViewModel : MealSearchViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}