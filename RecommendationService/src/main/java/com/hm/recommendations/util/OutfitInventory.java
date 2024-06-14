package com.hm.recommendations.util;

import com.hm.recommendations.model.EventType;
import com.hm.recommendations.model.Outfit;

import java.util.ArrayList;
import java.util.List;

public final class OutfitInventory {

    public static final List<Outfit> OUTFIT_INVENTORY;

    static {
        List<Outfit> outfitList = new ArrayList<>();
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Jacket", "Red Christmas Jacket", 150.0, "Casual", 10));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Shirt", "Green Christmas Shirt", 50.0, "Casual", 20));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Trousers", "Black Trousers", 100.0, "Formal", 5));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Sweater", "Christmas Sweater", 75.0, "Casual", 0));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Scarf", "Christmas Scarf", 20.0, "Casual", 15));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Hat", "Santa Hat", 15.0, "Casual", 25));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Gloves", "Warm Gloves", 25.0, "Casual", 30));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Boots", "Snow Boots", 90.0, "Casual", 12));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Coat", "Winter Coat", 120.0, "Formal", 3));
        outfitList.add(new Outfit(EventType.CHRISTMAS, "Pajamas", "Christmas Pajamas", 40.0, "Casual", 18));

        outfitList.add(new Outfit(EventType.WEDDING, "Suit", "Elegant Wedding Suit", 200.0, "Party Wear", 4));
        outfitList.add(new Outfit(EventType.WEDDING, "Tie", "Silk Tie", 30.0, "Formal", 10));
        outfitList.add(new Outfit(EventType.WEDDING, "Shoes", "Leather Shoes", 70.0, "Formal", 6));
        outfitList.add(new Outfit(EventType.WEDDING, "Dress", "Elegant Wedding Dress", 250.0, "Party Wear", 3));
        outfitList.add(new Outfit(EventType.WEDDING, "Hat", "Formal Hat", 40.0, "Casual", 9));
        outfitList.add(new Outfit(EventType.WEDDING, "Gloves", "Elegant Gloves", 25.0, "Formal", 10));
        outfitList.add(new Outfit(EventType.WEDDING, "Vest", "Formal Vest", 70.0, "Formal", 5));
        outfitList.add(new Outfit(EventType.WEDDING, "Necklace", "Pearl Necklace", 150.0, "Party Wear", 2));
        outfitList.add(new Outfit(EventType.WEDDING, "Belt", "Leather Belt", 50.0, "Formal", 8));

        OUTFIT_INVENTORY = outfitList;
    }
}
