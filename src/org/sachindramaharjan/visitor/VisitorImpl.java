
package org.sachindramaharjan.visitor;

import java.util.function.Consumer;

public class VisitorImpl {

    public static void main(String[] args) {
        Car car = new Car();
        Engine engine = new Engine();
        Body body = new Body();

        Consumer<VisitorBuilder<String>> consumer = Visitor.<Car, String>forType(Car.class)
                .execute((Car c) -> "Visition car " + c).forType(Engine.class)
                .execute((Engine e) -> "Visiting engine " + e).forType(Body.class)
                .execute((Body b) -> "Visiting body " + b);

        Visitor<String> visitor = Visitor.of(consumer);

        String visitedCar = visitor.visit(car);
        String visitedEngine = visitor.visit(engine);
        String visitedBody = visitor.visit(body);

        System.out.println(visitedCar);
        System.out.println(visitedEngine);
        System.out.println(visitedBody);

    }

}