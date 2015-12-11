package com.thoughtworks.pos.parser;

import com.thoughtworks.pos.domain.DiscountItem;
import com.thoughtworks.pos.domain.Item;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * Created by root on 15-12-10.
 */
public class DiscountItemParser extends Parser<DiscountItem> {
    private static final Pattern PATTERN = compile("^(\\w+):(\\d+)$");

    @Override
    protected DiscountItem parseLine(final String line) {
        String barcode = line.split(":")[0];
        Integer discount = Integer.parseInt(line.split(":")[1]);
        return new DiscountItem(barcode, discount);
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }
}
