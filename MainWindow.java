import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.net.InetAddress;

import javax.swing.*;
import panel4.CustomTextArea1;

public class MainWindow extends JFrame {

  String url, result;
  private CustomButton1 button1;
  private CustomLabel1 label2;
  private CustomTextField1 textField3;
  private CustomPanel1 panel4;
  private CustomTextArea1 textArea5;
  private JLabel spinnerLabel;
  private Timer spinnerTimer;
  private int spinnerIndex = 0;

  private void onClick(ActionEvent evt) {
    url = textField3.getText().trim();
    if (url.isEmpty()) {
      JOptionPane.showMessageDialog(this, "Please enter a hostname or IP address.");
      return;
    }

    button1.setEnabled(false);
    textArea5.setText("");
    spinnerIndex = 0;
    spinnerLabel.setVisible(true);
    spinnerTimer.start();

    SwingWorker<String, Void> worker = new SwingWorker<>() {
      @Override
      protected String doInBackground() throws Exception {
        InetAddress address = InetAddress.getByName(url);
        return "--- IP Finder Results ---\n" +
            "Host Name       : " + address.getHostName() + "\n" +
            "Canonical Name  : " + address.getCanonicalHostName() + "\n" +
            "IP Address      : " + address.getHostAddress() + "\n" +
            "Is IPv6         : " + (address instanceof java.net.Inet6Address);
      }

      @Override
      protected void done() {
        try {
          result = get();
          textArea5.setText(result);
          textField3.setText("");
        } catch (Exception e) {
          JOptionPane.showMessageDialog(MainWindow.this, e.getMessage());
        } finally {
          spinnerTimer.stop();
          spinnerLabel.setVisible(false);
          button1.setEnabled(true);
        }
      }
    };

    worker.execute();
  }

  public MainWindow() {

    setTitle("IP Finder");
    setSize(700, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);
    setBackground(Color.WHITE);

    Image icon = Toolkit.getDefaultToolkit().getImage("./icon.png");
    setIconImage(icon);

    button1 = new CustomButton1();
    button1.setBounds(490, 103, 152, 36);
    this.add(button1);
    button1.addActionListener(e -> onClick(e));

    label2 = new CustomLabel1();
    label2.setBounds(283, 24, 240, 52);
    this.add(label2);

    textField3 = new CustomTextField1();
    textField3.setBounds(57, 101, 407, 36);
    this.add(textField3);

    panel4 = new CustomPanel1();
    panel4.setBounds(58, 180, 583, 223);
    panel4.setLayout(null);
    this.add(panel4);

    textArea5 = new CustomTextArea1();
    textArea5.setBounds(29, 36, 540, 154);
    panel4.add(textArea5);

    spinnerLabel = new JLabel("Loading");
    spinnerLabel.setFont(new java.awt.Font("Segoe UI",Font.ITALIC, 18));
    spinnerLabel.setBounds(58, 420, 583, 24);
    spinnerLabel.setVisible(false);

    this.add(spinnerLabel);

    spinnerTimer = new Timer(120, e -> {
      String[] frames = {".", "..", "...", "...."};
      spinnerLabel.setText("Loading " + frames[spinnerIndex % frames.length]);
      spinnerIndex++;
    });

    setLocationRelativeTo(null);

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      MainWindow frame = new MainWindow();
      frame.setVisible(true);
    });
  }
}
