import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI_openFile extends JFrame {
    private JFileChooser fileopen = new JFileChooser("Выбрать Файл");
    public GUI_openFile(){
        super("Open file");
        this.setBounds(500,500,500,500);

        Container container = this.getContentPane();
        container.add(fileopen);
    }
}
