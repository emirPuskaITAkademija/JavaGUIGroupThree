/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package konsultacije;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 *
 * @author grupa 1
 */
//1. Predicate<T>
//2. Consumer<T>
//3. Supplier<T>
//4. Function<T,R>
public class PersonExecutor {

    public static void main(String[] args) {
        List<Person> persons = Person.createRoster();
        Predicate<Person> tester = t->t.getAge() > 23;
        processPersons(persons, p -> p.getAge() > 23, p->System.out.println(p));
        System.out.println("Idu mladji");
        processPersons(persons, p -> p.getAge() < 23, p->System.out.println(p));
        System.out.println("Unutar opsega");
        processPersons(persons, p -> p.getAge() >= 18 && p.getAge() <= 30, p->System.out.println(p));
        System.out.println("EVO Šefe što god ti treba");
        processPersons(persons, p->p.getName().startsWith("Bob"), p->System.out.println(p));
        //Java 8 iteracija kroz petlju
        persons.stream().filter(t->t.getAge() > 23).forEach(it->System.out.println(it));
    }
    
    static void processPersons(List<Person> persons, Predicate<Person> tester, Consumer<Person> personConsumer){
        for(Person person: persons){
            if(tester.test(person)){
                personConsumer.accept(person);
            }
        }
    }

  /*  static void printPersons(List<Person> persons, Predicate<Person> tester) {
        for (Person person : persons) {
            if (tester.test(person)) {
                System.out.println(person);
            }
        }
    }*/
    /*
    static void printOlderThan(List<Person> persons, int age) {
        for (Person person : persons) {
            if (person.getAge() > age) {
                System.out.println(person);
            }
        }
    }

    static void printYoungerThan(List<Person> persons, int age) {
        for (Person person : persons) {
            if (person.getAge() < age) {
                System.out.println(person);
            }
        }
    }
    
     static void printPersonsWithinTheRange(List<Person> persons, int min, int max) {
        for (Person person : persons) {
            if (person.getAge() >=min && person.getAge()<=max) {
                System.out.println(person);
            }
        }
    }
     */
}
