package org.sachindramaharjan.registry;

import java.util.function.Consumer;

import org.sachindramaharjan.factory.Factory;
import org.sachindramaharjan.model.Rectangle;
import org.sachindramaharjan.model.Shape;
import org.sachindramaharjan.model.Square;

public class RegistryImpl {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {

        Consumer<Builder<Shape>> consumer1 = builder -> builder.register("rectangle", Rectangle::new);
        Consumer<Builder<Shape>> consumer2 = builder -> builder.register("square", Square::new);
        Consumer<Builder<Shape>> consumer = consumer1.andThen(consumer2);

        Registry register = Registry.createRegistry(consumer, s -> {
            throw new IllegalArgumentException("Unknown shape " + s);
        });

        Factory<Rectangle> rectangleFactory = (Factory<Rectangle>) register.buildShareFactory("rectangle");
        Rectangle rectangle = rectangleFactory.newInstance();
        System.out.println(rectangle);

        Factory<Square> squareFactory = (Factory<Square>) register.buildShareFactory("square");
        Square square = squareFactory.newInstance();
        System.out.println(square);

        Factory<Shape> shapeFactory = (Factory<Shape>) register.buildShareFactory("triangle");
        Shape shape = shapeFactory.newInstance();
        System.out.println(shape);

    }

}