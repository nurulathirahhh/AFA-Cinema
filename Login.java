import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import java.io.*;
import java.util.*;

class LoginFrame extends JFrame implements ActionListener {
   
   private JLabel lblUsername, lblPassword;
   private JTextField txtUsername;
   private JPasswordField txtPassword;
   private JButton btnExit, btnLogin, btnMenu;
   private JPanel pnlA, pnlB;
   
   public LoginFrame() {
   
      setTitle("LOGIN");
      Container cont = getContentPane();
      cont.setLayout(new BorderLayout());
      
      //set location
      setLocation(500, 200);
         
      //set up label
      lblUsername = new JLabel("Username");
      lblPassword = new JLabel("Password");
            
      //set up textfield
      txtUsername = new JTextField(17);
      txtPassword = new JPasswordField(17);
       
      //set up button
      btnExit = new JButton("Exit");
      btnLogin = new JButton("Login");
      btnMenu = new JButton("Menu");
      
      //set up JPanel
      pnlA = new JPanel();
      pnlA.setLayout(new GridLayout(4, 1));
      pnlA.setBorder(BorderFactory.createCompoundBorder(pnlA.getBorder(), BorderFactory.createEmptyBorder(5, 15, 5, 15)));
      pnlB = new JPanel();
      
      //add to JPanel
      pnlA.add(lblUsername);
      pnlA.add(txtUsername);
      pnlA.add(lblPassword);
      pnlA.add(txtPassword);
      pnlB.add(btnExit);
      pnlB.add(btnLogin);
      pnlB.add(btnMenu);
      
      //register actionListener
      btnExit.addActionListener(this);
      btnLogin.addActionListener(this);
      btnMenu.addActionListener(this);
      
      //add to container
      cont.add(pnlA, BorderLayout.NORTH);
      cont.add(pnlB, BorderLayout.SOUTH);
      
      setSize(300, 200);
      setVisible(true);
      setResizable(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);

   }
   
   public void actionPerformed(ActionEvent e) {
      if(e.getSource()==btnLogin){
         String username = txtUsername.getText();
         String password = new String(this.txtPassword.getPassword());

         BufferedReader in = null;
         try {
            in = new BufferedReader(new FileReader("CinemaMember.txt"));
            String inData = null;
            int m = 1, n;
            while((inData=in.readLine())!=null) {
               StringTokenizer st = new StringTokenizer(inData, ";");
               String firstC = st.nextToken().trim();
               String lastC = st.nextToken().trim();
               String usernameC = st.nextToken().trim();
               String passwordC = st.nextToken().trim();
               String emailC = st.nextToken().trim();
                  
               if(username.equals(usernameC) && password.equals(passwordC)) {
                  n = 1;
                  m = n;
               }
               else {
                  n = 2;    
               }
            }
            in.close();
            switch(m) {
               case 1 : {
                  JOptionPane.showMessageDialog(null, "Login successful!");
                  new MovieFrame();
                  dispose();
                  break;

               }
               case 2 : {
                  JOptionPane.showMessageDialog(null, "Wrong username or password.");
                  txtUsername.setText("");
                  txtPassword.setText("");
                  break;
               }
            }
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
      }
      else if(e.getSource()==btnMenu) {
         new MenuFrame();
         dispose();
      }
      else if(e.getSource()==btnExit)
         System.exit(0);
   }

}

public class Login {
   public static void main(String[] args) {
      new LoginFrame();
   }
}