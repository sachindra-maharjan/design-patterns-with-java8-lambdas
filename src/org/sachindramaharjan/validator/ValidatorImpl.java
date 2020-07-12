package org.sachindramaharjan.validator;

import org.sachindramaharjan.chaining.Person;

public class ValidatorImpl {

    public static void main(String[] args) {

        Person wayne = new Person("Sarah", 20);
        Person john = new Person(null, 21);
        Person hanna = new Person("Hanna", -2);
        Person bruno = new Person("Bruno", 1000);
        Person david = new Person(null, 1000);

        david = Validator.validate(p -> p.getName() != null, "The name should not be null.")
                .thenValidate(p -> p.getAge() > 0, "The age should be greater than 0")
                .thenValidate(p -> p.getAge() < 150, "The age should be less than 150").on(david).validate();
        System.out.println(hanna);

    }

}