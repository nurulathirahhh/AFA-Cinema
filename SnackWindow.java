import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;

public class SnackWindow extends JFrame implements ItemListener, ActionListener
{
   private JLabel lblPopcorn, lblDrinks, lblQty, lblSnacks, lblPrice, lblMovie, lblPay;
   private JRadioButton btnPopcorn1, btnPopcorn2, btnDrinks1, btnDrinks2, btnDrinks3;
   private ButtonGroup groupPC, groupD;
   private JButton btnOk, btnExt;
   private JTextField txtQty, txtSnacks, txtPrice, txtMovie, txtPay, txtPC;
   private JPanel pnlA, pnlB, pnlC, pnlY, pnlZ, pnlProdInfo, pnlOutput;
   
   public static String total;
   public void PassTotal(String movie) {
		txtMovie.setText("" + movie);
	}
   
   public SnackWindow()
   {
            
      setTitle("Food & Beverages");
      Container cont = getContentPane();
      cont.setLayout(new BorderLayout());
      
      //set location
      setLocation(450, 50);
      
      //LABEL (SU)
      lblPopcorn = new JLabel("POPCORN");
      lblDrinks = new JLabel("DRINKS");
      lblPrice = new JLabel("Price :");
      lblQty = new JLabel("Quantity :");
      lblSnacks = new JLabel("Total Snacks :");
      lblMovie = new JLabel("Total Ticket :");
      lblPay = new JLabel("Total pay :");
      
      //TEXT (SU)
      txtQty = new JTextField(5);
      txtPrice = new JTextField(5);
      txtPrice.setEditable(false);
      txtSnacks = new JTextField(5);
      txtSnacks.setEditable(false);
      txtMovie = new JTextField(5);
      txtMovie.setEditable(false);
      txtPay = new JTextField(5);
      txtPay.setEditable(false);
      txtPC = new JTextField(5);
      txtPC.setVisible(false);

      //RADIO BUTTON (SU)
      btnPopcorn1 = new JRadioButton("PREMIUM");
      btnPopcorn2 = new JRadioButton("ORIGINAL");
      btnDrinks1 = new JRadioButton("SOFT DRINK");
      btnDrinks2 = new JRadioButton("JUICE");
      btnDrinks3 = new JRadioButton("MINERAL WATER");
      groupPC = new ButtonGroup();
      groupD = new ButtonGroup();
      groupPC.add(btnPopcorn1);
      groupPC.add(btnPopcorn2);
      groupD.add(btnDrinks1);
      groupD.add(btnDrinks2);
      groupD.add(btnDrinks3);
      
      //BUTTON (SU)
      btnOk = new JButton("OK!");
      btnExt = new JButton("EXIT");
      
      //JPanel (SU)
      pnlProdInfo = new JPanel();
      pnlProdInfo.setLayout(new GridLayout(3,0));
      pnlProdInfo.setBorder(new TitledBorder(new EtchedBorder(), "SNACKS"));
      
      pnlA = new JPanel();
      pnlA.setLayout(new GridLayout(3,1));
      
      pnlB = new JPanel();
      pnlB.setLayout(new GridLayout(4,1));
      
      pnlC = new JPanel();
      pnlC.setLayout(new GridLayout(2,2));
      
      pnlOutput = new JPanel();
      pnlOutput.setLayout(new GridLayout(1,2));
      pnlOutput.setBorder(new TitledBorder(new EtchedBorder(), "TOTAL AMOUNT"));
      
      pnlY = new JPanel();
      pnlY.setLayout(new GridLayout(4,1));
      
      pnlZ = new JPanel();
      pnlZ.setLayout(new GridLayout(1,2));
      
      pnlProdInfo.add(pnlA);
      pnlProdInfo.add(pnlB);
      pnlProdInfo.add(pnlC);
      pnlOutput.add(pnlY);
      
      //Add to JPanel
      pnlA.add(lblPopcorn);
      pnlA.add(btnPopcorn1);
      pnlA.add(btnPopcorn2);
      pnlB.add(lblDrinks);
      pnlB.add(btnDrinks1);
      pnlB.add(btnDrinks2);
      pnlB.add(btnDrinks3);
      pnlC.add(lblQty);
      pnlC.add(txtQty);
      
      pnlC.add(lblPrice);
      pnlC.add(txtPrice);
      
      pnlY.add(lblSnacks);
      pnlY.add(txtSnacks);
      pnlY.add(lblMovie);
      pnlY.add(txtMovie);
      pnlY.add(lblPay);
      pnlY.add(txtPay);
      pnlY.add(txtPC);
      
      pnlZ.add(btnOk);
      pnlZ.add(btnExt);
      
      //Register ItemListener
      btnPopcorn1.addItemListener(this);
      btnPopcorn2.addItemListener(this);
      btnDrinks1.addItemListener(this);
      btnDrinks2.addItemListener(this);
      btnDrinks3.addItemListener(this);
      
      //Register actionListener
      btnOk.addActionListener(this);
      btnExt.addActionListener(this);
      
      //Add to container
      cont.add(pnlProdInfo, BorderLayout.NORTH);
      cont.add(pnlOutput, BorderLayout.CENTER);
      cont.add(pnlZ,BorderLayout.SOUTH);
      
      setSize(380,500);
      setVisible(true);
   }
   
   public void itemStateChanged(ItemEvent e)
   {
      double pricePC = 0, price = 0;
      
      if(e.getSource()==btnPopcorn1  )
      {
         pricePC = 4; 
         txtPC.setText("" + pricePC);
      }
      
      else if(e.getSource()==btnPopcorn2)
      {
         pricePC = 3; 
         txtPC.setText("" + pricePC);
      }
      
      if(e.getSource()==btnDrinks1)
         {
            pricePC = Double.parseDouble(txtPC.getText()); 
            price = pricePC+ 3.50;
            txtPrice.setText(""+price);
         }
         else if(e.getSource()==btnDrinks2)
         {
            pricePC = Double.parseDouble(txtPC.getText());
            price=pricePC+ 5.00;
            txtPrice.setText(""+price);
         }
         else if(e.getSource()==btnDrinks3)
         {
            pricePC = Double.parseDouble(txtPC.getText());
            price= pricePC + 6.00;
            txtPrice.setText(""+price);
         }
      
   }
   
   public void actionPerformed(ActionEvent e)
   {
      
      if(e.getSource()==btnOk)
      {
         double quantity = Double.parseDouble(txtQty.getText());
         double price = Double.parseDouble(txtPrice.getText());
         double ticket = Double.parseDouble(txtMovie.getText());
         
         double snacks = quantity * price;
         double pay = snacks + ticket;
         txtSnacks.setText("" + snacks);
         txtPay.setText("RM" + String.format("%.2f", pay));
      }
      else if(e.getSource()==btnExt)
      {
         System.exit(0);
      }
   }
   
   public static void main(String[] args)
   {
      SnackWindow frame = new SnackWindow();
   }
}