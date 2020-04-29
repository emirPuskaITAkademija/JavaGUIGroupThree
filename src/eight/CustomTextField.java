/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eight;

import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *
 * @author grupa 1
 */
public class CustomTextField extends JTextField{

    public static final String REGEX_NUMBER = "[0-9]";
    private final Pattern pattern;

    public CustomTextField() {
        pattern = Pattern.compile(REGEX_NUMBER);
    }
    
    
    @Override
    public void setText(String text) {
        String number = pattern.matcher(text).replaceAll("");
        super.setText(number);
    }
    
    
    
}
