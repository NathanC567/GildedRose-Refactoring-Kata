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
    }

    protected open fun updateAge() {
        sellIn = sellIn - 1
    }

    protected open fun updateQuality() {
        if (quality > 0) {
            quality -= if (sellIn < 0 && quality != 1) 2 else 1
        }
    }
}

class Brie(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun updateQuality() {
        if (quality < 50) {
            quality += if (sellIn < 0) 2 else 1
        }
    }

}

class Sulfuras(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun updateAge() {}
    override fun updateQuality() {}

}

class BackstagePass(name: String, sellIn: Int, quality: Int) : BaseItem(name, sellIn, quality) {
    override fun updateQuality() {
        if (quality < 50) {
            quality = quality + 1

            if (sellIn < 10) {
                if (quality < 50) {
                    quality = quality + 1
                }
            }

            if (sellIn < 5) {
                if (quality < 50) {
                    quality = quality + 1
                }
            }
        }
        if (sellIn < 0) {
            quality = 0
        }
    }
}



