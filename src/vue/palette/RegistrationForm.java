package vue.palette;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;


public class RegistrationForm extends JFrame  {

    private JLabel nameLabel, emailLabel, cinLabel,telLabel,passwordLabel;
    private JTextField nameField, emailField,cinField,telField;
    private JPasswordField passwordField;
    private JButton submitButton;


    public RegistrationForm() {
        setTitle("Registration Form ^--^");
        ImageIcon icon = new ImageIcon("src/images/icons/bankIcon64.png");


        setIconImage(icon.getImage());

        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        panel.setBackground(new Color(173, 216, 230));


        ImageIcon icon1 = new ImageIcon("src/images/icons/resume.png");

        // Create a new label with the image icon
        JLabel nameLabel = new JLabel(icon1);

        // Add the label to the frame

        panel.add(nameLabel);

        nameField = new JTextField("Name");
        panel.add(nameField);




        ImageIcon icon2 = new ImageIcon("src/images/icons/gmail.png");

        // Create a new label with the image icon
        JLabel emailLabel = new JLabel(icon2);

        // Add the label to the frame
        panel.add(emailLabel);


        emailField = new JTextField("Email");
        panel.add(emailField);





        ImageIcon icon3 = new ImageIcon("src/images/icons/pass.png");

        // Create a new label with the image icon
        JLabel passwordLabel = new JLabel(icon3);

        // Add the label to the frame
        panel.add(passwordLabel);

        passwordField = new JPasswordField("Password");
        panel.add(passwordField);




                submitButton = new JButton("Submit");
        panel.add(new JLabel());
        panel.add(submitButton);

        add(panel);
        setVisible(true);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the values of the components
                String name = nameField.getText();
                String email = emailField.getText();

                String password = new String(passwordField.getPassword());

                try {
                    // Open the file for writing
                    FileWriter writer = new FileWriter("data.txt");

                    // Write the data to the file
                    writer.write(name + "," +email +  "," +password);
                    writer.write(System.lineSeparator());
                    writer.close();


                } catch (IOException ex) {
                    // Handle any errors that occur while writing the file
                    ex.printStackTrace();
                }
            }
        });
        }












    public static void main(String[] args) {
        new RegistrationForm();
    }
}
