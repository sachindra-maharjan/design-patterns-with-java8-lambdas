package org.sachindramaharjan.validator;

import java.util.function.Predicate;
import java.util.function.Supplier;

import org.sachindramaharjan.chaining.Person;

public interface Validator {

    ValidatorSupplier on(Person person);

    static Validator validate(Predicate<Person> predicate, String errorMessage) {
        return p -> {
            if (predicate.test(p)) {
                return () -> p;
            } else {
                ValidationException exception = new ValidationException("The object is not valid.");
                exception.addSuppressed(new IllegalArgumentException(errorMessage));
                throw exception;
            }
        };
    }

    default Validator thenValidate(Predicate<Person> predicate, String errorMessage) {
        return p -> {
            try {
                on(p).validate();
                if (predicate.test(p)) {
                    return () -> p;
                } else {
                    ValidationException exception = new ValidationException("The object is not valid.");
                    exception.addSuppressed(new IllegalArgumentException(errorMessage));
                    throw exception;
                }
            } catch (ValidationException exception) {
                if (predicate.test(p)) {
                    return () -> {
                        throw exception;
                    };
                } else {
                    exception.addSuppressed(new IllegalArgumentException(errorMessage));
                    throw exception;
                }
            }
        };
    }

    interface ValidatorSupplier extends Supplier<Person> {

        default Person validate() {
            return get();
        }
    }

    static class ValidationException extends RuntimeException {

        private static final long serialVersionUID = -6189016816216091198L;

        public ValidationException(String message) {
            super(message);
        }
    }

}