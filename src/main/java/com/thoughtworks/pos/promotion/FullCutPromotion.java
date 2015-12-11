package com.thoughtworks.pos.promotion;

/**
 * Created by root on 15-12-11.
 */
public class FullCutPromotion implements Promotion {
    @Override
    public Double excutePromotiom(Integer quantityOrDiscount, Double fullCut, Double subTotal){
        if (subTotal>quantityOrDiscount) {
            if (subTotal > fullCut)
                subTotal = subTotal - fullCut;
            else
                throw new IllegalArgumentException("illegal full cut promotion");
        }
        return subTotal;
    }
}
