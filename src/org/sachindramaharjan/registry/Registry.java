package org.sachindramaharjan.registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

import org.sachindramaharjan.factory.Factory;
import org.sachindramaharjan.model.Shape;

@FunctionalInterface
public interface Registry {

    Factory<? extends Shape> buildShareFactory(String shape);

    public static Registry createRegistry(Consumer<Builder<Shape>> consumer,
            Function<String, Factory<Shape>> errorFunction) {
        Map<String, Factory<Shape>> map = new HashMap<>();
        Builder<Shape> builder = (label, factory) -> map.put(label, factory);
        consumer.accept(builder);
        return shape -> map.computeIfAbsent(shape, errorFunction);
    }

}