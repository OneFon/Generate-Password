import java.awt.event.*;
import java.io.FileNotFoundException;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Menu implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		if ("About".equals(e.getActionCommand())) {
			new About();
		}
		if ("DeleteH".equals(e.getActionCommand())) {
			String nameFile = "C://1.txt";
			Vector<String> lines = new Vector<String>();
			JList myList = new JList(lines);
			try {
				FileWorker.delete(nameFile);
				myList.getModel();
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

	}

}