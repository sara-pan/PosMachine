package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.CartItem;
import com.thoughtworks.pos.domain.DiscountItem;
import com.thoughtworks.pos.domain.Item;
import com.thoughtworks.pos.domain.SecondHalfItem;
import com.thoughtworks.pos.parser.DiscountItemParser;
import com.thoughtworks.pos.parser.ItemParser;
import com.thoughtworks.pos.parser.SencondHalfItemParser;
import com.thoughtworks.pos.parser.ShoppingCartParser;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ItemParser itemParser = new ItemParser();
        List<Item> allItems = itemParser.parse(ShopData.ITEMS_DATA);
        ShoppingCartParser shoppingCartParser = new ShoppingCartParser();
        List<CartItem> cartItems = shoppingCartParser.parse(ShopData.SHOPPING_CART_DATA);
        DiscountItemParser discountItemParser=new DiscountItemParser();
        List<DiscountItem> discountItems=discountItemParser.parse(ShopData.DISCOUNT_ITEMS);
        SencondHalfItemParser sencondHalfItemParser=new SencondHalfItemParser();
        List<SecondHalfItem> secondHalfItems=sencondHalfItemParser.parse(ShopData.SECOND_Half_ITEMS);

        PosMachine posMachine = new PosMachine(allItems);
        //double total = posMachine.calculate(cartItems);
        double total = posMachine.calculateWithPromotion(cartItems,discountItems,secondHalfItems);

        System.out.println("总价:" + total);
    }
}
