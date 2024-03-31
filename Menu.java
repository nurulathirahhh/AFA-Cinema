import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
class MenuFrame extends JFrame implements ActionListener {
   
   private JLabel lblWelcome;
   private JButton btnWelcome, btnRegister, btnLogin, btnBook, btnExit;
   private JPanel pnlA;
   
   public MenuFrame() {
      
      setTitle("AFA Cinema");
      Container cont = getContentPane();
      cont.setLayout(new BorderLayout(5, 1));
      
      //set location
      setLocation(500, 250);
         
      //set up label
      lblWelcome = new JLabel("Welcome to AFA Cinema");
      lblWelcome.setFont(new Font("Verdana", Font.PLAIN, 15));
      lblWelcome.setBorder(BorderFactory.createCompoundBorder(lblWelcome.getBorder(), BorderFactory.createEmptyBorder(5, 50, 0, 15)));
      
      //set up button
      btnRegister = new JButton("Register as Member");
      btnLogin = new JButton("Login to Account");
      btnBook = new JButton("Book Ticket");
      btnExit = new JButton("Exit");
      
      //set up JPanel
      pnlA = new JPanel();
      pnlA.setLayout(new GridLayout(4, 1, 50, 5));
      pnlA.setBorder(BorderFactory.createCompoundBorder(pnlA.getBorder(), BorderFactory.createEmptyBorder(15, 15, 15, 15)));
      
      //add to JPanel
      pnlA.add(btnRegister);
      pnlA.add(btnLogin);
      pnlA.add(btnBook);
      pnlA.add(btnExit);
      
      //register actionListener
      btnRegister.addActionListener(this);
      btnLogin.addActionListener(this);
      btnBook.addActionListener(this);
      btnExit.addActionListener(this);
      
      //add to container
      cont.add(lblWelcome, BorderLayout.NORTH);
      cont.add(pnlA);
      
      setSize(300, 250);
      setVisible(true);
      setResizable(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
   }
   
   public void actionPerformed(ActionEvent e) {
      
      if(e.getSource()==btnRegister) {
         new RegistrationFrame();
         dispose();
      }
      else if(e.getSource()==btnLogin) {
         new LoginFrame();
         dispose();
      }
      else if(e.getSource()==btnBook) {
         new MovieFrame();
         dispose();
      }
      else if(e.getSource()==btnExit)
         System.exit(0);
         
   }
   
}

public class Menu {
   public static void main(String[] args) {
      new MenuFrame();
   }
}