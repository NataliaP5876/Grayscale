
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_original extends JFrame {
    private JLabel input = new JLabel("Исходное изображение:");
    private JPanel img1 = new JPanel();
    private JPanel img2 = new JPanel();
    private JLabel output = new JLabel("Результат:");
    private JButton start = new JButton("Запустить");
    private JButton fileopen = new JButton("Выбрать Файл");

    public GUI_original(){
        super("HM Grayscale");
        this.setBounds(200,200,500,200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1,2,2,2));

        JPanel col1 = new JPanel();
        col1.setLayout(new GridLayout(3,1,2,2));
        col1.add(input);
        col1.add(img1);
        col1.add(img2);
        img1.setBackground(Color.white);
        img1.setPreferredSize(new Dimension(200, 200));
        JPanel col2 = new JPanel();

        container.add(col1);
        container.add(col2);

        /*container.add(input);
        container.add(output);
        container.add(img1);
        container.add(img2);
        img1.setBackground(Color.white);

        img1.setPreferredSize(new Dimension(200, 200));
        fileopen.addActionListener(new StartGrayscale());

        container.add(fileopen);
        container.add(start);*/

    }

    class StartGrayscale implements ActionListener {
        public void actionPerformed (ActionEvent e){
            GUI_openFile app2 = new GUI_openFile();
            app2.setVisible(true);
        }
    }
}
