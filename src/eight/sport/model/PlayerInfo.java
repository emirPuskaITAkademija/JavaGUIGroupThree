package eight.sport.model;

public class PlayerInfo {

    private Integer id;
    private String firstName;
    private String lastName;
    private String sport;
    private int ofYears;
    private boolean vegetarian;

    public PlayerInfo() {
    }

    public PlayerInfo(Integer id, String firstName, String lastName, String sport, int ofYears, boolean vegetarian) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = sport;
        this.ofYears = ofYears;
        this.vegetarian = vegetarian;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getOfYears() {
        return ofYears;
    }

    public void setOfYears(int ofYears) {
        this.ofYears = ofYears;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(firstName)
                .append(" ")
                .append(lastName)
                .append(",")
                .append(sport)
                .toString();
    }
}
