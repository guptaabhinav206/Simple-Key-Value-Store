package com.company;

/**
 * Created by abhinav on 3/12/16.
 */

public class Main {

    public static void main(String[] args) {

        // Giving cache capicity as 10
        Cache cache = new Cache(10);
        cache.set(1,1);
        cache.set(1,2);
        cache.set(6,7);
        cache.set(6,8);
        cache.set(1,3);
        cache.set(6,9);
        cache.display();
        System.out.println("version 1: "+cache.get(1,1));
        System.out.println("version 2: "+cache.get(1,2));
        System.out.println(cache.get(1));
        System.out.println("version 1: "+cache.get(6,1));
        System.out.println("version 2: "+cache.get(6,2));
        System.out.println(cache.get(6));
    }
}
