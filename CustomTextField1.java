import javax.swing.*;

import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class CustomTextField1 extends JTextField {

  private final Color BORDER_COLOR=new Color(203,213,255);
  private final Color ACTIVE_BORDER_COLOR=new Color(59,130,246);

  public CustomTextField1() {
    super("");
    setBackground(new Color(241, 245, 249));
    setFont(new Font("Segoe Ui", Font.PLAIN, 16));
    setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
    addFocusListener(new FocusAdapter() {
      @Override
      public void focusGained(FocusEvent e){
        setBorder(BorderFactory.createLineBorder(ACTIVE_BORDER_COLOR));
      }
      @Override
      public void focusLost(FocusEvent e){
        setBorder(BorderFactory.createLineBorder(BORDER_COLOR));
      }
    });
  }
}
