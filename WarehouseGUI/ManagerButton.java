import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;
public class ManagerButton extends JButton implements ActionListener{ 
  //private static ClerkButton instance;
  //private JButton userButton;
  public ManagerButton() {
      super("Manager");
      this.setListener();
  }

/*  public static ClerkButton instance() {
    if (instance == null) {
      instance = new ClerkButton();
    }
    return instance;
  }*/

  public void setListener(){
    //System.out.println("In clerkButton setListener\n");
    this.addActionListener(this);
  }

  public void actionPerformed(ActionEvent event) {
     //System.out.println("In clerk \n");
    (WarehouseContext.instance()).setLogin(WarehouseContext.IsManager);
     Loginstate.instance().clear();
    (WarehouseContext.instance()).changeState(2);
  } 
}