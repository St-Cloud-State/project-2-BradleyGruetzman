import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;
public class ClerkButton extends JButton implements ActionListener{ 
  
  public ClerkButton() {
      super("Clerk");
      this.setListener();
  }



  public void setListener(){
    //System.out.println("In clerkButton setListener\n");
    this.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
     //System.out.println("In clerk \n");
    (WarehouseContext.instance()).setLogin(WarehouseContext.IsClerk);
     Loginstate.instance().clear();
    (WarehouseContext.instance()).changeState(0);
  } 
}