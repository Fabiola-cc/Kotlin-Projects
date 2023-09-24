package com.example.laboratorio6.navegacion

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Icon
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.Text
import androidx.compose.material3.LeadingIconTab
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laboratorio6.ui.theme.Apricot
import com.google.accompanist.pager.pagerTabIndicatorOffset
import kotlinx.coroutines.launch

/**
 * Contenido de barra y formato general
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(tabs: List<TabItem>, pagerState: PagerState) {
    val scope = rememberCoroutineScope()

    TabRow( //Barra de pestañas
        selectedTabIndex = pagerState.currentPage,
        backgroundColor = Apricot,
        contentColor = Color.Black,
        indicator = { tabPositions ->
            TabRowDefaults.Indicator(
                Modifier.pagerTabIndicatorOffset(pagerState, tabPositions)
            )
        }) {
        tabs.forEachIndexed { index, tab ->
            LeadingIconTab( //Mostrar los elementos de cada objeto
                icon = { Icon(imageVector = tab.icon, contentDescription = null,
                    modifier = Modifier.width(15.dp)) },
                text = { Text(tab.title, fontSize = 10.sp) },
                selected = pagerState.currentPage == index,
                onClick = {
                    scope.launch {
                        pagerState.animateScrollToPage(index)
                    }
                },
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TabsPreview() {
    val tabs = listOf(
        TabItem.Profile, TabItem.Home
    )
    val pagerState = rememberPagerState { tabs.count() }
    Tabs(tabs = tabs, pagerState = pagerState)
}