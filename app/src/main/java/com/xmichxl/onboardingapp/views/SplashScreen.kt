package com.xmichxl.onboardingapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.xmichxl.onboardingapp.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController, store: Boolean) {

    var screen by remember { mutableStateOf("") }

    screen = if (store) {
        "Home"
    } else {
        "OnBoarding"
    }

    LaunchedEffect(key1 = true) {
        delay(2000)
        navController.navigate(screen) {
            popUpTo(0) //evitar volver a la pantalla anterior
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Image(painter = painterResource(id = R.drawable.cato), contentDescription = "Logo")
    }
}