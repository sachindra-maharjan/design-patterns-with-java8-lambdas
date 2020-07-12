package org.sachindramaharjan.chaining.function;

@FunctionalInterface
public interface Function<T, R> {

    R apply(T t);

    default <V> Function<T, V> and(Function<R, V> other) {
        return (T t) -> {
            R r = this.apply(t);
            return other.apply(r);
        };
    }

    default <V> Function<V, R> compose(Function<V, T> other) {
        return (V v) -> {
            T t = other.apply(v);
            return this.apply(t);
        };
    }

}