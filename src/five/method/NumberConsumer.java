package five.method;

@FunctionalInterface
public interface NumberConsumer {

    //ne mogu postojati objektna
    int DEFAULT = 0;

    //1 i samo 1 apstraktna metoda - OBJEKTNA METODA
    public abstract void consumeNumber(Number number);
}
