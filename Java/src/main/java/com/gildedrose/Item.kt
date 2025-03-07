@file:Suppress("SpellCheckingInspection")

package com.gildedrose

open class Item(
    val name: String, var sellIn: Int, var quality: Int
) {
    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}

open class BaseItem(name: String, sellIn: Int, quality: Int) : Item(name, sellIn, quality) {
    fun update() {
        updateAge()
        updateQuality()
        resetQuality()
    }

    protected open fun resetQuality() {
        if (quality < 0) quality = 0
        else if (quality > 50) quality = 50
    }

    protected open fun updateAge() {
        sellIn = sellIn - 1
    }

    protected open fun updateQuality() {
        quality -= if (sellIn < 0 && quality != 1) 2 else 1
    }
}

class Brie(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun updateQuality() {
        quality += if (sellIn < 0) 2 else 1
    }
}

class Sulfuras(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun updateAge() {}
    override fun updateQuality() {}
    override fun resetQuality() {}

}

class BackstagePass(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun updateQuality() = when {
        sellIn < 0 -> quality = 0
        sellIn < 5 -> quality += 3
        sellIn < 10 -> quality += 2
        else -> quality += 1
    }
}



