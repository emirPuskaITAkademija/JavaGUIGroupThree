package four;

import java.awt.event.KeyEvent;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum AnimalType {
    BIRD("Bird", KeyEvent.VK_B),
    CAT("Cat", KeyEvent.VK_C),
    DOG("Dog", KeyEvent.VK_D),
    RABBIT("Rabbit", KeyEvent.VK_R),
    PIG("Pig", KeyEvent.VK_P);

    private final String name;
    private final int keyEvent;

    private AnimalType(String name, int keyEvent) {
        this.name = name;
        this.keyEvent = keyEvent;
    }

    public String getName() {
        return name;
    }

    public String getFileName() {
        String nameWithoutExtension = getName();
        return nameWithoutExtension + ".gif";
    }

    public int getKeyEvent() {
        return keyEvent;
    }

    public static String[] findPetNames() {
        AnimalType[] animals = AnimalType.values();
        String[] petNames = new String[animals.length];//5 praznih
        for (int i = 0; i < animals.length; i++) {
            AnimalType animalType = animals[i];
            String animalName = animalType.getName();
            petNames[i] = animalName;
        }
        return petNames;
    }

    //Supplier, Consumer, Function<T, R>
    public static String[] findPetNamesLambda() {
        Function<AnimalType, String> transformer = animal -> animal.getName();
        AnimalType[] animals = AnimalType.values();
        List<String> animalList = Stream.of(animals)//AnimalyType
                .map(transformer)//AnimalType -> String
                .collect(Collectors.toList());//List<String>
        
        return animalList.toArray(new String[animals.length]);
        /*return Stream.of(animals)
                .map(AnimalType::getName)
                .collect(Collectors.toList())
                .toArray(new String[animals.length]);*/
    }
}
