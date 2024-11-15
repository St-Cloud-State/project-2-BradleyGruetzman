import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.io.*;
public class ClientButton extends JButton implements ActionListener{ 
  //private static ClerkButton instance;
  //private JButton userButton;
  public ClientButton() {
      super("Client");
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
    (WarehouseContext.instance()).setLogin(WarehouseContext.IsClient);
     Loginstate.instance().clear();
    (WarehouseContext.instance()).changeState(1);
  } 
}