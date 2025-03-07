package com.gildedrose

class Item(name: String?, sellIn: Int, quality: Int) {
    @JvmField
    var name: String? = null

    @JvmField
    var sellIn: Int = 0

    @JvmField
    var quality: Int = 0

    init {
        this.name = name
        this.sellIn = sellIn
        this.quality = quality
    }

    override fun toString(): String {
        return this.name + ", " + this.sellIn + ", " + this.quality
    }
}
