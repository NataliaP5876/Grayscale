
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GUI_original extends JFrame {
    private JLabel input = new JLabel("");
    private JPanel img1 = new JPanel();
    private JPanel img2 = new JPanel();
    private JLabel picLabel1 = new JLabel();
    private JLabel picLabel2 = new JLabel();
    private JLabel output = new JLabel("");
    private JButton start = new JButton("Start");
    private JButton fileopen = new JButton("Select Image");
    private String pathInput;
    private String pathOutput;


    public GUI_original() {
        super("HM Grayscale");
        this.setBounds(200,200,1200,800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        img1.setPreferredSize(new Dimension(500, 700));
        img2.setPreferredSize(new Dimension(500, 700));
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1,2,2,2));
        JPanel col1 = new JPanel();
        col1.setLayout(new GridBagLayout());
        JPanel col2 = new JPanel();
        col2.setLayout(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.weighty = 0.3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        col1.add(input, c);

        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
        col2.add(output, c);

        c.weightx = 0.5;
        c.weighty = 3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;

        img1.add(picLabel1);
        col1.add(img1, c);

        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        img2.add(picLabel2);
        col2.add(img2, c);

        c.weightx = 0.5;
        c.weighty = 0.3;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        col1.add(fileopen, c);

        c.weightx = 0.5;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 2;
        col2.add(start, c);

        container.add(col1);
        container.add(col2);

        fileopen.addActionListener(new OpenFile());
        start.addActionListener(new StartGrayscale());
    }

    class OpenFile implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            JFileChooser fileopen = new JFileChooser("C:\\Users\\Vol4onka\\Desktop\\image\\test");
            fileopen.setFileHidingEnabled(false);
            fileopen.setAcceptAllFileFilterUsed(false);
            String[] extensions= {"png","jpg","jpeg"};
            FileNameExtensionFilter filter = new FileNameExtensionFilter("image (*.png, *.jpg, *.jpeg)",extensions);
            fileopen.setFileFilter(filter);

            int ret = fileopen.showDialog(null, "Open image");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                pathInput = file.getPath();
                BufferedImage myPicture = null;
                try {
                    myPicture = ImageIO.read(new File(pathInput));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (myPicture.getHeight()>=myPicture.getWidth() && myPicture.getHeight()>600){
                    Image scaled = myPicture.getScaledInstance(-1,600, Image.SCALE_SMOOTH);
                    picLabel1.setIcon(new ImageIcon(scaled));
                }
                else {
                    if (myPicture.getHeight() < myPicture.getWidth() && myPicture.getWidth() > 600) {
                        Image scaled = myPicture.getScaledInstance(600, -1, Image.SCALE_SMOOTH);
                        picLabel1.setIcon(new ImageIcon(scaled));
                    }
                    else {
                        picLabel1.setIcon(new ImageIcon(myPicture));
                    }
                }

                input.setText("Original image:");
            }
        }
    }

    class StartGrayscale implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            JFileChooser fileSaveDirectoty = new JFileChooser("C:\\Users\\Vol4onka\\Desktop\\image\\test");
            fileSaveDirectoty.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int ret = fileSaveDirectoty.showDialog(null,"Select directory");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileSaveDirectoty.getSelectedFile();
                pathOutput = file.getPath()+"\\Output.jpg";
                try {
                    Grayscale.grayscale(pathInput, pathOutput);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                BufferedImage myPicture = null;
                try {
                    myPicture = ImageIO.read(new File(pathOutput));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (myPicture.getHeight()>=myPicture.getWidth() && myPicture.getHeight()>600){
                    Image scaled = myPicture.getScaledInstance(-1,600, Image.SCALE_SMOOTH);
                    picLabel2.setIcon(new ImageIcon(scaled));
                }
                else {
                    if (myPicture.getHeight() < myPicture.getWidth() && myPicture.getWidth() > 600) {
                        Image scaled = myPicture.getScaledInstance(600, -1, Image.SCALE_SMOOTH);
                        picLabel2.setIcon(new ImageIcon(scaled));
                    }
                    else {
                        picLabel2.setIcon(new ImageIcon(myPicture));
                    }
                }
                output.setText("Result:");
            }
        }
    }
}
