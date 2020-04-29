package dao;

/**
 * Mapped from SQL table: id, firstName, lastName, sport, ofYears, vegetarian
 *
 *
 * @author emir
 */
public class PlayerInfo {

    private Integer id;
    private String firstName;
    private String lastName;
    private String sport;
    private Integer ofYears;
    private Boolean vegetarian;

    public PlayerInfo(Integer id, String firstName, String lastName, String sport, int ofYears, Boolean vegetarian) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.sport = sport;
        this.ofYears = ofYears;
        this.vegetarian = vegetarian;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getSport() {
        return sport;
    }

    public void setOfYears(Integer ofYears) {
        this.ofYears = ofYears;
    }

    public Integer getOfYears() {
        return ofYears;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    @Override
    public String toString() {
        return firstName + "  " + lastName;
    }
}
