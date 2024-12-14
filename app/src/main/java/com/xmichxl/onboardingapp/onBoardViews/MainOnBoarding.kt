package com.xmichxl.onboardingapp.onBoardViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import com.xmichxl.onboardingapp.R
import com.xmichxl.onboardingapp.data.PageData
import com.xmichxl.onboardingapp.dataStore.StoreBoarding

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MainOnBoarding(navController: NavController, store: StoreBoarding) {
    val items = ArrayList<PageData>()

    items.add(
        PageData(
            R.raw.page1,
            "Title 1",
            "Description number one"
        )
    )
    items.add(
        PageData(
            R.raw.page2,
            "Title 2",
            "Description number 22222"
        )
    )
    items.add(
        PageData(
            R.raw.page3,
            "Title 3",
            "Description number on33e"
        )
    )

    val pagerState = rememberPagerState(
        pageCount = items.size,
        initialOffscreenLimit = 2,
        infiniteLoop = false,
        initialPage = 0
    )

    OnBoardingPager(
        item = items,
        pagerState = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight()
            .background(Color.White),
        navController,
        store
    )

}