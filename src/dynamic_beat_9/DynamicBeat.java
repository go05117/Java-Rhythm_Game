package dynamic_beat_9;

import java.awt.*; // private문의 image, graphics를 위한 문
import java.awt.event.*; // mouse x,y 좌표를 위한 문
import java.util.*;

import javax.swing.*; // ctrl + shift + O를 누르면 필요한 이런것들을 추가시켜줌.

public class DynamicBeat extends JFrame {
	// 그래픽 기반을 받기위해 사용하는것(1강 11분)

	private Image screenImage;
	private Graphics screenGraphic; // 이 2개는 더블 버퍼링을 위한 것들
	
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
	/* main 클래스 위치를 기반으로 imtrobackground.jpg를 getresource(얻어온 다음) 그 이미지 인스턴스를
	 * background에 초기화 시킨다.	 */
	private JLabel menubar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));

	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);
	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);
	private JButton backButton = new JButton(backButtonBasicImage);
	
	private int mouseX, mouseY; // 현재 프로그램 내부에서 마우스의 x,y 좌표 그 자체를 의미한다.
	
	private boolean isMainScreen = false; // 처음에는 메인화면이 아닌 시작화면이기에 false로 시작
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	// 각각의 곡을 담을 리스트를 만들었음

	private Image titleImage; // 곡 제목
	private Image selectedImage; // 곡 썸네일
	private Music selectedMusic; // 곡 음악
	private Music introMusic = new Music("introMusic.mp3", true); // 시작화면에서 음악이 무한정 반복
	private int nowSelected = 0; // 위의 trackList에서 Array의 첫번째 값은 0이기 때문

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
		
		introMusic.start();
		
		trackList.add(new Track("Aimer - Stardust Title Image.png","Aimer - Stardust Start Image.png",
				"Aimer - Stardust Game Image.png", "Aimer - Stardust Selected.mp3", "Aimer - Stardust.mp3"));
		trackList.add(new Track("Alan Walker - Faded Title Image.png","Alan Walker - Faded Start Image.png",
				"Alan Walker - Faded Game Image.png", "Alan Walker - Faded Selected.mp3", "Alan Walker - Faded.mp3"));
		trackList.add(new Track("월피스카터-시간의 비, 최종전쟁 Title Image.png","월피스카터-시간의 비, 최종전쟁 Start Image.png",
				"월피스카터-시간의 비, 최종전쟁 Game Image.png", "월피스카터-시간의 비, 최종전쟁 Selected.mp3", "월피스카터-시간의 비, 최종전쟁.mp3"));
		// 입력순서는 Track 클래스에 publc Track에 있음 / 차례대로 위에서부터 0번째 인덱스, 1번째 인덱스 이렇게 적용됨
		
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

	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		// 1280*720의 이미지를 만들어 준 뒤 그걸 screenImage에 넣어주겠다.
		screenGraphic = screenImage.getGraphics(); // screenImage를 이용하여 그래픽 객체 얻어오기
		screenDraw(screenGraphic); // screenGraphic에 어떠한 그림을 그려주나 만드는건 아래에 있음
		g.drawImage(screenImage, 0, 0, null); // 게임창에 screenImage가 그려짐
	}

	public void screenDraw(Graphics g) {
		g.drawImage(background, 0, 0, null); // introbackground를 0,0의 위치에 그려준다.
		if (isMainScreen) { // 화면이 메인화면일 때 보여주는 그림
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		paintComponents(g);
		/* 이미지를 단순하게 해당 screenImage라는 변수 안에 그려주는 것 외에 Jlabel의 menubar처럼
		 * 따로 추가해주는것을 의미 / drawImage랑 paintcomponents 둘 다 사용할 때가 다름
		 * drawImage는 배경처럼 단순한 이미지를 보일때 사용, 단순하게 한동안 그려주는 함수
		   g.drawImage들은 단순히 화면에 그려준 거임(일반적인 이미지 또는 움직이는 이미지를 표현할 때 사용)
		 * paintcomponents는 하나의 버튼이나 메뉴바처럼 역동적이지 않고 항상 그곳에 존재할 때 사용 ex) JLabel
		       메인 프레임에 추가된 요소를 보여주는 것. ex) 위의 add(00000)가 paintcomponents로 그려진것	 */
		this.repaint(); // paint는 GUI를 사용한 게임에서 가장 첫번째로 화면을 그려주는 함수(메소드)
		/* 즉 전체화면을 매 순간마다 paint를 다시 불러오면서 계속 반복시키는 것 한번만 나오게 하면 버퍼링이 심하게
		       걸리므로 더블 버퍼링을 사용한다.		 */
	}
	public void selectTrack(int nowSelected) { // 현재 선택된 곡의 번호를 알려줌으로써 해당곡이 선택된것을 알려줌
		if(selectedMusic != null) {
			selectedMusic.close(); // 어떠한 곡이 실행되고있다면 바로 종료시켜준다.
		}	titleImage = new ImageIcon(Main.class.getResource("../images/" + trackList
					.get(nowSelected).getTitleImage())).getImage();
			// 현재 선택된 트랙(곡)이 가지고 있는 타이틀(제목) 이미지값을 가져와서 넣어주겠다는 의미
			selectedImage = new ImageIcon(Main.class.getResource("../images/" + trackList
					.get(nowSelected).getStartImage())).getImage();
			// 곡의 썸네일 바꾸기
			selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
			selectedMusic.start();
	}
	
	public void selectLeft() {
		if(nowSelected == 0) {
			nowSelected = trackList.size() - 1;
			// 0번째 곡일 때 왼쪽버튼을 누르면 가장 오른쪽이 선택되어야하므로 이렇게 한다.
		} else {
			nowSelected--;
		} selectTrack(nowSelected);
	}
	
	public void selectRight() {
		if(nowSelected == trackList.size() - 1) {
			// 트랙의 곡이 가장 오른쪽에 있는 곡이라면
			nowSelected = 0;
		} else {
			nowSelected++;			
		} selectTrack(nowSelected);
	}
	public void gameStart(int nowSelected, String difficulty) { // 현재선택된곡 난이도에 대한 정보
		if(selectedMusic != null) { // 어떤 곡이 실행중이라면
			selectedMusic.close(); // 이제 재생할 음악이 실행되도록 종료한다.
		} isMainScreen = false; // 메인화면이 아니라는 것을 변수로 알려줌
		// 위의 screenDraw의 if문이 실행되지않는다.
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
		selectTrack(nowSelected); // 다시 순번에 맞는 곡을 재생시켜라
	
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
		selectTrack(0); // 맨 처음에는 0번째 곡이 선택되기 때문
	}
}
