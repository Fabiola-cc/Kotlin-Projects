package com.example.laboratorio6.navegacion

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.laboratorio6.ui.theme.Coral

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabNavigation() {
    val tabs = listOf(TabItem.Home, TabItem.Places, TabItem.Favorites, TabItem.Profile )
    val pagerState = rememberPagerState { tabs.count() }
    Scaffold(
        topBar = { TopBar() },
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Tabs(tabs = tabs, pagerState = pagerState)
            TabsContent(tabs = tabs, pagerState = pagerState)
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabsContent(tabs: List<TabItem>, pagerState: PagerState) {
    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize()) {page ->
        tabs[page].screen()
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = "Todo Eventos ╰(*°▽°*)╯", fontSize = 18.sp) },
        contentColor = Color.White, backgroundColor = Coral,
        navigationIcon = { Icon(imageVector = Icons.Filled.MoreVert, contentDescription = null) }
    )
}

@Preview(showBackground = true)
@Composable
fun TopBarPreview() {
    TabNavigation()
}