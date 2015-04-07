import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;

@SuppressWarnings("serial")
class MyFrame2 extends JFrame {
	public MyFrame2() {

		setSize(FRAME_WIDTH, FRAME_HEIGHT);// Размер формы
		setTitle(NAME_NEW); // Название формы
		setLocationRelativeTo(null); // Окно по центру
		setResizable(false); // Запрет на изменение окна
		ImageIcon icon = new ImageIcon("src/logo.png");
		setIconImage(icon.getImage());
		JPanel panel = new JPanel();
		this.add(panel);

		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;

		try {
			archivo = new File("C://1.txt");
			fr = new FileReader(archivo);
			br = new BufferedReader(fr);
			final Vector<String> lines = new Vector<String>();
			final JList myList = new JList(lines);
			JScrollPane myScrollPane = new JScrollPane(myList);
			myScrollPane.setPreferredSize(new Dimension(270, 400));
			panel.add(myScrollPane);

			Panel p2 = new Panel();
			
			 JButton ButtonCopy = new JButton ("Копировать");
			  p2.add(ButtonCopy); 
			  ButtonCopy.addActionListener(new ActionListener() { 
				  public void actionPerformed(ActionEvent e) {
					  int k = myList.getSelectedIndex();
					  String str = lines.get(k).toString();
					StringSelection ss = new StringSelection(str );
					    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			  }});
			 
			JButton ButtonDel = new JButton("Очистить историю");
			p2.add(ButtonDel);
			ButtonDel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					String nameFile = "C://1.txt";

					try {

						FileWorker.delete(nameFile);

						// Обновляется JList
						ListModel model = myList.getModel();
						DefaultListModel listModel = new DefaultListModel();
						myList.setModel(listModel);
						JOptionPane.showMessageDialog(null,
								"История паролей успешно удалена", "Сообщение",
								JOptionPane.INFORMATION_MESSAGE);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});

			// ButtonDel.setEnabled(false);
			Panel pi = new Panel();
			pi.setLayout(new BorderLayout());
			panel.add(p2, BorderLayout.SOUTH);

			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static final int FRAME_WIDTH = 300;
	public static final int FRAME_HEIGHT = 500;
	public static final String NAME_NEW = "История паролей";
}