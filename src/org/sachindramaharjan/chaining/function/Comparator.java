package org.sachindramaharjan.chaining.function;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
public interface Comparator<T> {

    int compare(T t1, T t2);

    default <U extends Comparable<U>> Comparator<T> thenCompare(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        Comparator<T> comparator = comparing(keyExtractor);
        return this.thenCompare(comparator);
    }

    default Comparator<T> thenCompare(Comparator<T> other) {
        Objects.requireNonNull(other);
        return (T t1, T t2) -> {
            int result = this.compare(t1, t2);
            if (result == 0) {
                return other.compare(t1, t2);
            }
            return result;
        };
    }

    default Comparator<T> reverse() {
        return (t1, t2) -> this.compare(t2, t1);
    }

    static <T, U extends Comparable<U>> Comparator<T> comparing(Function<T, U> keyExtractor) {
        Objects.requireNonNull(keyExtractor);
        return (t1, t2) -> {
            U p1 = keyExtractor.apply(t1);
            U p2 = keyExtractor.apply(t2);
            return p1.compareTo(p2);
        };
    }

}