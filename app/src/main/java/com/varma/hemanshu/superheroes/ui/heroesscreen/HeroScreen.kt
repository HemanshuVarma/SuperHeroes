package com.varma.hemanshu.superheroes.ui.heroesscreen

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.varma.hemanshu.superheroes.R
import com.varma.hemanshu.superheroes.model.Hero
import com.varma.hemanshu.superheroes.ui.theme.SuperHeroesTheme

@Composable
fun HeroesList(heroes: List<Hero>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier,
    ) {
        items(heroes) { hero ->
            HeroItem(
                hero = hero,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}

@Composable
fun HeroItem(hero: Hero, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .sizeIn(minHeight = 72.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(id = hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .size(72.dp)
            ) {
                Image(
                    painter = painterResource(id = hero.imageRes),
                    contentDescription = stringResource(id = hero.nameRes)
                )
            }
        }
    }
}

@Preview(name = "Hero Item Light Preview")
@Composable
fun HeroItemLightPreview() {
    val hero = Hero(
        nameRes = R.string.hero1,
        imageRes = R.drawable.android_superhero1,
        descriptionRes = R.string.description1
    )

    SuperHeroesTheme {
        HeroItem(hero = hero)
    }
}

@Preview(name = "Hero Item Dark Preview", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HeroItemDarkPreview() {
    val hero = Hero(
        nameRes = R.string.hero1,
        imageRes = R.drawable.android_superhero1,
        descriptionRes = R.string.description1
    )

    SuperHeroesTheme {
        HeroItem(hero = hero)
    }
}