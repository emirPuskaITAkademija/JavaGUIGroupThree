package two;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
//JFRAME
//JComponent
//LayoutManager
//COntagion 2011
public class ButtonPanel extends JPanel implements ActionListener {

    private JButton leftButton;
    private JButton middleButton;
    private JButton rightButton;

    public ButtonPanel() {
        //kreirali button -> 3 left, middle, right
        ImageIconLoader iconLoader = new ImageIconLoader(ButtonPanel.class);
        ImageIcon leftImageIcon = iconLoader.loadImageIcon("right.gif");
        this.leftButton = new JButton("Disable middle button", leftImageIcon);//left.gif / ImageIcon
        this.leftButton.setVerticalTextPosition(SwingConstants.CENTER);
        this.leftButton.setHorizontalTextPosition(SwingConstants.LEADING);
        this.leftButton.setActionCommand("disable");
        this.leftButton.setMnemonic(KeyEvent.VK_D);
        this.leftButton.addActionListener(this);
        ImageIcon middleIcon = iconLoader.loadImageIcon("middle.gif");
        this.middleButton = new JButton("Middle button", middleIcon);//middle.gif
        this.middleButton.setHorizontalTextPosition(SwingConstants.CENTER);
        this.middleButton.setVisible(false);
        this.middleButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        ImageIcon rightImageIcon = iconLoader.loadImageIcon("left.gif");
        this.rightButton = new JButton("Enable middle button", rightImageIcon);//right.gif
        this.rightButton.setActionCommand("enable");
        this.rightButton.setMnemonic(KeyEvent.VK_E);
        this.rightButton.addActionListener(this);
        //dodati buttons u panel
        add(leftButton);
        add(middleButton);
        add(rightButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if ("enable".equals(command)) {
            middleButton.setEnabled(true);
            middleButton.setVisible(true);
        } else {
            middleButton.setEnabled(false);
            middleButton.setVisible(false);
        }
        System.out.println("Vozdra raja iz ButtonPanela koji je ujedno i ActionListener");
    }

}
