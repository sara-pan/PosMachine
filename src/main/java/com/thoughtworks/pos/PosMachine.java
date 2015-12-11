package com.thoughtworks.pos;

import com.thoughtworks.pos.domain.CartItem;
import com.thoughtworks.pos.domain.DiscountItem;
import com.thoughtworks.pos.domain.Item;
import com.thoughtworks.pos.domain.SecondHalfItem;
import com.thoughtworks.pos.promotion.*;

import java.util.List;

public final class PosMachine {
    private final List<Item> allItems;

    public PosMachine(final List<Item> allItems) {
        this.allItems = allItems;
    }

    public double calculate(final List<CartItem> cartItems) {
        double total = 0;
        for (CartItem cartItem : cartItems) {
            total += calculateSubtotal(cartItem);
        }
        return total;
    }

    public double calculateWithPromotion(final List<CartItem> cartItems, List<DiscountItem> discountItems, List<SecondHalfItem> secondHalfItems){
       // FullCutPromotion promotion=new FullCutPromotion();
        //AllPromotion allPromotion=new AllPromotion(promotion);
        double total = 0;
        double subTotal=0;
        for (CartItem cartItem : cartItems) {
            subTotal= calculateSubtotalWithPromtion(cartItem,discountItems, secondHalfItems);
            //subTotal=allPromotion.calculatePriceAfterPromotion(400,5.0,subTotal);
            total += subTotal;
        }
        //total = allPromotion.calculatePriceAfterPromotion(400,5.0,total);
        return total;
    }

    private double calculateSubtotal(final CartItem cartItem) {
        String barcode = cartItem.getBarcode();
        double originPrice = queryItemPrice(barcode);
        return cartItem.getQuantity() * originPrice;
    }

    private double calculateSubtotalWithPromtion(CartItem cartItem, List<DiscountItem> discountItems, List<SecondHalfItem> secondHalfItems){
        double subTotalAfterPromotion=0.0;

        subTotalAfterPromotion=calculateSubtotal(cartItem);

        DiscountPromotion discountPromotion=new DiscountPromotion();
        AllPromotion allPromotion=new AllPromotion(discountPromotion);


        if(secondHalfItems.size()>0) {
            for (DiscountItem discountItem : discountItems) {
                if (discountItem.getBarcode().equals(cartItem.getBarcode())) {
                    subTotalAfterPromotion = allPromotion.calculatePriceAfterPromotion(discountItem.getDiscount(), 0.0, subTotalAfterPromotion);
                }
            }
        }

        SecondHalfPromotion promotion=new SecondHalfPromotion();
        allPromotion.setPromotion(promotion);
        if(secondHalfItems.size()>0){
            for (SecondHalfItem secondHalfItem : secondHalfItems) {
                if (secondHalfItem.getBarcode().equals(cartItem.getBarcode())) {
                    subTotalAfterPromotion=allPromotion.calculatePriceAfterPromotion(cartItem.getQuantity(),0.0,subTotalAfterPromotion);
                }
            }
        }

        FullCutPromotion fullCutPromotion=new FullCutPromotion();
        allPromotion.setPromotion(fullCutPromotion);
        //if(secondHalfItems.size()>0){
          //  for (SecondHalfItem secondHalfItem : secondHalfItems) {
            //    if (secondHalfItem.getBarcode().equals(cartItem.getBarcode())) {
              //      subTotalAfterPromotion=allPromotion.calculatePriceAfterPromotion(cartItem.getQuantity(),0.0,subTotalAfterPromotion);
                //}
           // }
        //}
        subTotalAfterPromotion=allPromotion.calculatePriceAfterPromotion(400,10.0,subTotalAfterPromotion);

        return subTotalAfterPromotion;
    }

    private double queryItemPrice(final String barcode) {
        for (Item item : allItems) {
            if (item.getBarcode().equals(barcode)) {
                return item.getPrice();
            }
        }

        throw new IllegalArgumentException("unknown item");
    }
}
