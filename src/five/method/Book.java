package five.method;

/*
 1. polja, atribute ili fields ili properties
 2. konstruktor i njegova definicija
 3. metode ili funkcije

 */
public class Book {

    //objektna
    private String title;
    private int pageNumbers;
    private String author;
    private int rating;//1-10

    public Book(String title, int pageNumbers, String author, int rating) {
        this.title = title;
        this.pageNumbers = pageNumbers;
        this.author = author;
        this.rating = rating;
    }

    public void setRating(int ocjena) {
        if (rating >= 1 && rating <= 10) {
            this.rating = rating;
        }
    }

    public int getRating() {
        return rating;
    }

}
