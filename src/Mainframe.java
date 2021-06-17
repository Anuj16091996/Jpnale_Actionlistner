import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {

    private Formpannel formpannel;
    private Textpannel textpannel;

    Mainframe()
    {
        super("Hello");
        setLayout(new BorderLayout());


            ///Adding A formpannel
        formpannel= new Formpannel();
        add(formpannel, BorderLayout.WEST);

            //Calling Formlistner
        formpannel.setFormlistner(new Formlistner() {
            @Override
            public void Formeventtrigger(FormEvent e) {
                String name= e.getName();
                String job=e.getJob();
                Agecategory age=e.getAge();

                textpannel.appendtext("Name : " +
                        ""+name +
                        "\n Job: "+job+
                        "\n Age:" + age);
            }
        });


        ///Adding A Textpannel
        textpannel= new Textpannel();
        add(textpannel, BorderLayout.EAST);

        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);
    }
}
