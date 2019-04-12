package com.wooyoo.learning.filterChain;

public class OneFilter implements  CommonFilter {

    @Override
    public void write(FilterChain filterChain) {

        System.out.println("  OneFilter===>");
        filterChain.write(filterChain);
    }
}
