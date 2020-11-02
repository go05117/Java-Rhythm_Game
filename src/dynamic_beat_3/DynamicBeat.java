package dynamic_beat_3;

import java.awt.*; // private문의 image, graphics를 위한 문

import javax.swing.*; // ctrl + shift + O를 누르면 필요한 이런것들을 추가시켜줌.

public class DynamicBeat extends JFrame {
	// 그래픽 기반을 받기위해 사용하는것(1강 11분)
	
	private Image screenImage;
	private Graphics screenGraphic; // 이 2개는 더블 버퍼링을 위한 것들
	
	private Image introBackground; // 폴더 images에 담아 둔 파일을 담아오는 것
	
	
	public DynamicBeat() {
		// 생성자는 자신의 클래스와 같은 이름을 가지고 있음
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 한번 만들어진 게임창은 사용자가 임의로 줄이거나 늘릴수없다.
		setLocationRelativeTo(null); // 실행했을 때 창이 컴퓨터 정중앙에 뜬다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 게임창을 종료했을때 프로그램 전체가 종료(이거 안넣어주면 창 꺼도 프로그램이 계속 돌아감)
		setVisible(true); // 우리가 만든 창이 화면에 정상적을 출력되도록 하는것
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introbackground(title).jpg")).getImage();
		/* main 클래스 위치를 기반으로 imtrobackground.jpg를 getresource(얻어온 다음)
		      그 이미지 인스턴스를 introBackground에 초기화 시킨다. 	*/
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
		this.repaint(); // paint는 GUI를 사용한 게임에서 가장 첫번째로 화면을 그려주는 함수(메소드)
		/* 즉 전체화면을 매 순간마다 paint를 다시 불러오면서 계속 반복시키는 것
		 * 한번만 나오게 하면 버퍼링이 심하게 걸리므로 더블 버퍼링을 사용한다.	 */
	}

}
