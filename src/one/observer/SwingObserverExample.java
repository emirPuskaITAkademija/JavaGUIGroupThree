package one.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class SwingObserverExample {
    private JFrame frame;
    
    public void showFrame(){
        frame = new JFrame("Nas prozorcic");
        //OBSERVER Šablon
        //SUBJECT/Observable -> JButton objekat
        JButton brainButton = new JButton("Should I do it ?");
        //OBSERVERS -> ActionListener 
        brainButton.addActionListener(new AngelListener());
        brainButton.addActionListener(new DevilListener());
        frame.add(brainButton);
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    
    class AngelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Don't do it. You will regret it !????");
        }
    }
    
    class DevilListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Do it. You won't regret !!????");
        }
    }
    
    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.showFrame();
    }
}
