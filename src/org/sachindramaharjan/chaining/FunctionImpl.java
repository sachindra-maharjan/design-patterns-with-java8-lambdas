package org.sachindramaharjan.chaining;

import org.sachindramaharjan.chaining.function.Function;

public class FunctionImpl {

    public static void main(String[] args) {

        Temperature temperature = new Temperature(10);

        Function<Temperature, Integer> f1 = temp -> temp.getTemp();
        Function<Integer, Double> f2 = temp -> temp * 9d / 5d + 32d;
        Function<Temperature, Double> f3 = f1.and(f2);

        Function<Temperature, Double> f4 = f2.compose(f1);

        System.out.println(f1.apply(temperature));
        System.out.println(f2.apply(temperature.getTemp()));
        System.out.println(f3.apply(temperature));
        System.out.println(f4.apply(temperature));

    }

}