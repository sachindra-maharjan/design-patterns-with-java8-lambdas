package org.sachindramaharjan.chaining.function;

@FunctionalInterface
public interface Predicate<T> {

    boolean test(T t);

    default Predicate<T> and(Predicate<T> other) {
        return (T t) -> this.test(t) && other.test(t);
    }

    default Predicate<T> negate() {
        return (T t) -> !this.test(t);
    }

}