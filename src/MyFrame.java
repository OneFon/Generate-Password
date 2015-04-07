import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

@SuppressWarnings("serial")
class MyFrame extends JFrame {

	private final JCheckBox ckeckBox_big;
	private final JCheckBox ckeckBox_little;
	private final JCheckBox ckeckBox_number;
	private final JTextField text_out;
	private final JTextField text_in;

	public JCheckBox getBig() {
		return ckeckBox_big;
	}

	public JCheckBox getlittle() {
		return ckeckBox_little;
	}

	public JCheckBox getnumber() {
		return ckeckBox_number;
	}

	public JTextField getout() {
		return text_out;
	}

	public JTextField getin() {
		return text_in;
	}

	public MyFrame() {
		setSize(FRAME_WIDTH, FRAME_HEIGHT);// ������ �����
		setTitle(NAME_NEW); // �������� �����
		setLocationRelativeTo(null); // ���� �� ������
		setResizable(false); // ������ �� ��������� ����

		JPanel panel = new JPanel();
		panel.setLayout(null); // ���������� ����� (������ �� ���������� ��
							   // ��������� �����������)
		this.add(panel);

		ckeckBox_big = new JCheckBox("������� �����");
		ckeckBox_big.setLocation(40, 10);
		ckeckBox_big.setSize(150, 50);
		panel.add(ckeckBox_big);
		// panel.add(new JCheckBox("Align on baseline"));

		ckeckBox_little = new JCheckBox("��������� �����");
		ckeckBox_little.setLocation(40, 50);
		ckeckBox_little.setSize(150, 50);
		panel.add(ckeckBox_little);

		ckeckBox_number = new JCheckBox("�����");
		ckeckBox_number.setLocation(40, 90);
		ckeckBox_number.setSize(150, 50);
		panel.add(ckeckBox_number);

		final JLabel label_in = new JLabel("����� ������");
		label_in.setLocation(250, 23);
		label_in.setSize(150, 20);
		panel.add(label_in);

		text_in = new JTextField();
		text_in.setLocation(250, 45);
		text_in.setSize(50, 20);
		panel.add(text_in);

		text_in.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent e) {
				char a = e.getKeyChar();
				if (!Character.isDigit(a) && (a != '.') && (a != '\b')) {
					e.consume();
				}
			}
		});

		final JLabel label_out = new JLabel("������");
		label_out.setLocation(250, 70);
		label_out.setSize(150, 50);
		panel.add(label_out);

		text_out = new JTextField();
		text_out.setLocation(250, 110);
		text_out.setSize(200, 20);
		text_out.setEditable(false);
		text_out.setBackground(Color.white);
		panel.add(text_out);
		// panel.add(new JTextField("Some text field", 10));

		JPopupMenu popup = new JPopupMenu();
		text_out.add(popup);
		text_out.setComponentPopupMenu(popup);

		JMenuItem mItem = new JMenuItem("����������");
		mItem.setActionCommand("2");
		Listner listner = new Listner(this);
		mItem.addActionListener(listner);
		popup.add(mItem);

		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		JMenu gile = new JMenu("����");

		// JMenuItem mItem1 = new JMenuItem("����������");
		JMenuItem mItem2 = new JMenuItem("�������� �������");
		mItem2.setActionCommand("DeleteH");
		mItem2.addActionListener(new Menu());

		/*
		 * JMenuItem mItem3 = new JMenuItem("������ ��������� ������");
		 * mItem3.setActionCommand("Delete"); mItem3.addActionListener(new
		 * Menu());
		 */

		JMenuItem mItem4 = new JMenuItem("� ���������");
		mItem4.setActionCommand("About");
		mItem4.addActionListener(new Menu());

		// gile.add(mItem1);
		gile.add(mItem2);
		// gile.add(mItem3);
		gile.add(mItem4);
		bar.add(gile);

		final JButton gButton = new JButton("������� ������"); // ��������
																// ������
		gButton.setLocation(70, 200); // ���������� ������
		gButton.setSize(150, 30); // ������ ������
		panel.add(gButton);

		gButton.setActionCommand("1");
		gButton.addActionListener(listner);

		final JButton gButton2 = new JButton("�������");
		gButton2.setLocation(270, 200);
		gButton2.setSize(150, 30);
		panel.add(gButton2);

		gButton2.setActionCommand("3");
		gButton2.addActionListener(listner);

	}

	public static final int FRAME_WIDTH = 500;
	public static final int FRAME_HEIGHT = 300;
	public static final String NAME_NEW = "��������� ������� v 1.0";
}
