import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.io.IOException;

class RegistrationFrame extends JFrame implements ActionListener {

      private JLabel lblMessage, lblFirst, lblLast, lblUsername, lblPassword, lblEmail;
      private JTextField txtFirst, txtLast, txtUsername, txtPassword, txtEmail;
      private JButton btnCancel, btnRegister, btnMenu;
      private JPanel pnlA, pnlB, pnlZ;
      
      public RegistrationFrame() {
         
         setTitle("REGISTRATION");
         Container cont = getContentPane();
         cont.setLayout(new BorderLayout());
         
         //set location
         setLocation(500, 200);
         
         //set up label
         lblMessage = new JLabel("Fill in your details");
         lblFirst = new JLabel("First name");
         lblLast = new JLabel("Last name");
         lblUsername = new JLabel("Username");
         lblPassword = new JLabel("Password");
         lblEmail = new JLabel("Email");
         
         //set up textfield
         txtFirst = new JTextField(17);
         txtLast = new JTextField(17);
         txtUsername = new JTextField(17);
         txtPassword = new JTextField(17);
         txtEmail = new JTextField(17);

         //set up button
         btnCancel = new JButton("Cancel");
         btnRegister = new JButton("Register");
         btnMenu = new JButton("Menu");
         
         //set up JPanel
         pnlA = new JPanel();
         pnlA.setLayout(new GridLayout(10, 1));
         pnlA.setBorder(BorderFactory.createCompoundBorder(pnlA.getBorder(), BorderFactory.createEmptyBorder(0, 15, 5, 15)));
         pnlZ = new JPanel();
         pnlZ.setBorder(BorderFactory.createCompoundBorder(pnlZ.getBorder(), BorderFactory.createEmptyBorder(5, 15, 0, 15)));
         pnlB = new JPanel();
         
         
         //add to JPanel
         pnlZ.add(lblMessage);
         pnlA.add(lblFirst);
         pnlA.add(txtFirst);
         pnlA.add(lblLast);
         pnlA.add(txtLast);
         pnlA.add(lblUsername);
         pnlA.add(txtUsername);
         pnlA.add(lblPassword);
         pnlA.add(txtPassword);
         pnlA.add(lblEmail);
         pnlA.add(txtEmail);
         pnlB.add(btnCancel);
         pnlB.add(btnRegister);
         pnlB.add(btnMenu);
               
         //register actionlistener
         btnCancel.addActionListener(this);
         btnRegister.addActionListener(this);
         btnMenu.addActionListener(this);
         
         //add to container
         cont.add(pnlZ, BorderLayout.NORTH);
         cont.add(pnlA);
         cont.add(pnlB, BorderLayout.SOUTH);
         
         setSize(300, 400);
         setVisible(true);
         setResizable(true);
         setDefaultCloseOperation(EXIT_ON_CLOSE);
         
      }
      
      public void actionPerformed(ActionEvent e) {
         
         String first = txtFirst.getText();
         String last = txtLast.getText();
         String username = txtUsername.getText();
         String password = txtPassword.getText();
         String email = txtEmail.getText();
         
         if(e.getSource()==btnRegister) {
            try {
               FileWriter fw = new FileWriter("CinemaMember.txt", true);
               BufferedWriter  out = new BufferedWriter(fw);
               out.write(first + ";" + last + ";" + username + ";" + password + ";" + email + "\n");
               out.close();
            }
         
            catch(FileNotFoundException fe) {
               System.out.println(fe.getMessage());
            }
            catch(NumberFormatException fe) {
               System.out.println(fe.getMessage());
            }
            catch(Exception ex) {
               System.out.println("Problem : " + ex.getMessage());
            }  
            
            JOptionPane.showMessageDialog(null, "Please login to continue");
            dispose();
            new LoginFrame();
         }
         else if(e.getSource()==btnMenu) {
            new MenuFrame();
            dispose();
         }
         else if(e.getSource()==btnCancel)
            System.exit(0);
         
      }
      
}

public class Registration {
   public static void main(String[] args) {   
      new RegistrationFrame();  
   }
}