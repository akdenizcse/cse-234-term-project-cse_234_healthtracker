package com.example.healthtracker.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.healthtracker.Screens.ExerciseScreen
import com.example.healthtracker.Screens.HomeScreen
import com.example.healthtracker.Screens.LogIn
import com.example.healthtracker.Screens.Profile
import com.example.healthtracker.Screens.SignUp

@Composable
fun Nav() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "log_in") {

        composable(route = "log_in") {
            LogIn(navController)
        }

        composable(route = "home_screen") {
            HomeScreen(navController)
        }

        composable(route = "sign_up") {
            SignUp(navController)
        }

        composable(route = "profile") {
            Profile(navController)
        }

        composable(route = "exercise_screen") {
            ExerciseScreen(navController)
        }
    }
}