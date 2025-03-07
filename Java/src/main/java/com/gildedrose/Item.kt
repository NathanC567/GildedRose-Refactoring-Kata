package com.gildedrose

class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}
