package org.sachindramaharjan.chaining;

import org.sachindramaharjan.chaining.function.Comparator;

public class ComparatorImpl {

    public static void main(String[] args) {
        Person p1 = new Person("ram", 22);
        Person p2 = new Person("shyam", 23);
        Person p3 = new Person("hari", 25);
        Person p4 = new Person("hari", 26);

        Comparator<Person> comp = Comparator.comparing(Person::getName).thenCompare(Person::getAge);

        System.out.println(comp.compare(p1, p2) > 0);
        System.out.println(comp.compare(p3, p4) > 0);

    }

}