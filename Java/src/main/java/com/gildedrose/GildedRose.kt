@file:Suppress("SpellCheckingInspection")

package com.gildedrose

internal class GildedRose(var items: Array<BaseItem>) {
    fun updateQuality() {
        for (item in items) item.update()
    }
}
