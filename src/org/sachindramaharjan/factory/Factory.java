package org.sachindramaharjan.factory;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public interface Factory<T> extends Supplier<T> {

    default T newInstance() {
        return get();
    }

    default List<T> ceate5() {
        return IntStream.range(0, 5).mapToObj(index -> newInstance()).collect(Collectors.toList());
    }

    static <T> Factory<T> creatFactory(Supplier<T> supplier) {
        T instance = supplier.get(); // singleton
        return () -> instance;
    }

    static <P, T> Factory<T> createFactory(Function<P, T> constructor, P color) {
        return () -> constructor.apply(color);
    }

}