package com.xmichxl.onboardingapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.xmichxl.onboardingapp.dataStore.StoreBoarding
import com.xmichxl.onboardingapp.onBoardViews.MainOnBoarding
import com.xmichxl.onboardingapp.views.HomeView
import com.xmichxl.onboardingapp.views.SplashScreen

@Composable
fun NavManager(){
    val context = LocalContext.current
    val dataStore = StoreBoarding(context)
    val store = dataStore.getBoarding.collectAsState(initial = false)

    val navController = rememberNavController()
    NavHost(navController, startDestination = if(store.value) "Home" else "Splash"){
        composable("OnBoarding"){
            MainOnBoarding(navController, dataStore)
        }
        composable("Home"){
            HomeView(navController)
        }
        composable("Splash"){
            SplashScreen(navController, store.value)
        }
    }
}