package com.varma.hemanshu.superheroes

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                    HeroesList(heroes = HeroesRepo.heroes)
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun HeroesListLightPreview() {
    SuperHeroesTheme {
        HeroesList(heroes = HeroesRepo.heroes)
    }
}

@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroesListDarkPreview() {
    SuperHeroesTheme {
        HeroesList(heroes = HeroesRepo.heroes)
    }
}