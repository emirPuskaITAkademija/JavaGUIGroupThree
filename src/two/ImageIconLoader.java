package two;

import java.net.URL;
import javax.swing.ImageIcon;

public class ImageIconLoader {

    //Refleksija
    public ImageIcon createImageIcon(String name) {
        URL url = ButtonPanel.class.getResource(name);//dohvati mi resource .gif koji se nalazi u istom folderu kao i moja klasa ButtonPanel
        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            return icon;
        } else {
            System.err.println("Nisam mogao pronaći fajl pod imenom : " + name);
            return null;
        }
    }
}
