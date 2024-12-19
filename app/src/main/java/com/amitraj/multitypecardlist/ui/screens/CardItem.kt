package com.amitraj.multitypecardlist.ui.screens

sealed class CardItem {
    data class TextCard(val title: String, val description: String) : CardItem()
    data class ImageCard(val imageUrl: String, val title: String) : CardItem()
    data class ActionCard(val title: String, val onClick: () -> Unit) : CardItem()
}
