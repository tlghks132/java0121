package eventprocessing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame {
	JLabel lbl;
	ImageIcon icon;
	JButton btn;
	// ������ ����
	Thread th;

	public MyFrame() {
		/*
		//2�� �̻��� ��ư�� ��ġ�ؼ� confirm�� �޴� �޼ҵ�
		int result = JOptionPane.showConfirmDialog(this,"������ ����", "����",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			
		}else if(result == JOptionPane.NO_OPTION) {
			
		}else if(result == JOptionPane.CANCEL_OPTION){
			
		}
		*/
		
		//�� ���� �ؽ�Ʈ�� �Է¹޴� ��ȭ���ڸ� ���
		//�Է��� ������ ���� ���¿��� Ȯ���� ������ ""
		JOptionPane.showInputDialog(this, "�̸��� �Է��ϼ���", "");
		
	
		
		JPanel p = new JPanel();
		// JLabel lbl = new JLabel("�̹���");
		// �̹����� ������ �������� ����
		// �̹��� ���� ũ�� �״�� �����ȴ�.
		icon = new ImageIcon("C:\\Users\\tlghk\\Documents\\image\\0.png");
		lbl = new JLabel(icon);
		p.add(lbl);

		// ��ư�� ���� �гο� �߰�
		btn = new JButton("����");
		p.add(btn);

		// ��ư�� ���� �� �̺�Ʈ ó���� ���� �ν��Ͻ��� ����
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				switch (arg0.getActionCommand()) {
				case "����":
					btn.setLabel("����");
					// �����带 �����ؼ� ����
					th = new Thread() {
						String [] images = {"zoro.png", "one.png", "���03.png"};
						public void run() {
							try {
								int i = 0;
								while (true) {
									// 0.1�� ���� ���
									Thread.sleep(100);
									// ������ ����
									icon = new ImageIcon("C:\\Users\\tlghk\\Documents\\image\\" +
									images[i%images.length]);
									lbl.setIcon(icon);

									i = i + 1;
								}

							} catch (InterruptedException e) {
								return;
							}
						}

					};
					th.start();
					break;
				case "����":
					btn.setText("����");
					// ������ ����
					th.interrupt();
					break;

				}

			}
		};
		
		btn.addActionListener(listener);

		//���̺� ��� �� �÷��̸� �迭
		String [] columnNames = {"�̸�", "��ȭ��ȣ", "�ּ�"};
		String [][] data = {{"�ڽ�ȯ", "01075018514","��õ������ ��籸"},
				{"�����","01012345678","������"}};
		
		//�����͸� ������ ���̺� ���� ����
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		//���̺� ���� ������ ���̺�  ����
		JTable table = new JTable(model);
		
		//���̺��� �����Ͱ� ������ �þ�� �־ ���� �����̳��� ũ�⸦ �Ѿ� �� �� �ִ�.
		//�ٷ� �г��̳� �����ӿ� ��ġ���� ���� JScrollpane�� ��ġ�� �� ��ġ�ϴ°��� ����
		JScrollPane sp = new JScrollPane(table);
		p.add(sp);
		
		add(p);
		
		//�޴��� -> �޴� -> �޴�������
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("�޴�(T)");
		
		
		//ALT + T�� ������ ����Ű�� ������ �ϸ� ����Ű�� �������� �ʴ´�.
		//����Ű ����
		menu.setMnemonic('t');
		
		//�޴� �׸� �����
		JMenuItem item = new JMenuItem("�޼��� ���");
		//�޴� �������� �̺�Ʈ ó���� ��ư�� ����. ActionListener �̿�
		//Anonymous Class �ȿ��� this�� �ڱ� �ڽ� �̴�.
		ActionListener itemListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//���� Ŭ�������� �ܺ� Ŭ������ �ν��Ͻ��� ȣ���� ����
				//�ܺ�Ŭ�����̸�.this ���� �ؾ��Ѵ�.
				//�ȵ���̵忡���� �̺�Ʈ ó���� ���� �ϰ� �޸� ������ ���ؼ� anonymous�� ���� ����ϱ� ������
				//�ܺ� Ŭ������ �ν��Ͻ��� ȣ���ؾ� �ϴ� ��Ȳ�� ���Ƽ�
				//�� ������ ����ؾ� �Ѵ�.
				JOptionPane.showMessageDialog(MyFrame.this, "�޴��� ����");
				
			}
			
		};
		item.addActionListener(itemListener);
		item.setToolTipText("�ȳ��ϼ���");
		
		menu.add(item);
		bar.add(menu);
		this.setJMenuBar(bar);


		setTitle("�̹���");
		setLocation(100, 100);
		setSize(1200, 1300);
		setVisible(true);
		// ���� ��� �ο�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}
}
