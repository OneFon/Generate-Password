import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JEditorPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class About extends JFrame {
	public About() {
		setVisible(true);
		setSize(400, 200);// Размер формы
		setTitle("О программе"); // Название формы
		setLocationRelativeTo(null); // Окно по центру
		setResizable(false); // Запрет на изменение окна
		ImageIcon icon = new ImageIcon("src/logo.png");
		setIconImage(icon.getImage());

		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.setLayout(null);
		final JLabel gen = new JLabel("Генератор паролей v 1.0");
		gen.setLocation(125, 10);
		gen.setSize(150, 20);
		//gen.setFont(new Font("Serif", Font.PLAIN, 20));
		panel.add(gen);

		final JLabel ra = new JLabel("Разработчик:");
		ra.setLocation(50, 50);
		ra.setSize(100, 20);
		panel.add(ra);

		final JLabel aa = new JLabel("Startone.at.ua");
		aa.setLocation(150, 50);
		aa.setSize(85, 20);
		panel.add(aa);
		aa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
					
		aa.addMouseListener(new MouseAdapter() {
			   public void mouseClicked(MouseEvent e) {
			      if (e.getClickCount() > 0) {
			          if (Desktop.isDesktopSupported()) {
			                Desktop desktop = Desktop.getDesktop();
			                try {
			                    URI uri = new URI("http://www.startone.at.ua");
			                    desktop.browse(uri);
			                } catch (IOException ex) {
			                    ex.printStackTrace();
			                } catch (URISyntaxException ex) {
			                    ex.printStackTrace();
			                }
			        }
			      }
			      }
			   public void mouseEntered (MouseEvent e){
				   aa.setForeground(Color.BLUE);
			   }
			   public void mouseExited (MouseEvent e){
				   aa.setForeground(Color.BLACK);
			   }
			   
		});
	
		final JLabel ra1 = new JLabel("Контакты:");
		ra1.setLocation(50, 80);
		ra1.setSize(100, 20);
		panel.add(ra1);

		final JLabel aa1 = new JLabel("Startone@at.ua");
		aa1.setLocation(150, 80);
		aa1.setSize(250, 20);
		panel.add(aa1);

		final JLabel mail = new JLabel("Copyright © 2014");
		mail.setLocation(270, 140);
		mail.setSize(250, 20);
		panel.add(mail);

	}
}
