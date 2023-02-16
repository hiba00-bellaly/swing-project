package vue.palette;

import vue.palette.NewPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.Exception;

//create CreateLoginForm class to create login form
//class extends JFrame to create a window where our component add
//class implements ActionListener to perform an action on button click
class CreateLoginForm extends JFrame implements ActionListener
{
    //initialize button, panel, label, and text field
    JButton b1;
    JPanel newPanel;
    JLabel userLabel, passLabel;
    final JTextField  textField1, textField2;

    //calling constructor
    CreateLoginForm()
    {


        setTitle("WELCOME TO OUR BANK");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the logo image
        Image logoImage = Toolkit.getDefaultToolkit().getImage("images/icons/bankIcon64.png");
        setIconImage(logoImage);
        //create label for username
        userLabel = new JLabel();
        userLabel.setText("Username");
        userLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        userLabel.setSize(300, 30);
        userLabel.setLocation(300, 30);//set label value for textField1

        textField1= new JPasswordField(15);
        textField1.setFont(new Font("Arial", Font.PLAIN, 15));
        textField1.setSize(190, 20);
        textField1.setLocation(200, 100);



        //create label for password
        passLabel = new JLabel();
        passLabel.setText("Password");
        passLabel.setFont(new Font("Arial", Font.PLAIN, 30));
        passLabel.setSize(300, 30);
        passLabel.setLocation(300, 30);


        //create text field to get password from the user
        textField2 = new JPasswordField(15);
        textField2.setFont(new Font("Arial", Font.PLAIN, 15));
        textField2.setSize(190, 20);
        textField2.setLocation(200, 100);


        //create submit button
        b1 = new JButton("SUBMIT"); //set label to button
        b1 = new JButton("Submit");
        b1.setFont(new Font("Arial", Font.PLAIN, 15));
        b1.setSize(100, 20);
        b1.setLocation(150, 450);
        b1.addActionListener(this);


        //create panel to put form elements
        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(userLabel);    //set username label to panel
        newPanel.add(textField1);   //set text field to panel
        newPanel.add(passLabel);    //set password label to panel
        newPanel.add(textField2);
        newPanel.add(b1);           //set button to panel
        setLocationRelativeTo(null);
        //set border to panel
        add(newPanel, BorderLayout.CENTER);
        newPanel.setBackground(Color.lightGray);



        //perform action on button click
        b1.addActionListener(this);     //add action listener to button

    }



    //define abstract method actionPerformed() which will be called on button click
    public void actionPerformed(ActionEvent ae)     //pass action listener as a parameter
    {
        String userValue = textField1.getText();        //get user entered username from the textField1
        String passValue = textField2.getText();        //get user entered pasword from the textField2

        //check whether the credentials are authentic or not
        if (userValue.equals("AYA") && passValue.equals("AYA")) {  //if authentic, navigate user to a new page

            //create instance of the NewPage
            NewPage page = new NewPage();

            //make page visible to the user
            page.setVisible(true);

            //create a welcome label and set it to the new page
            JLabel wel_label = new JLabel("Welcome: "+userValue);
            page.getContentPane().add(wel_label);
        }
        else{
            //show error message
            System.out.println("Please enter valid username and password");
        }
    }
}
//create the main class
class LoginFormDemo
{
    //main() method start
    public static void main(String arg[])
    {
        try
        {
            //create instance of the CreateLoginForm
            CreateLoginForm form = new CreateLoginForm();
            form.setSize(300,200);  //set size of the frame
            form.setVisible(true);  //make form visible to the user
        }
        catch(Exception e)
        {
            //handle exception
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}