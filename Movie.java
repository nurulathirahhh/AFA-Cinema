import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

class MovieFrame extends JFrame implements ActionListener, ItemListener {

   private JLabel lblAdult, lblKid, lblMember, lblTitle, lblSeat, lblHall, 
           lblTicket, lblDay, lblTime, lblTotal, lblMessage;
   private JTextField txtAdult, txtKid, txtTitle, txtSeat, txtTicket, txtTime, 
           txtTotal, txtDiscount;
   private JRadioButton rbtnMemberYes, rbtnMemberNo, rbtnHall1, rbtnHall2, rbtnHall3;
   private JComboBox comboDay;
   private ButtonGroup groupMember, groupHall;
   private JButton btnCalculate, btnSnacks, btnExit, btnClear;
   private JPanel pnlA, pnlB, pnlC, pnlD, pnlX, pnlY, pnlZ, pnlDetail, pnlTotal;
   
   public MovieFrame() {
      
      setTitle("MOVIE");
      Container cont = getContentPane();
      cont.setLayout(new BorderLayout());
      
      //set location
      setLocation(450, 50);
      
      //set up label
      lblAdult = new JLabel("No of adult : ");
      lblKid = new JLabel("No of kids : ");
      lblMember = new JLabel("Membership : ");
      lblTitle = new JLabel("Movie title : ");
      lblSeat = new JLabel("Seat no : ");
      lblHall = new JLabel("Hall no : ");
      lblTicket = new JLabel("Ticket price (RM) : ");
      lblDay = new JLabel("Day : ");
      lblTime = new JLabel("Time : ");
      lblTotal = new JLabel("Total price : ");
      lblMessage = new JLabel("Press 'Snacks' to purchase snacks, 'Exit' to finish session");
     
      //set up textfield
      txtAdult = new JTextField(10);
      txtKid = new JTextField(10);
      txtTitle = new JTextField(10);
      txtSeat = new JTextField(10);
      txtTicket = new JTextField(10);
      txtTime = new JTextField(10);
      txtTotal = new JTextField(10);
      txtTotal.setEditable(false);
      txtDiscount = new JTextField(10);
      txtDiscount.setVisible(false);

      //set up radio button
      rbtnMemberYes = new JRadioButton("Yes");
      rbtnMemberNo = new JRadioButton("No");
      rbtnHall1 = new JRadioButton("Hall 1");
      rbtnHall2 = new JRadioButton("Hall 2");
      rbtnHall3 = new JRadioButton("Hall 3");
      
      groupMember = new ButtonGroup();
      groupMember.add(rbtnMemberYes);
      groupMember.add(rbtnMemberNo);
      
      groupHall = new ButtonGroup();
      groupHall.add(rbtnHall1);
      groupHall.add(rbtnHall2);
      groupHall.add(rbtnHall3);

      //set up button
      btnCalculate = new JButton("Calculate");
      btnSnacks = new JButton("Snacks");
      btnExit = new JButton("Exit");
      btnClear = new JButton("Clear");
      
      //set up combo box
      comboDay = new JComboBox();
      comboDay.addItem("--Select--");
      comboDay.addItem("Public Holiday");
      comboDay.addItem("Sunday");
      comboDay.addItem("Monday");
      comboDay.addItem("Tuesday");
      comboDay.addItem("Wednesday");
      comboDay.addItem("Thursday");
      comboDay.addItem("Friday");
      comboDay.addItem("Saturday");

      
      //set up JPanel
      pnlDetail = new JPanel();
      pnlDetail.setLayout(new GridLayout(4, 0));
      pnlDetail.setBorder(new TitledBorder(new EtchedBorder(), "Details"));
      
      pnlA = new JPanel();
      pnlA.setLayout(new GridLayout(6, 2));
      
      pnlB = new JPanel();
      pnlB.setLayout(new GridLayout(1, 3));
      
      pnlC = new JPanel();
      pnlC.setLayout(new GridLayout(1, 4));
      
      pnlD= new JPanel();
      pnlD.setLayout(new GridLayout(3, 3));
      
      pnlTotal = new JPanel();
      pnlTotal.setLayout(new GridLayout(1, 0));
      pnlTotal.setBorder(new TitledBorder(new EtchedBorder(), "Total"));
      
      pnlY = new JPanel();
      
      pnlZ = new JPanel();
      
      pnlX = new JPanel();
      
      pnlDetail.add(pnlA);
      pnlDetail.add(pnlB);
      pnlDetail.add(pnlC);
      pnlDetail.add(pnlD);
      pnlTotal.add(pnlY);
      
      //add to JPanel   
      pnlA.add(lblAdult);
      pnlA.add(txtAdult);
      pnlA.add(lblKid);
      pnlA.add(txtKid);
      pnlA.add(lblTitle);
      pnlA.add(txtTitle);
      pnlA.add(lblSeat);
      pnlA.add(txtSeat);
      pnlA.add(lblTicket);
      pnlA.add(txtTicket);
      pnlA.add(lblTime);
      pnlA.add(txtTime);
      
      pnlB.add(lblMember);
      pnlB.add(rbtnMemberYes);
      pnlB.add(rbtnMemberNo);
      
      pnlC.add(lblHall);
      pnlC.add(rbtnHall1);
      pnlC.add(rbtnHall2);
      pnlC.add(rbtnHall3);
      
      pnlD.add(lblDay);
      pnlD.add(comboDay);
      
      pnlY.add(lblTotal);
      pnlY.add(txtTotal);
      pnlY.add(btnCalculate);
      pnlY.add(lblMessage);
      
      pnlX.add(txtDiscount);
      
      pnlZ.add(btnSnacks);
      pnlZ.add(btnExit);
      pnlZ.add(btnClear);

      //register itemlistener
      rbtnMemberYes.addItemListener(this);
      rbtnMemberNo.addItemListener(this);
      rbtnHall1.addItemListener(this);
      rbtnHall2.addItemListener(this);
      rbtnHall3.addItemListener(this);
      
      //register actionlistener
      btnCalculate.addActionListener(this);
      btnSnacks.addActionListener(this);
      btnExit.addActionListener(this);
      btnClear.addActionListener(this);
      comboDay.addActionListener(this);
      
      //add to container
      cont.add(pnlDetail, BorderLayout.NORTH);
      cont.add(pnlTotal, BorderLayout.CENTER);
      cont.add(pnlZ, BorderLayout.SOUTH);
      
      setSize(380, 700);
      setVisible(true);
      setResizable(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      
   }
     
   public void actionPerformed(ActionEvent e) {
      
      if(e.getSource()==btnCalculate) {
         String dayy = (String)comboDay.getSelectedItem();
         double price = 0;
         if(dayy.equals("Public Holiday"))
            price = 1.06;
         else if(dayy.equals("Saturday") || dayy.equals("Sunday"))
            price = 1.02;
         else if(dayy.equals("Wednesday"))
            price = 0.80;
         else if(dayy.equals("Monday") || dayy.equals("Tuesday") ||
                 dayy.equals("Thursday") || dayy.equals("Friday"))
            price = 1.00;
         
         double discount = Double.parseDouble(txtDiscount.getText());
         double ticket = Double.parseDouble(txtTicket.getText());
         double adult = Double.parseDouble(txtAdult.getText());
         double kids = Double.parseDouble(txtKid.getText());
         double pay = ((price*ticket*adult) + (price*ticket*kids*0.50)) * (1-discount); 
         
         txtTotal.setText("" + pay);
      }
      else if(e.getSource()==btnSnacks) {
         String total = txtTotal.getText();
         SnackWindow sw = new SnackWindow();
         sw.PassTotal(total);
         this.setVisible(false);
      }
      else if(e.getSource()==btnClear) {
         txtAdult.setText(" ");
         txtKid.setText(" ");
         txtTitle.setText(" ");
         txtSeat.setText(" ");
         txtTicket.setText(" ");
         txtTime.setText(" ");
         txtTotal.setText(" ");
      }
      else if(e.getSource()==btnExit)
         System.exit(0);
      
   }
   
   public void itemStateChanged(ItemEvent e) {
            
      double disc;
      if(e.getSource()==rbtnMemberYes) {
         disc = 0.10;
         txtDiscount.setText("" + disc);
      }
      if(e.getSource()==rbtnMemberNo){
         disc = 0;
         txtDiscount.setText("" + disc);
      }
      
   }
   
}

public class Movie {
   public static void main(String[] args) {
      
      new MovieFrame();
      
   }
}