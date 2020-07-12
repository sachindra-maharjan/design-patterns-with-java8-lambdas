package org.sachindramaharjan.chaining;

import org.sachindramaharjan.chaining.function.Consumer;

public class ConsumerImpl {

    public static void main(String[] args) {

        Consumer<String> c1 = s -> System.out.println("c1 = " + s);
        Consumer<String> c2 = s -> System.out.println("c2 = " + s);

        Consumer<String> c3 = c1.andThen(c2);
        c3.accept("hello");

    }

}