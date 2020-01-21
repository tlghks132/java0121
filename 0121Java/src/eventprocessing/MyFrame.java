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
	// 스레드 변수
	Thread th;

	public MyFrame() {
		/*
		//2개 이상의 버튼을 배치해서 confirm을 받는 메소드
		int result = JOptionPane.showConfirmDialog(this,"정말로 삭제", "삭제",
				JOptionPane.YES_NO_CANCEL_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			
		}else if(result == JOptionPane.NO_OPTION) {
			
		}else if(result == JOptionPane.CANCEL_OPTION){
			
		}
		*/
		
		//한 줄의 텍스트를 입력받는 대화상자를 출력
		//입력한 내용이 없는 상태에서 확인을 누르면 ""
		JOptionPane.showInputDialog(this, "이름을 입력하세요", "");
		
	
		
		JPanel p = new JPanel();
		// JLabel lbl = new JLabel("이미지");
		// 이미지를 가지고 아이콘을 생성
		// 이미지 파일 크기 그대로 생성된다.
		icon = new ImageIcon("C:\\Users\\tlghk\\Documents\\image\\0.png");
		lbl = new JLabel(icon);
		p.add(lbl);

		// 버튼을 만들어서 패널에 추가
		btn = new JButton("시작");
		p.add(btn);

		// 버튼을 누를 때 이벤트 처리를 위한 인스턴스를 생성
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				switch (arg0.getActionCommand()) {
				case "시작":
					btn.setLabel("중지");
					// 스레드를 생성해서 시작
					th = new Thread() {
						String [] images = {"zoro.png", "one.png", "배경03.png"};
						public void run() {
							try {
								int i = 0;
								while (true) {
									// 0.1초 마다 대기
									Thread.sleep(100);
									// 아이콘 생성
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
				case "중지":
					btn.setText("시작");
					// 스레드 중지
					th.interrupt();
					break;

				}

			}
		};
		
		btn.addActionListener(listener);

		//테이블에 출력 할 컬럼이름 배열
		String [] columnNames = {"이름", "전화번호", "주소"};
		String [][] data = {{"박시환", "01075018514","인천광역시 계양구"},
				{"김수수","01012345678","군포시"}};
		
		//데이터를 가지고 테이블 모델을 생성
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		
		//테이블 모델을 가지고 테이블  생성
		JTable table = new JTable(model);
		
		//테이블은 데이터가 무한정 늘어날수 있어서 상위 컨테이너의 크기를 넘어 설 수 있다.
		//바로 패널이나 프레임에 배치하지 말고 JScrollpane에 배치한 후 배치하는것을 권장
		JScrollPane sp = new JScrollPane(table);
		p.add(sp);
		
		add(p);
		
		//메뉴바 -> 메뉴 -> 메뉴아이템
		JMenuBar bar = new JMenuBar();
		JMenu menu = new JMenu("메뉴(T)");
		
		
		//ALT + T를 별도로 단축키로 설정을 하면 단축키는 동작하지 않는다.
		//단축키 설정
		menu.setMnemonic('t');
		
		//메뉴 항목 만들기
		JMenuItem item = new JMenuItem("메세지 출력");
		//메뉴 아이템의 이벤트 처리는 버튼과 같다. ActionListener 이용
		//Anonymous Class 안에서 this는 자기 자신 이다.
		ActionListener itemListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//내부 클래스에서 외부 클래스의 인스턴스를 호출할 떄는
				//외부클래스이름.this 으로 해야한다.
				//안드로이드에서는 이벤트 처리를 많이 하고 메모리 절약을 위해서 anonymous를 많이 사용하기 때문에
				//외부 클래스의 인스턴스를 호출해야 하는 상황이 많아서
				//이 문법을 기억해야 한다.
				JOptionPane.showMessageDialog(MyFrame.this, "메뉴를 누름");
				
			}
			
		};
		item.addActionListener(itemListener);
		item.setToolTipText("안녕하세요");
		
		menu.add(item);
		bar.add(menu);
		this.setJMenuBar(bar);


		setTitle("이미지");
		setLocation(100, 100);
		setSize(1200, 1300);
		setVisible(true);
		// 종료 기능 부여
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		

	}
}
