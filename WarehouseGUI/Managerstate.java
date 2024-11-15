import java.util.*;
import java.text.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
public class Managerstate extends WarehouseState {
  private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  private static Warehouse warehouse;
  private WarehouseContext context;
  private static Managerstate instance;
  private JFrame frame;
  private static final int EXIT = 0;
  private static final int ADD_MEMBER = 1;
  private static final int ADD_BOOKS = 2;
  private static final int ISSUE_BOOKS = 3;
  private static final int RETURN_BOOKS = 4;
  private static final int REMOVE_BOOKS = 6;
  private static final int PLACE_HOLD = 7;
  private static final int REMOVE_HOLD = 8;
  private static final int PROCESS_HOLD = 9;
  private static final int GET_TRANSACTIONS = 10;
  private static final int USERMENU = 11;
  private static final int HELP = 13;
  private Managerstate() {
      super();
      warehouse = Warehouse.instance();
      //context = LibContext.instance();
  }
  public static Managerstate instance() {
    if (instance == null) {
      instance = new Managerstate();
    }
    return instance;
  }

  @Override
  public void run() {
    frame = WarehouseContext.instance().getFrame();
    frame.getContentPane().removeAll();

    JButton logoutButton = new JButton("Logout");
    logoutButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            WarehouseContext.instance().changeState(3); // LoginState index
        }
    });

    frame.getContentPane().add(logoutButton);
    frame.revalidate();
    frame.repaint();
 }






  public String getToken(String prompt) {
    do {
      try {
        System.out.println(prompt);
        String line = reader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(line,"\n\r\f");
        if (tokenizer.hasMoreTokens()) {
          return tokenizer.nextToken();
        }
      } catch (IOException ioe) {
        System.exit(0);
      }
    } while (true);
  }
  private boolean yesOrNo(String prompt) {
    String more = getToken(prompt + " (Y|y)[es] or anything else for no");
    if (more.charAt(0) != 'y' && more.charAt(0) != 'Y') {
      return false;
    }
    return true;
  }
  public int getNumber(String prompt) {
    do {
      try {
        String item = getToken(prompt);
        Integer num = Integer.valueOf(item);
        return num.intValue();
      } catch (NumberFormatException nfe) {
        System.out.println("Please input a number ");
      }
    } while (true);
  }
  public Calendar getDate(String prompt) {
    do {
      try {
        Calendar date = new GregorianCalendar();
        String item = getToken(prompt);
        DateFormat df = SimpleDateFormat.getDateInstance(DateFormat.SHORT);
        date.setTime(df.parse(item));
        return date;
      } catch (Exception fe) {
        System.out.println("Please input a date as mm/dd/yy");
      }
    } while (true);
  }
  public int getCommand() {
    do {
      try {
        int value = Integer.parseInt(getToken("Enter command:" + HELP + " for help"));
        if (value >= EXIT && value <= HELP) {
          return value;
        }
      } catch (NumberFormatException nfe) {
        System.out.println("Enter a number");
      }
    } while (true);
  }

  public void help() {
    System.out.println("Enter a number between 0 and 12 as explained below:");
    System.out.println(EXIT + " to Exit\n");
    System.out.println(ADD_MEMBER + " to add a member");
    System.out.println(ADD_BOOKS + " to  add books");
    System.out.println(RETURN_BOOKS + " to  return books ");
    System.out.println(REMOVE_BOOKS + " to  remove books");
    System.out.println(PROCESS_HOLD + " to  process holds");
    System.out.println(USERMENU + " to  switch to the user menu");
    System.out.println(HELP + " for help");
  }












  /*public boolean clientmenu()
  {
    String userID = getToken("Please input the user id: ");
    if (Warehouse.instance().searchMembership(clientID) != null){
      (WarehouseContext.instance()).setUser(clientID);      
      return true;
    }
    else 
      System.out.println("Invalid user id."); return false;
  }*/

  public void terminate(int exitcode)
  {
    (WarehouseContext.instance()).changeState(exitcode); // exit with a code 
  }
 

  public void process() {
    int command, exitcode = -1;
    help();
    boolean done = false;
    while (!done) {
      switch (getCommand()) {
        /*case ADD_MEMBER:        addMember();
                                break;
        case ADD_BOOKS:         addBooks();
                                break;
        case RETURN_BOOKS:      returnBooks();
                                break;
        case REMOVE_BOOKS:      removeBooks();
                                break;
        case PROCESS_HOLD:      processHolds();
                                break;
        case USERMENU:          if (usermenu())
                                  {exitcode = 1;
                                   done = true;}
                                break;
        case HELP:              help();
                                break;
        case EXIT:              exitcode = 0;
                                done = true; break;*/
      }
    }
    terminate(exitcode);
  }
  /*public void run() {
    process();
  }*/



}