import javax.swing.*;

public class main {
    public static void main(String[] args) {

        System.out.println("Hello World");

        JFrame f = new JFrame("");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel myPanel = new MyPanel();
        myPanel.repaint();
        f.add(myPanel);
        f.pack();
        f.setVisible(true);
    }
}
