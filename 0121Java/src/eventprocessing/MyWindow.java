package eventprocessing;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;


public class MyWindow extends Frame {
	private Button btn;
	private TextField tf;
	
	private Button btn1 ,btn2;
	//private Button [] buttons = new Button[2];  //�迭�� �߰�
	
	public MyWindow() {	
		//���� ���� ������Ʈ�� ������ Container ����
		Panel p = new Panel();
		
		//������Ʈ���� ����
		btn = new Button("����");
		tf = new TextField(20);
		
		//��ư�� �̺�Ʈ ó���� ���� ActionListener �������̽��� Anonymous class ����
		ActionListener listener =
				new ActionListener() {  //Listener: �ڹٿ��� ȣ��Ǵ� �̺�Ʈ ó�� �Ǵ� �������̽� (��κ� �������̽�)
					//��ư�� �����ų� �ؽ�Ʈ �ʵ忡�� Return �����ų� �޴��� ������ ȣ���ϴ� �޼ҵ�
					@Override
					public void actionPerformed(ActionEvent arg0) {
						//�Է��� ���� ��������
						String msg = tf.getText();
						//���
						System.out.println(msg);
						
					}
		};

		//btn���� Action �̺�Ʈ�� �߻��ϸ� listener�� ��� ó���ϵ��� ����(Delegation)
		//btn.addActionListener(listener);
			
		//�̺�Ʈ ó���� ���� �ν��Ͻ� ����
		EventHandler handler = new EventHandler(tf);
		btn.addActionListener(handler);
		
					
		//������Ʈ���� �����̳ʿ� ��ġ
		p.add(tf);
		
		
		//��ư�� �����ؼ� �гο� �߰�
		btn1 = new Button("��ư1");	
		p.add(btn1);
		
		btn2 = new Button("��ư2");	
		p.add(btn2);
		
		/*
		
		//��ư�� �̺�Ʈ ó�� - ������� �̿����� �ʴ� ���
		ActionListener even1 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("��ư1�� Ŭ���߽��ϴ�.");
						
			}
		};
		btn1.addActionListener(event1);
		
		ActionListener even2 = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("��ư2�� Ŭ���߽��ϴ�.");
			}
		};
		*/
		
		//�̺�Ʈ ������� �̿��ϴ� ���
		ActionListener eventRouting =
				new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					switch(e.getActionCommand()) {
					case "��ư1":
						System.out.println("��ư1 Ŭ��");
						break;						
					case "��ư2":
						System.out.println("��ư2 Ŭ��");
						break;
					}
						
				}
		};
		
		btn1.addActionListener(eventRouting);
		btn2.addActionListener(eventRouting);
		
		//�ؽ�Ʈ �ʵ峪 �ؽ�Ʈ ������� ���ڿ��� ����� �� ó���� ���� �ν��Ͻ�
		TextListener tl = new TextListener() {

			@Override
			public void textValueChanged(TextEvent arg0) {
				//�ؽ�Ʈ �ʵ忡 �Էµ� ���ڿ� ��������
				String msg = tf.getText();
				//��ҹ��� ����, Ư������ ������ ������ ������ ����
				int dae = 0;
				int si = 0;
				int su = 0;
				int ect = 0;
				
				//���ڿ��� ���ڴ����� ����
				for(int i=0; i<msg.length(); i=i+1) {
					//�տ������� �ѱ��ھ� ��������
					char ch = msg.charAt(i);
					if(ch >='A' && ch <= 'Z') {
						dae = dae +1;
					}else if(ch >= 'a' && ch  <='z') {
						si = si+1;
					}else if(ch >= '0' && ch <= '9') {
						su = su +1;
					}else {
						ect = ect+ 1;
					}
					
				}
				if(dae*si*su*ect !=0) {
					System.out.println("����");
				}else {
					System.out.println("����");
				}
				
			}
			
		};
		tf.addTextListener(tl);
		
			
		//�����̳ʸ� �����쿡 ��ġ
		add(p);
		
		
		//Frame �⺻ ����
		setTitle("�̺�Ʈ ó��");
		setLocation(100, 100);
		setSize(200, 200);
		setVisible(true);		
	}
}
