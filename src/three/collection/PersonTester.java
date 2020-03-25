package three.collection;

import konsultacije.Person;
@FunctionalInterface
public interface PersonTester {

    boolean test(Person person);

    default boolean testNotPassed(Person person){
        return !test(person);
    }
}
