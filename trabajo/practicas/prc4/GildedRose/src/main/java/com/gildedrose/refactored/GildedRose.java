package com.gildedrose.refactored;

class GildedRose {
  Item[] items;
  public static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
  public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
  public GildedRose(Item[] items) {
    this.items = items;
  }

  public void updateQuality() {
      for (Item item : items) {
          if (!item.name.equals("Aged Brie") && !item.name.equals(BACKSTAGE)) {
              if ((item.quality > 0) && (!item.name.equals(SULFURAS))) {
                  item.quality = item.quality - 1;
              }
          } else {
              if (item.quality < 50) {
                  item.quality = item.quality + 1;

                  if (item.name.equals(BACKSTAGE)) {
                      if ((item.sellIn < 11) && (item.quality < 50)) {
                          item.quality = item.quality + 1;
                      }

                      if (item.sellIn < 6 && item.quality < 50) {
                        item.quality = item.quality + 1;
                      }
                  }
              }
          }

          if (!item.name.equals(SULFURAS)) {
              item.sellIn = item.sellIn - 1;
          }

          if (item.sellIn < 0) {
              if (!item.name.equals("Aged Brie")) {
                  if (!item.name.equals(BACKSTAGE)) {
                      if ((item.quality > 0) && (!item.name.equals(SULFURAS))) {
                        item.quality = item.quality - 1;
                      }
                  } else {
                      item.quality = 0;
                  }
              } else {
                  if (item.quality < 50) {
                      item.quality = item.quality + 1;
                  }
              }
          }
      }
  }
}