package com.varma.hemanshu.superheroes

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.varma.hemanshu.superheroes.repository.HeroesRepo
import com.varma.hemanshu.superheroes.ui.heroesscreen.HeroesList
import com.varma.hemanshu.superheroes.ui.theme.SuperHeroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperHeroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HeroesApp(modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = modifier, topBar = {
        TopAppBar()
    }, content = { innerPadding ->
        HeroesList(
            heroes = HeroesRepo.heroes,
            modifier = Modifier.padding(innerPadding)
        )
    })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar() {
    CenterAlignedTopAppBar(title = {
        Text(
            text = stringResource(id = R.string.app_name),
            style = MaterialTheme.typography.displayLarge
        )
    })
}

@Preview
@Composable
fun ToolbarPreview() {
    SuperHeroesTheme {
        TopAppBar()
    }
}

@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ToolbarDarkThemePreview() {
    SuperHeroesTheme {
        TopAppBar()
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeroesAppPreview() {
    SuperHeroesTheme {
        HeroesApp()
    }
}