// AbstractAccountView.java
// AbstractAccountView is an abstract class that represents
// a view of an Account.
package account;

// Java core packages
import java.util.*;
import java.awt.*;

// Java extension packages
import javax.swing.JPanel;
import javax.swing.border.*;

public abstract class AbstractAccountView extends JPanel 
   implements Observer {
   
   // Account to observe
   private Account account;
   
   // AbstractAccountView constructor
   public AbstractAccountView( Account observableAccount )
      throws NullPointerException
   {
      // do not allow null Accounts
      if ( observableAccount == null )
         throw new NullPointerException();
      
      // update account data member to new Account
      account = observableAccount;
      
      // register as an Observer to receive account updates
      account.addObserver( this );      
      
      // set display properties
      setBackground( Color.white );
      setBorder( new MatteBorder( 1, 1, 1, 1, Color.black ) );
   }
   
   // get Account for which this view is an Observer
   public Account getAccount()
   {
      return account;
   }
   
   // update display with Account balance
   protected abstract void updateDisplay();
   
   // receive updates from Observable Account
   public void update( Observable observable, Object object )
   {
      updateDisplay();
   }
}
