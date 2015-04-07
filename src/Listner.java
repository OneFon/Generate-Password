import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class Listner implements ActionListener {

	public Listner(MyFrame frame) {
		this.frame = frame;
	}

	MyFrame frame;

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (e.getActionCommand()) {
		case "1":
			generation();
			break;
		case "2":
			frame.getout().copy();
			break;
		case "3":
			history();
			MyFrame2 frame2 = new MyFrame2();
			frame2.setVisible(true);
			break;

		}
	}

	private void generation() {
		history();
		boolean little = frame.getlittle().isSelected();
		boolean big = frame.getBig().isSelected();
		boolean number = frame.getnumber().isSelected();

		ArrayList<String> list = new ArrayList<String>();

		if (little == false & big == false & number == false) {
			JOptionPane.showMessageDialog(null, "Укажите параметры пароля",
					"Ошибка", JOptionPane.WARNING_MESSAGE);
		}

		char little_one_char = 'a';
		int little_one_int = (int) little_one_char;
		char little_end_char = 'z';
		int little_end_int = (int) little_end_char;

		if (little == true) {
			for (int i = little_one_int; i <= little_end_int; i++) {
				char n = (char) i;
				list.add(String.valueOf(n));
			}
		}

		char big_one_char = 'A';
		int big_one_int = (int) big_one_char;
		char big_end_char = 'Z';
		int big_end_int = (int) big_end_char;

		if (big == true) {
			for (int i = big_one_int; i <= big_end_int; i++) {
				char n = (char) i;
				list.add(String.valueOf(n));
			}
		}

		char number_one_char = '0';
		int number_one_int = (int) number_one_char;
		char number_end_char = '9';
		int number_end_int = (int) number_end_char;

		if (number == true) {
			for (int i = number_one_int; i <= number_end_int; i++) {
				char n = (char) i;
				list.add(String.valueOf(n));

			}
		}
		try {
			int length = Integer.parseInt(frame.getin().getText());
			StringBuilder password = new StringBuilder();
			Random generator = new Random();
			int k = 0;
			while (k != length) {
				k++;
				String g = list.get(generator.nextInt(list.size()));
				frame.getout().setText((password.append(g)).toString());
			}
		} catch (NumberFormatException length) {
			JOptionPane.showMessageDialog(null, "Укажите длину пароля",
					"Ошибка", JOptionPane.WARNING_MESSAGE);
		} catch (IllegalArgumentException g) {

		}
	}

	private void history() {
		String text = frame.getout().getText();
		String fileName = "C://1.txt";
		try {
			File file = new File(fileName);
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				PrintWriter out = new PrintWriter(file.getAbsoluteFile());
				out.print(text);
				out.close();
			} else
				FileWorker.update(fileName, text);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unused")
	private void delete() {
		String nameFile = "C://1.txt";
		try {
			FileWorker.delete(nameFile);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
