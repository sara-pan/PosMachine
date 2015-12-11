package com.thoughtworks.pos.promotion;

/**
 * Created by root on 15-12-11.
 */
public class AllPromotion {
    private Promotion promotion;

    public AllPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public double calculatePriceAfterPromotion(Integer quantityOrDiscount,Double fullCut,Double subTotal){
        return promotion.excutePromotiom(quantityOrDiscount,fullCut,subTotal);
    }
}
