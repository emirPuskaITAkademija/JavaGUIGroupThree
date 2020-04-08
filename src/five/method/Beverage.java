package five.method;
//apstraktna klasa
public abstract class Beverage {
    //enkapsulacije
    private String name;

    public Beverage(String name) {
        this.name = name;
    }
    
    public abstract void drink();
    
    public abstract double cost();
}
