package com.thoughtworks.pos.promotion;

import com.thoughtworks.pos.domain.CartItem;
import com.thoughtworks.pos.domain.DiscountItem;

/**
 * Created by root on 15-12-10.
 */
public interface Promotion {
    Double excutePromotiom(Integer quantityOrDiscount,Double fullCut,Double subTotal);
}
