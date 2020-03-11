package two;
//1. JFrame -> prozor koji ima okno sa sadržajem -> content pane
//2. Kontrole -> JButton, JTextField, JComponent....
//3. LayoutManager
//OUTER
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class ProzorTester {

    public static void main(String[] args) {
        //System.out.println(Thread.currentThread().getName());

        // :: -> method referencing  -> shortcut za lambdu ali KADA ? 
        //ODOGOVOR: Kada lambda ne radi ništa drugo do poziva neke metode 
        //1. statičke metode
        //Runnable runnable = ProzorTester::createAndShowGUI;
        //2. objektnu metodu
       // ProzorTester prozorTester = new ProzorTester();
        //Runnable runnable1 = prozorTester::createAndShowGUIFromObjectMethod;
        SwingUtilities.invokeLater(ProzorTester::createAndShowGUI);
        //EventQueue.invokeLater(runnable);
        //new Thread(runnable).start();
    }

    private static void createAndShowGUI() {
        System.out.println(Thread.currentThread().getName());
        JFrame frame = new JFrame("Menu bar");
        frame.setSize(700, 200);
        frame.setVisible(true);
    }

    private void createAndShowGUIFromObjectMethod() {
        System.out.println(Thread.currentThread().getName());
        JFrame frame = new JFrame("Menu bar");
        frame.setSize(700, 200);
        frame.setVisible(true);
    }

    /* //INNER
    static class RunnableImplementation implements Runnable {

        @Override
        public void run() {
            JFrame frame = new JFrame("Menu bar");
            frame.setSize(700, 200);
            frame.setVisible(true);
        }
    }
     */
}
