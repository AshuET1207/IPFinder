import javax.swing.*;
import java.awt.*;

public class CustomLabel1 extends JLabel {

  Image icon=new ImageIcon("./icon.png").getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);

  public CustomLabel1() {
    super("IP Finder");
    ImageIcon imageIcon=new ImageIcon(icon);
    setIcon(imageIcon);
    setBackground(new Color(255, 255, 255));
    setFont(new Font("Segoe Ui", Font.BOLD, 28));
    setForeground(new Color(30,41,59));
  }
}
