package dao;

/**
 *
 * @author emir
 */
public enum ConnectionProperties {
    URL("jdbc:derby://localhost:1527/books"),
    USERNAME("emir"),
    PASSWORD("emir");

    private final String value;

    private ConnectionProperties(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
