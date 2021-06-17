import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Formpannel extends JPanel  {

    private JLabel namelabel;
    private JTextField nameField;
    private JLabel joblabel;
    private JTextField jobtext;
    private  JButton subbtn;
    private Formlistner formlistner;
    private JList age;
    private JComboBox box;


    public Formpannel() {
        Dimension dim= getPreferredSize();
        dim.width=290;
        setPreferredSize(dim);
        setBackground(Color.GRAY);




        //intilazing Feilds
        namelabel= new JLabel("Name");
        nameField= new JTextField(10);
        joblabel= new JLabel("Job");
        jobtext= new JTextField(10);
        subbtn= new JButton("Submit");
        age= new JList();
        box= new JComboBox();



        //Creating a jList
        DefaultListModel agemodel= new DefaultListModel();

        //Class Method
        agemodel.addElement(new Agecategory(0,"Under 18"));
        agemodel.addElement(new Agecategory(1,"18 to 65"));
        agemodel.addElement(new Agecategory(2,"Above 65"));



        //Direct Method
//        agemodel.addElement("Under 18");
//        agemodel.addElement("18 to 65");
//        agemodel.addElement("Above 65");
        age.setModel(agemodel);
        age.setPreferredSize(new Dimension(100,100));
        age.setBorder(BorderFactory.createEtchedBorder());


             //Creating a Jcombo box
            DefaultComboBoxModel combomodel= new DefaultComboBoxModel();
            combomodel.addElement("Employed");
            combomodel.addElement("Self-Employed");
            combomodel.addElement("unEmployed");
            box.setModel(combomodel);

        //Adding Event listeer to submit button
        subbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=nameField.getText();
                String job= jobtext.getText();
                Agecategory ages= (Agecategory) age.getSelectedValue();


                //Calling Form Event
                FormEvent fv= new FormEvent(e, name,job,ages);//Intiliazing Feild

                if(formlistner!=null)
                {
                    formlistner.Formeventtrigger(fv);
                    nameField.setName("");
                    jobtext.setName("");
                }


            }
        });





        //Using Grid Layout to allign
        setLayout(new GridBagLayout());
        GridBagConstraints gc= new GridBagConstraints();

        gc.weightx=1;// Horizontal
//        gc.weighty=1;// Vertical

        //Row 1
        gc.weighty=0.1;
        gc.gridx=0;
        gc.gridy=0;
        gc.fill=GridBagConstraints.NONE;
        gc.anchor= GridBagConstraints.LAST_LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(namelabel, gc);

        gc.gridx++;
        gc.anchor= GridBagConstraints.LAST_LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(nameField,gc);


        //Row 2
        gc.gridx=0;
        gc.gridy++;
        gc.anchor= GridBagConstraints.LAST_LINE_END;
        gc.insets=new Insets(0,0,0,5);
        add(joblabel,gc);

        gc.gridx++;
        gc.anchor= GridBagConstraints.LAST_LINE_START;
        gc.insets=new Insets(0,0,0,0);
        add(jobtext,gc);

        //Row 3

    gc.gridy++;
        gc.anchor= GridBagConstraints.FIRST_LINE_START;
        gc.insets=new Insets(10,0,00,0);
        add(age,gc);


        //Row 4
        gc.gridy++;
        gc.anchor= GridBagConstraints.FIRST_LINE_START;
        gc.insets=new Insets(10,0,00,0);
        add(box,gc);

        //Row 5
        gc.weighty=2;
        gc.gridy++;
        gc.anchor= GridBagConstraints.FIRST_LINE_START;
        gc.insets=new Insets(10,0,00,0);
        add(subbtn,gc);
    }

    //intilazing Formlistber to get formpannel
    public void setFormlistner(Formlistner formlistner) {
        this.formlistner = formlistner;
    }
}
