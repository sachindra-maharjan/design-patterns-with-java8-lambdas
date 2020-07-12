package org.sachindramaharjan.factory;

import java.util.List;

public class FactoryImpl {

    public static void main(String[] args) {

        Factory<Circle> factory1 = Factory.creatFactory(Circle::new);
        Factory<Circle> factory2 = Factory.createFactory(Circle::new, "Red");

        Circle circle = factory1.newInstance();
        List<Circle> circles = factory1.ceate5();

        System.out.println(circle);
        System.out.println(circles);

        Circle redCircle = factory2.newInstance();
        System.out.println(redCircle);

    }

}