package five.method;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

/**
 * <ol>
 * <li> 1. Enkapsulacija -skrivanje
 * <li> 2. Apstrakcije - apstraktna klasa, interface(funkcionalni interfejs)
 * <li> 3. Nasljeđivanje - NumberPrinter je naslijedila NumberConsumer
 * <li> 4. Polimorfizma -
 *
 * @author grupa 1
 */
public class Application {

    public static void main(String[] args) {
        //Zasto kreiramo klase, interfejse i apstraktne klase?
        //Da bi definirali tip nekog objekta i da bi po sablonu neke klase kreirali objekat.
        Book book = new Book("Derviš i smrt", 1000, "Meša Selimović", 10);
        //Kada mozemo izostaviti operator new ??
        //Kada kreiramo objekte tipa funkcionalnog interfejsa.
        //numberPrinter - tipa NumberPrinter,NumberConsumer
        NumberConsumer numberPrinter = new NumberPrinter();
        numberPrinter.consumeNumber(23);//Number = 23
        NumberConsumer numberPrinter1 = (number) -> {
            System.out.println("Number iz lambde = " + number);
        };
        numberPrinter1.consumeNumber(34);
        //Kada lambda ne radi ništa drugo do poziva druge statiče funkcije onda mi mozemo 
        // kao zamjenu za lambdu koristiti method referenciranje ::
        //POTREBA I DOVOLJAN uslov da se možemo uopće referencirati na tu metodu je:
        // 1. input parametri moraju odgovarati u toj funkciji(uzmiBroj) input parametrima funkcije u interfejsu(consumeNumber)
        // 2. output parametri moraju takođe odgovarati
        NumberConsumer numberPrinter2 = Application::uzmiBroj;
        //numberPrinter2.consumeNumber(45);
        //numberPrinter2.consumeNumber(234);
        //numberPrinter2.consumeNumber(234);
        //PRIMJENA
        Random random = new Random();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int number = random.nextInt(20);
            numbers.add(number);
        }
        //ispisati konzolu - ENHANCED 
        for (Integer number : numbers) {
            numberPrinter2.consumeNumber(number);
        }
        //napomena
        Consumer<Number> consumer = numberPrinter2::consumeNumber;//method referenciranje na metodu koja se nalazi u nekom objektu
        consumer.accept(23);
        numbers.forEach(consumer);
        numbers.forEach(numberPrinter2::consumeNumber);
        
    }

    //static method referenciranje
    static void uzmiBroj(Number number) {
        System.out.println("Uzeti broj(kolekcija) = " + number);
    }
}
