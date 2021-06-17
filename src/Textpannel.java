import javax.swing.*;
import java.awt.*;

public class Textpannel extends JPanel {


    private JTextArea textArea;

    public Textpannel()
    {
        textArea= new JTextArea();
        setLayout(new BorderLayout());
        add(textArea,BorderLayout.CENTER);
        Dimension dim= getPreferredSize();
        dim.width=290;
        setPreferredSize(dim);
    }

    public void appendtext(String text)
    {
        textArea.setText(text);
    }
}
