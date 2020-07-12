package org.sachindramaharjan.chaining;

import org.sachindramaharjan.chaining.function.Predicate;

public class PredicateImpl {

    public static void main(String[] args) {

        Predicate<String> p1 = s -> s != null;
        Predicate<String> p2 = s -> s.isEmpty();
        Predicate<String> p3 = p1.and(p2.negate());

        System.out.println(p1.test(""));
        System.out.println(p2.test("test"));
        System.out.println(p3.test("test"));

    }

}