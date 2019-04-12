package com.wooyoo.learning.filterChain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements  CommonFilter  {

    private List<CommonFilter> filters = new ArrayList<CommonFilter>();

    int index=0;

    public FilterChain addFilter(CommonFilter commonFilter){

        filters.add(commonFilter);
        return this;
    }

    @Override
    public void write(FilterChain filterChain) {

        if(index==filters.size()){
             return;
        }
        CommonFilter f =filters.get(index);
        index++;
       f.write(filterChain);

    }

    public static void main(String[] args) {

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(new OneFilter());
        filterChain.addFilter(new TwoFilter());
        filterChain.addFilter(new ThreeFilter());
        filterChain.write(filterChain);

    }

}
