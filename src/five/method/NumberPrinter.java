package five.method;

public class NumberPrinter implements NumberConsumer{

    @Override
    public void consumeNumber(Number number) {
        System.out.println("Number = " + number);
    } 
}
