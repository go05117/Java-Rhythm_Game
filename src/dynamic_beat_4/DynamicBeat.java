package dynamic_beat_4;

import java.awt.*; // private���� image, graphics�� ���� ��
import java.awt.event.*; // mouse x,y ��ǥ�� ���� ��

import javax.swing.*; // ctrl + shift + O�� ������ �ʿ��� �̷��͵��� �߰�������.

public class DynamicBeat extends JFrame {
	// �׷��� ����� �ޱ����� ����ϴ°�(1�� 11��)

	private Image screenImage;
	private Graphics screenGraphic; // �� 2���� ���� ���۸��� ���� �͵�
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introbackground(title).jpg"))
			.getImage();
	/* main Ŭ���� ��ġ�� ������� imtrobackground.jpg�� getresource(���� ����) �� �̹��� �ν��Ͻ���
	 * introBackground�� �ʱ�ȭ ��Ų��.	 */
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private int mouseX, mouseY; // ���� ���α׷� ���ο��� ���콺�� x,y ��ǥ �� ��ü�� �ǹ��Ѵ�.

	public DynamicBeat() {
		// �����ڴ� �ڽ��� Ŭ������ ���� �̸��� ������ ����
		setUndecorated(true); // �������� �� �⺻���� �޴��ٰ� ������ �ʴ´�.
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // �ѹ� ������� ����â�� ����ڰ� ���Ƿ� ���̰ų� �ø�������.
		setLocationRelativeTo(null); // �������� �� â�� ��ǻ�� ���߾ӿ� ���.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����â�� ���������� ���α׷� ��ü�� ����(�̰� �ȳ־��ָ� â ���� ���α׷��� ��� ���ư�)
		setVisible(true); // �츮�� ���� â�� ȭ�鿡 �������� ��µǵ��� �ϴ°�
		setBackground(new Color(0, 0, 0, 0)); // paintcomponents ����� �Ͼ���� ��
		setLayout(null); // ��ư�̳� JLabel ���� ���� �־����� �� ��ġ�� ����� ����
		
		/* ó���� �޴��ٸ���� ���� �־����� �޴��ٰ� ��ư�� ��������� �ٶ��� �ݱ� ��ư�� �۵��� �ȉ��.
		 * �̷� ���� ������ ���Ʒ� �ٲ㼭 �����Ű�� �ȴ�.		 */
		
		exitButton.setBounds(1245, 0, 30, 30);
		// ctrl + shift + f�� ������ �ڵ����� �ڵ� ���� �� ���� ������ ���ش�.
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		// �⺻���� JButton�� ���� ����� ���ǵǾ��ֱ⿡ ���� 3���� �߰��Ͽ� �츮�� ���� ��ư�� ���̰� �Ѵ�.
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // ���콺�� �ش��ư ���� �ö�������� �̺�Ʈó��
				exitButton.setIcon(exitButtonEnteredImage); // �̹����� �ٲ��ش�.
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// ���콺�� �ö��� �� �ո������ �ٲ��.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // ���콺�� ���������� �̺�Ʈ ó��
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				// ���콺�� �������� �ٽ� ���� ���콺 ������� �ٲ۴�.
			}
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� Ŭ���������� �̺�Ʈ ó��
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				// ��������� ���� ����ʰ� ���ÿ� ������ �鸮�� �����̶� �ƿ� �ȵ鸲(���ᰡ �Բ��Ǳ� ����)
				try {
					Thread.sleep(1000); // �Ҹ��� ���� �� 1�ʵ� ���α׷� ������ ��
				} catch (InterruptedException ex) {
					ex.printStackTrace(); // �����޼����� �߻��ٿ����� ã�� �ܰ躰�� ���� ���
				}
				System.exit(0); // Ŭ���������� ���α׷��� ����ȴ�.
			}
		});
		add(exitButton);

		menubar.setBounds(0, 0, 1280, 30); // setBounds�� ��ġ�� ũ�⸦ �����ش�.
		// ���ʺ��� x��ǥ, y��ǥ, ���γ���, ���γ����̴�.
		menubar.addMouseListener(new MouseAdapter() { 
			@Override
			public void mousePressed(MouseEvent e) { // ���콺�� �ش��ư�� ������ ���� �̺�Ʈ ó��
				mouseX = e.getX();
				mouseY = e.getY(); // ������ �̺�Ʈ�� �߻��������� �� x,y ��ǥ�� ���´�.
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) { // �巡�� �̺�Ʈ�� �߻����� ���� ó��
				int x = e.getXOnScreen();
				int y = e.getYOnScreen(); // ������ â �������� x,y ��ǥ
				setLocation(x - mouseX, y - mouseY);
			/* �巡���Ҷ� �� �������� x,y ��ǥ�� ���ͼ� �ڵ����� ���� jframe �� ����â�� ��ġ�� �ٲ��ش�.
			 * �� ����� �޴��ٸ� ��򰡷� �巡�������� �׷� �̺�Ʈ ó���� ���ش�. */
			}
		});
		add(menubar); // Jframe�� �޴��ٰ� �߰��ȴ�.

		Music introMusic = new Music("introMusic.mp3", true); // ����ȭ�鿡�� ������ ������ �ݺ�
		introMusic.start();

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 1280*720�� �̹����� ����� �� �� �װ� screenImage�� �־��ְڴ�.
		screenGraphic = screenImage.getGraphics(); // screenImage�� �̿��Ͽ� �׷��� ��ü ������
		screenDraw(screenGraphic); // screenGraphic�� ��� �׸��� �׷��ֳ� ����°� �Ʒ��� ����
		g.drawImage(screenImage, 0, 0, null); // ����â�� screenImage�� �׷���
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // introbackground�� 0,0�� ��ġ�� �׷��ش�.
		paintComponents(g);
		/*
		 * �̹����� �ܼ��ϰ� �ش� screenImage��� ���� �ȿ� �׷��ִ� �� �ܿ� Jlabel�� menubaró�� ���� �߰����ִ°��� �ǹ� .
		 * drawImage�� paintcomponents �� �� ����� ���� �ٸ� drawImage�� ���ó�� �ܼ��� �̹����� ���϶� ���,
		 * �ܼ��ϰ� �ѵ��� �׷��ִ� �Լ� paintcomponents�� �ϳ��� ��ư�̳� �޴���ó�� ���������� �ʰ� �׻� �װ��� ������ �� ��� ex)
		 * JLabel
		 */
		this.repaint(); // paint�� GUI�� ����� ���ӿ��� ���� ù��°�� ȭ���� �׷��ִ� �Լ�(�޼ҵ�)
		/*
		 * �� ��üȭ���� �� �������� paint�� �ٽ� �ҷ����鼭 ��� �ݺ���Ű�� �� �ѹ��� ������ �ϸ� ���۸��� ���ϰ� �ɸ��Ƿ� ���� ���۸���
		 * ����Ѵ�.
		 */
	}

}
