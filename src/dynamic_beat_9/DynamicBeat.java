package dynamic_beat_9;

import java.awt.*; // private���� image, graphics�� ���� ��
import java.awt.event.*; // mouse x,y ��ǥ�� ���� ��
import java.util.*;

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
	
	private ImageIcon easyButtonBasicImage = new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonBasicImage = new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon hardButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	private ImageIcon backButtonBasicImage = new ImageIcon(Main.class.getResource("../images/backButtonBasic.png"));
	private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));


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
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	private int mouseX, mouseY; // ���� ���α׷� ���ο��� ���콺�� x,y ��ǥ �� ��ü�� �ǹ��Ѵ�.
	
	private boolean isMainScreen = false; // ó������ ����ȭ���� �ƴ� ����ȭ���̱⿡ false�� ����
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	// ������ ���� ���� ����Ʈ�� �������

	private Image titleImage; // �� ����
	private Image selectedImage; // �� �����
	private Music selectedMusic; // �� ����
	private Music introMusic = new Music("introMusic.mp3", true); // ����ȭ�鿡�� ������ ������ �ݺ�
	private int nowSelected = 0; // ���� trackList���� Array�� ù��° ���� 0�̱� ����

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
		
		introMusic.start();
		
		trackList.add(new Track("Aimer - Stardust Title Image.png","Aimer - Stardust Start Image.png",
				"Aimer - Stardust Game Image.png", "Aimer - Stardust Selected.mp3", "Aimer - Stardust.mp3"));
		trackList.add(new Track("Alan Walker - Faded Title Image.png","Alan Walker - Faded Start Image.png",
				"Alan Walker - Faded Game Image.png", "Alan Walker - Faded Selected.mp3", "Alan Walker - Faded.mp3"));
		trackList.add(new Track("���ǽ�ī��-�ð��� ��, �������� Title Image.png","���ǽ�ī��-�ð��� ��, �������� Start Image.png",
				"���ǽ�ī��-�ð��� ��, �������� Game Image.png", "���ǽ�ī��-�ð��� ��, �������� Selected.mp3", "���ǽ�ī��-�ð��� ��, ��������.mp3"));
		// �Է¼����� Track Ŭ������ publc Track�� ���� / ���ʴ�� ���������� 0��° �ε���, 1��° �ε��� �̷��� �����
		
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
				enterMain();
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
				selectLeft();
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
				selectRight();
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);	
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "Easy");
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 67);	
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "hard");
			}
		});
		add(hardButton);
		
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);	
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { 
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				backMain();
			}
		});
		add(backButton);

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
	public void selectTrack(int nowSelected) { // ���� ���õ� ���� ��ȣ�� �˷������ν� �ش���� ���õȰ��� �˷���
		if(selectedMusic != null) {
			selectedMusic.close(); // ��� ���� ����ǰ��ִٸ� �ٷ� ��������ش�.
		}	titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList
					.get(nowSelected).getTitleImage())).getImage();
			// ���� ���õ� Ʈ��(��)�� ������ �ִ� Ÿ��Ʋ(����) �̹������� �����ͼ� �־��ְڴٴ� �ǹ�
			selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList
					.get(nowSelected).getStartImage())).getImage();
			// ���� ����� �ٲٱ�
			selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
			selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0) {
			nowSelected = trackList.size() - 1;
			// 0��° ���� �� ���ʹ�ư�� ������ ���� �������� ���õǾ���ϹǷ� �̷��� �Ѵ�.
		} else {
			nowSelected--;
		} selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1) {
			// Ʈ���� ���� ���� �����ʿ� �ִ� ���̶��
			nowSelected = 0;
		} else {
			nowSelected++;			
		} selectTrack(nowSelected);
	}
	public void gameStart(int nowSelected, String difficulty) { // ���缱�õȰ� ���̵��� ���� ����
		if(selectedMusic != null) { // � ���� �������̶��
			selectedMusic.close(); // ���� ����� ������ ����ǵ��� �����Ѵ�.
		} isMainScreen = false; // ����ȭ���� �ƴ϶�� ���� ������ �˷���
		// ���� screenDraw�� if���� ��������ʴ´�.
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/" + trackList.get(nowSelected).getGameImage()))
				.getImage();
		backButton.setVisible(true);
	}
	public void backMain() {
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground2.jpg"))
				.getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected); // �ٽ� ������ �´� ���� ������Ѷ�
	
	}
	public void enterMain() {
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon(Main.class.getResource("../images/mainBackground2.jpg"))
				.getImage();
		isMainScreen = true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrack(0); // �� ó������ 0��° ���� ���õǱ� ����
	}
}
