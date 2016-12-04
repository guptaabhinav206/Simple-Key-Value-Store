package com.company;

import static org.junit.Assert.*;
import org.junit.Test;
/**
 * Created by abhinav on 4/12/16.
 */
public class TestCase {

    @Test
    public void testFindMax(){
        Cache cache = new Cache(10);
        cache.set(1,1);
        cache.set(1,2);
        cache.set(6,7);
        cache.set(6,8);
        cache.set(1,3);
        cache.set(6,9);

        assertEquals(2,cache.get(1,1));
        assertEquals(1,cache.get(1,2));
        assertEquals(2,cache.get(1));

    }

}

