package com.thoughtworks.pos;


import com.thoughtworks.pos.domain.CartItem;
import com.thoughtworks.pos.domain.DiscountItem;
import com.thoughtworks.pos.domain.Item;
import com.thoughtworks.pos.domain.SecondHalfItem;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
//import static sun.nio.cs.Surrogate.is;

/**
 * Created by root on 15-12-5.
 */
public class PromotionTest {
    private List<Item> allItems=Arrays.asList(new Item("ITEM000001", 3),new Item("ITEM000003", 2),new Item("ITEM000005", 3));
    PosMachine posMachine=new PosMachine(allItems);
    private List<DiscountItem> discountItems=Arrays.asList(new DiscountItem("ITEM000001",75),new DiscountItem("ITEM000005",90));
    private List<CartItem> cartItems=Arrays.asList(new CartItem("ITEM000001", 40),new CartItem("ITEM000003",50),new CartItem("ITEM000005",60));
    private List<SecondHalfItem> secondHalfItems=Arrays.asList(new SecondHalfItem("ITEM000001"),new SecondHalfItem("ITEM000003"));
    private double total=0.0;
    private List<DiscountItem> noDiscountItem=new ArrayList<>();
    private List<SecondHalfItem> noSecondHalfItem=new ArrayList<>();



    @Test
    public void calculateWithOnlySecondHalf() {
        //PosMachine posMachine=new PosMachine(allItems);
        total = posMachine.calculateWithPromotion(cartItems,noDiscountItem,secondHalfItems);

       // assertThat(total,is(355d));
        assertEquals(total,355,1e-6);
    }

    @Test
    public void calculateWithNoPromotion() {
        //PosMachine posMachine=new PosMachine(allItems);
        total = posMachine.calculate(cartItems);

        //assertThat(total,is(400d));
        assertEquals(total,400,1e-6);
    }

    @Test
    public void calculateWithOnlyDiscount() throws Exception {

        total = posMachine.calculateWithPromotion(cartItems,discountItems,noSecondHalfItem);

        //assertThat(total,is(352d));
        assertEquals(total,352,1e-6);
    }
/*
    @Test
    public void calculateWithOnlyFullCut() throws Exception {

        total = posMachine.calculateWithPromotion(cartItems,noDiscountItem,noSecondHalfItem);

        //assertThat(total,is(395d));
        assertEquals(total,395,1e-6);
    }*/

    @Test
    public void calculateWithAllPromotion() throws Exception {
        total = posMachine.calculateWithPromotion(cartItems,discountItems,secondHalfItems);

        assertEquals(total,312,1e-6);
        //assertThat(total,is(312d));
    }
}
