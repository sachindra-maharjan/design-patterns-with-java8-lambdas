package org.sachindramaharjan.registry;

import org.sachindramaharjan.factory.Factory;

@FunctionalInterface
public interface Builder<T> {

    void register(String label, Factory<T> factory);

}