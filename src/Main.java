import java.io.FileNotFoundException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		MyFrame frame = new MyFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		ImageIcon icon = new ImageIcon("src/logo.png");
		frame.setIconImage(icon.getImage());
	}
}
