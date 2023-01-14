package com.example.gameofthrones_retrofit.models

data class Hero(
    var name: String,
    var culture: String,
    var born : String,
    var titles: List<String>,
    var aliases: List<String>,
    var playedBy: List<String>,)