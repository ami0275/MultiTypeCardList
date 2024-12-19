package com.amitraj.multitypecardlist.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Material3CardListWithReset(modifier: Modifier) {
    var items by remember { mutableStateOf(generateItems()) }

    Column(modifier = Modifier.fillMaxSize()) {

        // Reset Button
        Button(
            onClick = { items = generateItems() }, // Reset the list with new items
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp),
            shape = MaterialTheme.shapes.small
        ) {
            Text(text = "Reset List")
        }

        // List of cards
        MultiTypeCardList(
            items = items,
            modifier = modifier
                .fillMaxWidth()
        )

    }
}

@Composable
fun MultiTypeCardList(items: List<CardItem>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(items) { item ->
            when (item) {
                is CardItem.TextCard -> TextCardComposable(item)
                is CardItem.ImageCard -> ImageCardComposable(item)
                is CardItem.ActionCard -> ActionCardComposable(item)
            }
        }
    }
}


fun generateItems(): List<CardItem> {
    val dummyUrls = listOf(
        "https://picsum.photos/200",
        "https://placebear.com/300/200",
        "https://dummyimage.com/300x200/000/fff&text=Sample+Image",
        "https://via.placeholder.com/300x200",
        "https://loremflickr.com/300/200",
        "https://baconmockup.com/300/200",   // Bacon-themed images
        "https://placebeard.it/300x200",     // Beard-themed placeholder images
        "https://stevensegallery.com/300/200", // Steven Seagal-themed images
        "https://via.placeholder.com/400x300?text=Placeholder+400x300",
        "https://picsum.photos/400/300",      // Random high-quality images
        "https://loremflickr.com/400/300/nature", // Random nature images
    )

    return listOf(
        CardItem.TextCard(
            title = "Text Card ${System.currentTimeMillis()}",
            description = "This is a randomly generated text card."
        ),
        CardItem.ImageCard(
            imageUrl = dummyUrls.random(),
            title = "Image Card ${System.currentTimeMillis()}"
        ),
        CardItem.ActionCard(
            title = "Action Card ${System.currentTimeMillis()}",
            onClick = { println("Action clicked!") }
        ),
        CardItem.TextCard(
            title = "Text Card 1 ${System.currentTimeMillis()}",
            description = "This is a randomly generated text card. 1"
        ),
        CardItem.ImageCard(
            imageUrl = dummyUrls.random(),
            title = "Image Card ${System.currentTimeMillis()}"
        ),
        CardItem.ImageCard(
            imageUrl = dummyUrls.random(),
            title = "Image Card ${System.currentTimeMillis()}"
        ),
        CardItem.ActionCard(
            title = "Action Card 1 ${System.currentTimeMillis()}",
            onClick = { println("Action clicked!") }
        )
    )
}

