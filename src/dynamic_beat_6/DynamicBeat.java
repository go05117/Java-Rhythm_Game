package dynamic_beat_6;

import java.awt.*; // private���� image, graphics�� ���� ��
import java.awt.event.*; // mouse x,y ��ǥ�� ���� ��

import javax.swing.*; // ctrl + shift + O�� ������ �ʿ��� �̷��͵��� �߰�������.

public class DynamicBeat extends JFrame {
	// �׷��� ����� �ޱ����� ����ϴ°�(1�� 11��)

	private Image screenImage;
	private Graphics screenGraphic; // �� 2���� ���� ���۸��� ���� �͵�
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	
	private ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	
	private ImageIcon leftButtonBasicImage = new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonBasicImage = new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon rightButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));

	private Image titleImage = new ImageIcon(Main.class.getResource("../images/Aimer - Stardust Title Image.png"))
			.getImage();
	private Image selectedImage = new ImageIcon(Main.class.getResource("../images/Aimer - Stardust Start Image.png"))
			.getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackground(title2).jpg"))
			.getImage();
	/* main Ŭ���� ��ġ�� ������� imtrobackground.jpg�� getresource(���� ����) �� �̹��� �ν��Ͻ���
	 * background�� �ʱ�ȭ ��Ų��.	 */
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	
	private int mouseX, mouseY; // ���� ���α׷� ���ο��� ���콺�� x,y ��ǥ �� ��ü�� �ǹ��Ѵ�.
	
	private boolean isMainScreen = false; // ó������ ����ȭ���� �ƴ� ����ȭ���̱⿡ false�� ����

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
		
		startButton.setBounds(40, 200, 400, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				startButton.setVisible(false);
				quitButton.setVisible(false);
				leftButton.setVisible(true);
				rightButton.setVisible(true);
				background = new ImageIcon(Main.class.getResource("../images/mainBackground2.jpg"))
						.getImage();
				isMainScreen = true;
			}
		});
		add(startButton);
		
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				// ���� �ۼ��� ���ʹ�ư �̺�Ʈ
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);	
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				// ���� �ۼ��� �����ʹ�ư �̺�Ʈ
			}
		});
		add(rightButton);

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
		g.drawImage(background, 0, 0, null); // introbackground�� 0,0�� ��ġ�� �׷��ش�.
		if (isMainScreen) { // ȭ���� ����ȭ���� �� �����ִ� �׸�
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g);
		/* �̹����� �ܼ��ϰ� �ش� screenImage��� ���� �ȿ� �׷��ִ� �� �ܿ� Jlabel�� menubaró��
		 * ���� �߰����ִ°��� �ǹ� / drawImage�� paintcomponents �� �� ����� ���� �ٸ�
		 * drawImage�� ���ó�� �ܼ��� �̹����� ���϶� ���, �ܼ��ϰ� �ѵ��� �׷��ִ� �Լ�
		   g.drawImage���� �ܼ��� ȭ�鿡 �׷��� ����(�Ϲ����� �̹��� �Ǵ� �����̴� �̹����� ǥ���� �� ���)
		 * paintcomponents�� �ϳ��� ��ư�̳� �޴���ó�� ���������� �ʰ� �׻� �װ��� ������ �� ��� ex) JLabel
		       ���� �����ӿ� �߰��� ��Ҹ� �����ִ� ��. ex) ���� add(00000)�� paintcomponents�� �׷�����	 */
		this.repaint(); // paint�� GUI�� ����� ���ӿ��� ���� ù��°�� ȭ���� �׷��ִ� �Լ�(�޼ҵ�)
		/* �� ��üȭ���� �� �������� paint�� �ٽ� �ҷ����鼭 ��� �ݺ���Ű�� �� �ѹ��� ������ �ϸ� ���۸��� ���ϰ�
		       �ɸ��Ƿ� ���� ���۸��� ����Ѵ�.		 */
	}

}
