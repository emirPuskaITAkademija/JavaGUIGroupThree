package two;

import java.net.URL;
import javax.swing.ImageIcon;

public class ImageIconLoader {
    private Class clazz; 

    public ImageIconLoader(Class clazz) {
        this.clazz = clazz;
    }
    
    
   
    //Refleksija
    public ImageIcon createImageIcon(String name) {//ime slike
        URL url = clazz.getResource(name);//dohvati mi resource .gif koji se nalazi u istom folderu kao i moja klasa ButtonPanel
        if (url != null) {
            ImageIcon icon = new ImageIcon(url);
            return icon;
        } else {
            System.err.println("Nisam mogao pronaći fajl pod imenom : " + name);
            return null;
        }
    }
}
