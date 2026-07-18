import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButton1 extends JButton {

  private final Color BUTTON_COLOR= new Color(37, 99, 235);
  private final Color HOVER_COLOR= new Color(29, 78, 216);
  private final Color BUTTON_CLICKED=new Color(30,64,175);

  public CustomButton1() {
    super("Find IP Address");
    setBackground(BUTTON_COLOR);
    setForeground(Color.WHITE);
    setFont(new Font("Segoe Ui", Font.PLAIN, 16));
    addMouseListener(new MouseAdapter() {
      @Override
      public void mouseEntered(MouseEvent e){
        setBackground(HOVER_COLOR);
      }

      @Override
      public void mouseExited(MouseEvent e){
        setBackground(HOVER_COLOR);
      }

      @Override
      public void mouseClicked(MouseEvent e){
        setBackground(BUTTON_CLICKED);
      }
    });
    
  }
}
