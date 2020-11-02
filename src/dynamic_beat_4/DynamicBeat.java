package dynamic_beat_4;

import java.awt.*; // private문의 image, graphics를 위한 문
import java.awt.event.*; // mouse x,y 좌표를 위한 문

import javax.swing.*; // ctrl + shift + O를 누르면 필요한 이런것들을 추가시켜줌.

public class DynamicBeat extends JFrame {
	// 그래픽 기반을 받기위해 사용하는것(1강 11분)

	private Image screenImage;
	private Graphics screenGraphic; // 이 2개는 더블 버퍼링을 위한 것들
	
	private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));

	private Image introBackground = new ImageIcon(Main.class.getResource("../images/introbackground(title).jpg"))
			.getImage();
	/* main 클래스 위치를 기반으로 imtrobackground.jpg를 getresource(얻어온 다음) 그 이미지 인스턴스를
	 * introBackground에 초기화 시킨다.	 */
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	
	private int mouseX, mouseY; // 현재 프로그램 내부에서 마우스의 x,y 좌표 그 자체를 의미한다.

	public DynamicBeat() {
		// 생성자는 자신의 클래스와 같은 이름을 가지고 있음
		setUndecorated(true); // 실행했을 때 기본적인 메뉴바가 보이지 않는다.
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 한번 만들어진 게임창은 사용자가 임의로 줄이거나 늘릴수없다.
		setLocationRelativeTo(null); // 실행했을 때 창이 컴퓨터 정중앙에 뜬다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 게임창을 종료했을때 프로그램 전체가 종료(이거 안넣어주면 창 꺼도 프로그램이 계속 돌아감)
		setVisible(true); // 우리가 만든 창이 화면에 정상적을 출력되도록 하는것
		setBackground(new Color(0, 0, 0, 0)); // paintcomponents 배경이 하얀색이 됨
		setLayout(null); // 버튼이나 JLabel 같은 것을 넣었을때 그 위치가 제대로 나옴
		
		/* 처음엔 메뉴바만든게 위에 있었으나 메뉴바가 버튼을 덮어버리는 바람에 닫기 버튼이 작동이 안됬다.
		 * 이럴 떄는 순서를 위아래 바꿔서 적용시키면 된다.		 */
		
		exitButton.setBounds(1245, 0, 30, 30);
		// ctrl + shift + f를 누르면 자동으로 코드 띄어쓰기 및 문단 정렬을 해준다.
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		// 기본적인 JButton은 따로 모양이 정의되어있기에 위의 3줄을 추가하여 우리가 만든 버튼만 보이게 한다.
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) { // 마우스가 해당버튼 위에 올라왔을때의 이벤트처리
				exitButton.setIcon(exitButtonEnteredImage); // 이미지를 바꿔준다.
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				// 마우스가 올라갔을 때 손모양으로 바뀐다.
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) { // 마우스가 나왔을때의 이벤트 처리
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				// 마우스가 내려가면 다시 원래 마우스 모양으로 바꾼다.
			}
			@Override
			public void mousePressed(MouseEvent e) { // 마우스를 클릭했을때의 이벤트 처리
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				// 여기까지만 쓰면 종료됨과 동시에 음악이 들리는 판정이라 아예 안들림(종료가 함께되기 때문)
				try {
					Thread.sleep(1000); // 소리가 나온 후 1초뒤 프로그램 종료라는 뜻
				} catch (InterruptedException ex) {
					ex.printStackTrace(); // 에러메세지의 발생근원지를 찾아 단계별로 에러 출력
				}
				System.exit(0); // 클릭했을때는 프로그램이 종료된다.
			}
		});
		add(exitButton);

		menubar.setBounds(0, 0, 1280, 30); // setBounds는 위치와 크기를 정해준다.
		// 왼쪽부터 x좌표, y좌표, 가로넓이, 세로넓이이다.
		menubar.addMouseListener(new MouseAdapter() { 
			@Override
			public void mousePressed(MouseEvent e) { // 마우스로 해당버튼을 눌렀을 때의 이벤트 처리
				mouseX = e.getX();
				mouseY = e.getY(); // 실제로 이벤트가 발생했을때의 그 x,y 좌표를 얻어온다.
			}
		});
		menubar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) { // 드래그 이벤트가 발생했을 때의 처리
				int x = e.getXOnScreen();
				int y = e.getYOnScreen(); // 윈도우 창 내에서의 x,y 좌표
				setLocation(x - mouseX, y - mouseY);
			/* 드래그할때 그 순간마다 x,y 좌표를 얻어와서 자동으로 현재 jframe 즉 게임창의 위치를 바꿔준다.
			 * 한 마디로 메뉴바를 어딘가로 드래그했을때 그런 이벤트 처리를 해준다. */
			}
		});
		add(menubar); // Jframe에 메뉴바가 추가된다.

		Music introMusic = new Music("introMusic.mp3", true); // 시작화면에서 음악이 무한정 반복
		introMusic.start();

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 1280*720의 이미지를 만들어 준 뒤 그걸 screenImage에 넣어주겠다.
		screenGraphic = screenImage.getGraphics(); // screenImage를 이용하여 그래픽 객체 얻어오기
		screenDraw(screenGraphic); // screenGraphic에 어떠한 그림을 그려주나 만드는건 아래에 있음
		g.drawImage(screenImage, 0, 0, null); // 게임창에 screenImage가 그려짐
	}

	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null); // introbackground를 0,0의 위치에 그려준다.
		paintComponents(g);
		/*
		 * 이미지를 단순하게 해당 screenImage라는 변수 안에 그려주는 것 외에 Jlabel의 menubar처럼 따로 추가해주는것을 의미 .
		 * drawImage랑 paintcomponents 둘 다 사용할 때가 다름 drawImage는 배경처럼 단순한 이미지를 보일때 사용,
		 * 단순하게 한동안 그려주는 함수 paintcomponents는 하나의 버튼이나 메뉴바처럼 역동적이지 않고 항상 그곳에 존재할 때 사용 ex)
		 * JLabel
		 */
		this.repaint(); // paint는 GUI를 사용한 게임에서 가장 첫번째로 화면을 그려주는 함수(메소드)
		/*
		 * 즉 전체화면을 매 순간마다 paint를 다시 불러오면서 계속 반복시키는 것 한번만 나오게 하면 버퍼링이 심하게 걸리므로 더블 버퍼링을
		 * 사용한다.
		 */
	}

}
