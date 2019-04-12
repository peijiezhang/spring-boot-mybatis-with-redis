package com.wooyoo.learning.filterChain;

public class TwoFilter implements  CommonFilter {

    @Override
    public void write(FilterChain filterChain) {
        System.out.println("  TwoFilter===>");
        filterChain.write(filterChain);
    }
}
