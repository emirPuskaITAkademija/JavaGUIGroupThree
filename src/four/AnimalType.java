package four;

import java.awt.event.KeyEvent;

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
}
