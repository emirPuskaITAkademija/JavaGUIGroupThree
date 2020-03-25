package three.collection;
//http://collabedit.com/u85ps

//LAMBDA se koristi kada hocemo da kreiramo objekte tipa funkcionalnog interfejsa
//LAMBDA je shortcut za operator new    INPUT -> OUTPUT
//LAMBDA definira blok koda apstraktne metode u funkcionalnom interfejsu
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import konsultacije.Person;
//http://collabedit.com/bn5b6

// ŠTa ako lambda ne radi ništa drugo do poziva neke metode ?????
// ODGOVOR: referenciraj se na tu metodu --> ::
//new -> LAMBDA(->) -> METHOD REFERENCIRANJE (::)
// 1. Referenciranje na objektnu metodu    imeObjekta::imeObjektneMethode
// 2. Referenciranje na statičku metodu    ImeKlase::imeStatičkeMetode
// 3. Referenciranje na objektnu metodu    ImeKlase::imeObjektneMetode
// 4. Referenciranja je referenciranje na konstruktor ImeKlase::new
//ČETIRI najvažnija
//1. Predicate<E> -> Predicate<Person>  -> filter
//2. Consumer<E> -> Consumer<Person>    -> forEach
//3. Supplier<E> -> Supplier<Person>
//4. Fuction<T, R> -> Function<Person, LocalDate>, Function<Person,String> -> map 
public class CollectionExecutor {

    public static final int PUNOLJETNOST = 18;

    public static void main(String[] args) {
        //Funkcionalni interfejs
        //<1.8 LAMBDA
        PersonTester testPunoljetnosti = p -> p.getAge() >= PUNOLJETNOST;
        List<Person> personList = Person.createRoster();
        //Java >=1.8
        //Spliterator
        //Streaming kroz kolekciju
        // 1. izvor stream -- >ISTI 
        // 2. intermediate operations -> ISTI
        // 3. terminate operations   -> karanten : saljem kuci preostale elemente
        personList.stream()//izvor stream : kolekcija personList
                .filter(testPunoljetnosti::test)
                .forEach(CollectionExecutor::printCoronaPerson);
        System.out.println("Korona manje ugrožene osobe");
        personList.stream()//
                .filter(testPunoljetnosti::testNotPassed)
                .forEach(CollectionExecutor::printOrdinaryPerson);
        System.out.println("Bebe");
        personList.stream()//
                .filter(Person::isBaby) // Person::isBaby
                .forEach(CollectionExecutor::printBaby);
        System.out.println("OBRADA niza");
        Person[] personArray = personList.toArray(new Person[personList.size()]);
        printComparablePersons(personArray);
        //TRANSFORMISETE iz kolekcije(List<Person>) u kolekciju(List<String>, List<LocalDate>)
        personList.stream()//Stream<Person>
                .map(Person::getName) // Stream<Person> --> Stream<String>
                .forEach(System.out::println);//Stream<String>

        //personList -> transferElements
        //List<Person> -> HashSet<Person>, LinkedHashSet<Person>
        //Supplier<HashSet<Person>> supplier = ;
        List<String> personNames = personList.stream()//
                .map(Person::getName)
                .collect(Collectors.toList());

        HashSet<Person> personHashSet = transferElements(personList, HashSet::new);
        LinkedHashSet<String> nameLinkedHashSet = transferElements(personNames, LinkedHashSet::new);
    }

    //Supplier<>, method referenciranja na konstruktor, generički tipovi
    //Generički tip : 
    // 1. nivo klase Box<T>
    // 2. nivo funkcije E, SOURCE, DESTINATION
    // Vrste generičkih tipova:
    // 1. Unbounded T, S , U , V  -> Object
    // 2. Bounded T extend Number, SOURCE extends Collection<>
    //http://collabedit.com/c4qtm
    // 3 generička
    public static <E, SOURCE extends Collection<E>, DEST extends Collection<E>> DEST transferElements(SOURCE sourceCollection, Supplier<DEST> dstCollectionSupplier) {
        DEST destination = dstCollectionSupplier.get();
        for (E element : sourceCollection) {
            destination.add(element);
        }
        return destination;
    }

    static void printCoronaPerson(Person person) {
        System.out.println("CORONA SUSPECT Person : " + person);
    }

    static void printOrdinaryPerson(Person person) {
        System.out.println("Corona free person: " + person);
    }

    static void printBaby(Person person) {
        System.out.println("Baby : " + person);
    }

    static void printComparablePersons(Person[] personArray) {
        class PersonAgeComparator implements Comparator<Person> {

            @Override
            public int compare(Person o1, Person o2) {
                //-1  0  1 
                if (o1.getAge() == o2.getAge()) {
                    return 0;
                }
                return o1.getAge() < o2.getAge() ? -1 : 1;
            }
        }
        PersonAgeComparator personAgeComparator = new PersonAgeComparator();
        Arrays.sort(personArray, personAgeComparator);
        Arrays.stream(personArray).forEach(System.out::println);
       // Stream.of(personArray).forEach(System.out::println);
    }
}
