package com.thoughtworks.pos.domain;

/**
 * Created by root on 15-12-5.
 */
public class DiscountItem {
    private final String barcode;
    private final Integer discount;

    public DiscountItem(final String barcode, final Integer discount) {
        this.barcode = barcode;
        if (discount>=0 || discount<=100)
          this.discount = discount;
        else this.discount=100;
    }

    public String getBarcode() {
        return barcode;
    }

    public Integer getDiscount() {
        return discount;
    }
}
