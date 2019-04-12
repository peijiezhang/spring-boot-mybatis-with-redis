package com.wooyoo.learning.filterChain;

public class ThreeFilter  implements  CommonFilter{


    @Override
    public void write(FilterChain filterChain) {
        System.out.println("  ThreeFilter===>");
        filterChain.write(filterChain);
    }
}
