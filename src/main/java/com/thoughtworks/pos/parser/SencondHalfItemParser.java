package com.thoughtworks.pos.parser;

import com.thoughtworks.pos.domain.CartItem;
import com.thoughtworks.pos.domain.SecondHalfItem;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

/**
 * Created by root on 15-12-11.
 */
public class SencondHalfItemParser extends Parser<SecondHalfItem> {
    private static final Pattern PATTERN = compile("^(\\w+)$");
    @Override
    protected SecondHalfItem parseLine(String line) {
        return new SecondHalfItem(line);
    }

    @Override
    protected Pattern getPattern() {
        return PATTERN;
    }
}
