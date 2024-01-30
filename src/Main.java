import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] coords = new int[5];
        JTextField smallField = new JTextField("300, 250, 25, 45, 20");
        JTextField numbers = new JTextField("0, 1, 2, 3, 4, 5, 6, 7, 8, 9");
        MyPanel myPanel = new MyPanel();
        JFrame f = new JFrame("Swing Paint Demo");

        numbers.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String[] params = smallField.getText().replaceAll(" ", "").split(",");

                if (params.length < 6) {
                    JOptionPane.showMessageDialog(null, "Ошибка в количестве параметров");
                }

                for (int i = 0; i < params.length; i++) {
                    coords[i] = getInteger(params[i]);
                }

                myPanel.setX(coords[0]);
                myPanel.setY(coords[1]);
                myPanel.setWidth(coords[2]);
                myPanel.setHeight(coords[3]);
                myPanel.setStep(coords[4]);
                myPanel.SetSymbols(numbers.getText());
                myPanel.repaint();
                f.add(myPanel);
                f.pack();
                f.setVisible(true);
            }
        });

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));

        contents.add(numbers);
        contents.add(smallField);
        f.setContentPane(contents);


        myPanel.repaint();
        myPanel.SetSymbols("1, 2, 3");
        f.add(myPanel);
        f.pack();
        f.setVisible(true);
    }

    private static int getInteger(String params) {
        try {
            return Integer.parseInt(params);
        } catch (Exception e) {
            new Exception("Это не цифра");
        }
        return 0;
    }
}