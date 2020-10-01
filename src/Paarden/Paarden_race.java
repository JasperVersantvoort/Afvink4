package Paarden;
/**
 * Paard race
 *
 * @author Jasper Versantvoort
 * Hogeschool van Arnhem en Nijmegen
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paarden_race extends JFrame implements ActionListener {

    private static Paard p1;
    private static Paard p2;
    private static Paard p3;
    private JLabel label;
    private JButton button;
    private JPanel panel;

    public static void main(String[] args) throws InterruptedException {

        p1 = new Paard("Groen", Color.green);
        p2 = new Paard("Blauw", Color.blue);
        p3 = new Paard("Rood", Color.red);


        Paarden_race frame = new Paarden_race();
        frame.setSize(500, 500);
        frame.createGui();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    private void createGui() throws InterruptedException {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());


        label = new JLabel("Welkom bij paarden race");
        window.add(label);

        button = new JButton("Start");
        button.addActionListener(this);
        window.add(button);

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 300));
        panel.setBackground(Color.white);
        window.add(panel);
        panel.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Graphics tekenveld = panel.getGraphics();
        tekenveld.drawLine(250, 50, 250, 250);
        //tekenveld.drawRect(50,100,p1.getAfstand(),20);
        while (p1.getAfstand() < 200 && p2.getAfstand() < 200 && p3.getAfstand() < 200) {
            p1.loop();
            p2.loop();
            p3.loop();
            tekenveld.setColor(p1.getKleur());
            tekenveld.drawRect(50, 100, p1.getAfstand(), 20);
            tekenveld.fillRect(50, 100, p1.getAfstand(), 20);
            tekenveld.setColor(p2.getKleur());
            tekenveld.drawRect(50, 150, p2.getAfstand(), 20);
            tekenveld.fillRect(50, 150, p2.getAfstand(), 20);
            tekenveld.setColor(p3.getKleur());
            tekenveld.drawRect(50, 200, p3.getAfstand(), 20);
            tekenveld.fillRect(50, 200, p3.getAfstand(), 20);
            try {
                Thread.sleep(25);
            } catch (InterruptedException ex) {
                System.out.println("Pauze interruptie");
            }
        }
        if (p1.getAfstand()>=200) {
            JOptionPane.showMessageDialog(null, p1.getNaam() + " wint");
        }
        else if (p2.getAfstand()>=200) {
            JOptionPane.showMessageDialog(null, p2.getNaam() + " wint");
        }
        else if (p3.getAfstand()>=200) {
            JOptionPane.showMessageDialog(null, p3.getNaam() + " wint");
        }
    }
}

