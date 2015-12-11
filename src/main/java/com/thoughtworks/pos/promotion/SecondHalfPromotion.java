package com.thoughtworks.pos.promotion;

import com.thoughtworks.pos.domain.CartItem;
import com.thoughtworks.pos.domain.DiscountItem;

/**
 * Created by root on 15-12-10.
 */
public class SecondHalfPromotion implements Promotion {
    @Override
    public Double excutePromotiom(Integer quantityOrDiscount, Double fullCut, Double subTotal) {
        if (quantityOrDiscount<2)
            return subTotal;
        Integer numberOfSecondHalf = quantityOrDiscount/2;
        subTotal = subTotal/quantityOrDiscount*(quantityOrDiscount-numberOfSecondHalf*0.5);
        return subTotal;
    }
}
