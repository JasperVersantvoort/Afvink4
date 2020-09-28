package Paarden;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Paarden_race extends JFrame implements ActionListener {

    private static Paard p1;
    private static Paard p2;
    private JLabel label;
    private JButton button;
    private JPanel panel;

    public static void main(String[] args) throws InterruptedException {

        p1 = new Paard("Groen", Color.green);
        p2 = new Paard("Blauw", Color.blue);


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
        while (p1.getAfstand()<200 || p2.getAfstand()<200){
            p1.loop();
            p2.loop();
            tekenveld.drawRect(50, 100, p1.getAfstand(), 20);
            tekenveld.drawRect(50, 150, p2.getAfstand(), 20);

        }

    }
}
