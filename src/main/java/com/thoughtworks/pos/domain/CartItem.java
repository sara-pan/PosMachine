package com.thoughtworks.pos.domain;

public final class CartItem {
    private final String barcode;
    private final Integer quantity;

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    private Double price;

    public CartItem(final String barcode, final Integer quantity) {
        this.barcode = barcode;
        this.quantity = quantity;
        price=0.0;
    }

    public String getBarcode() {
        return barcode;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
