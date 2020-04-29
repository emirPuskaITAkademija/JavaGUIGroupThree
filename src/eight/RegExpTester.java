package eight;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Regularni izraze -> pretraga, modifikacije ..manipulacije nad tekstom
 * <p>
 * @author grupa 1
 */
public class RegExpTester {

    public static void main(String[] args) {
        //Pattern, Matcher
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Unesi regularni izraz:");
                String regularniIzraz = scanner.nextLine();
                Pattern pattern = Pattern.compile(regularniIzraz);
                System.out.println("Unesi tekst za pretragu:");
                String uneseniTekst = scanner.nextLine();
                Matcher matcher = pattern.matcher(uneseniTekst);

                boolean found = false;
                while (matcher.find()) {
                    System.out.format("Pronašao sam text %s koji počinje na indeksu %s i završava na indeksu %s%n", matcher.group(), matcher.start(), matcher.end());
                    found = true;
                }
                if (!found) {
                    System.out.println("Nema ništa u tekstu :" + uneseniTekst + " što odgovara regularnom izrazu: " + regularniIzraz);
                }
            }
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
