package dao;

/**
 * Mapped from SQL table: id, firstName, lastName, sport, ofYears, vegetarian
 *
 *
 * @author emir
 */
public class PlayerInfo {

    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String sport;
    private final Integer ofYears;
    private final Boolean vegetarian;

    public PlayerInfo(Integer id, String firstName, String lastName, String sport, int ofYears, Boolean vegetarian) {
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

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSport() {
        return sport;
    }

    public Integer getOfYears() {
        return ofYears;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    @Override
    public String toString() {
        return firstName + "  " + lastName;
    }
}
