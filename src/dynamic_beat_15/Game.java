package dynamic_beat_15;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Game extends Thread { // 스레드를 상속받을 수 있게 한다. 스레드란 하나의 프로그램안에서 실행되는 작은 프로그램
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
			.getImage(); // 노트내려오는 라인을 감싸는 라인
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
			.getImage(); // 눌리는 라인
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
			.getImage(); // 아래 선
	private Image noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage(); // 노트내려오는 라인
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteF1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteF2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage(); // F 쪽 노트라인이 다른 라인길이보다 2배 길기 때문
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;
	
	ArrayList<Note> noteList = new ArrayList<Note>();
	
	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false); // 한번만 실행되도록
	}
	
	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteAImage, 228, 30, null);
		g.drawImage(noteRouteSImage, 332, 30, null);
		g.drawImage(noteRouteDImage, 436, 30, null);
		g.drawImage(noteRouteF1Image, 540, 30, null);
		g.drawImage(noteRouteF2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
		for (int i = 0; i < noteList.size(); i++) { // 판정라인보다 위쪽에 출력되어야하기에 여기다 쓴다.
			Note note = noteList.get(i);
			note.screenDraw(g);
		} // 하나씩 현재 리스트에 있는 노트들을 불러와서 각 노트들을 그려줄 수 있도록 한다.
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		// 글자가 깨지는걸 방지하기위한 안티앨리어싱
		g.setFont(new Font("Arial", Font.BOLD, 30)); // Arial 글씨체로 진하게 크기 30으로
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 700);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("A", 270, 609);
		g.drawString("S", 374, 609);			
		g.drawString("D", 478, 609);		
		g.drawString("F", 631, 609);		
		g.drawString("J", 784, 609);		
		g.drawString("K", 889, 609);		
		g.drawString("L", 993, 609);		
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString("score0000", 565, 710);
		// 대충 위치조절해놨음 참고!
	}
	// 키보드를 눌렀을 때
	public void pressA() {
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
		// new Music("000.mp3", false).start(); 라고 원래는 키 입력시 넣어야되는 음이 있으나 필자는 넣지 않았다. (11강 11분) 나중에 지워버릴거다.
		
	}
	public void pressS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void pressD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void pressF() {
		noteRouteF1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
		noteRouteF2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void pressJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void pressK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	public void pressL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
	}
	
	// 키보드를 땠을 때
	public void releaseA() {
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void releaseF() {
		noteRouteF1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
		noteRouteF2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
				.getImage();
	}
	
	@Override
	public void run() {
		dropNotes(this.titleName);
		
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt(); // 지금 실행되고 있는 이 Game이라는 스레드를 종료
	}
	
	public void dropNotes(String titleName) {
		Beat[] beats = null;
		// 14강에 비트 찍는법 있음
		if(titleName.equals("Aimer - Stardust")) {
			int startTime = 9220 - Main.REACH_TIME * 1000; // 노트도달시간에 구애받지 않고 항상 똑같은 첫번째 노트가 판정바에 적중하는 그 박자타이밍을 유지가능
			int gap = 125; // 최소박자의 갭차이
			beats = new Beat[] {
					new Beat(startTime, "F"),
					new Beat(startTime + gap * 2, "A"),
					new Beat(startTime + gap * 4, "S"),
					new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "J"),
					new Beat(startTime + gap * 10, "K"),
					new Beat(startTime + gap * 12, "L"),
					new Beat(startTime + gap * 13, "A"),					
					new Beat(startTime + gap * 14, "S"),
					new Beat(startTime + gap * 16, "D"),
					new Beat(startTime + gap * 18, "J"),
					new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 22, "L"),
					new Beat(startTime + gap * 24, "A"),
					new Beat(startTime + gap * 26, "S"),
					new Beat(startTime + gap * 28, "D"),
					new Beat(startTime + gap * 30, "J"),
					new Beat(startTime + gap * 32, "K"),
					new Beat(startTime + gap * 34, "L"),
					new Beat(startTime + gap * 36, "A"),
					new Beat(startTime + gap * 38, "S"),
					new Beat(startTime + gap * 40, "D"),
					new Beat(startTime + gap * 42, "J"),
					new Beat(startTime + gap * 44, "K"),
					new Beat(startTime + gap * 46, "L"),
					new Beat(startTime + gap * 48, "A"),
					new Beat(startTime + gap * 48, "S"),
					new Beat(startTime + gap * 48, "D"),
					new Beat(startTime + gap * 48, "J"),
					new Beat(startTime + gap * 48, "K"),
					new Beat(startTime + gap * 48, "L"),
					new Beat(startTime + gap * 54, "A"),
					new Beat(startTime + gap * 60, "S"),
					new Beat(startTime + gap * 66, "D"),
					new Beat(startTime + gap * 72, "F"),
					new Beat(startTime + gap * 78, "J"),
					new Beat(startTime + gap * 84, "K"),
					new Beat(startTime + gap * 90, "L"),
					new Beat(startTime + gap * 96, "D"),
					new Beat(startTime + gap * 102, "S"),
					new Beat(startTime + gap * 108, "A"),
					new Beat(startTime + gap * 114, "J"),
					new Beat(startTime + gap * 120, "L"),
					new Beat(startTime + gap * 126, "L"),
					new Beat(startTime + gap * 132, "K"),
					// 여기부터 가사					
					new Beat(startTime + gap * 137, "S"),
					new Beat(startTime + gap * 142, "A"),
					new Beat(startTime + gap * 147, "D"),
					new Beat(startTime + gap * 152, "F"),					
					new Beat(startTime + gap * 157, "A"),
					
					new Beat(startTime + gap * 160, "J"),					
					new Beat(startTime + gap * 162, "K"),
					new Beat(startTime + gap * 164, "L"),
					new Beat(startTime + gap * 168, "L"),
					
					new Beat(startTime + gap * 170, "D"),
					new Beat(startTime + gap * 172, "D"),
					new Beat(startTime + gap * 174, "S"),
					new Beat(startTime + gap * 176, "A"),
					new Beat(startTime + gap * 180, "F"),
					
					new Beat(startTime + gap * 183, "S"),
					new Beat(startTime + gap * 185, "S"),
					new Beat(startTime + gap * 188, "D"),
					new Beat(startTime + gap * 192, "A"),
					new Beat(startTime + gap * 194, "J"),
					new Beat(startTime + gap * 196, "J"),
					new Beat(startTime + gap * 198, "J"),
					new Beat(startTime + gap * 200, "L"),
					new Beat(startTime + gap * 202, "K"),
					
					new Beat(startTime + gap * 204, "S"),
					new Beat(startTime + gap * 208, "S"),
					new Beat(startTime + gap * 211, "S"),
					new Beat(startTime + gap * 213, "S"), // 아루키
					new Beat(startTime + gap * 216, "S"),
					new Beat(startTime + gap * 218, "S"),
					new Beat(startTime + gap * 220, "S"),
					new Beat(startTime + gap * 222, "S"),
					
					new Beat(startTime + gap * 227, "A"),
					new Beat(startTime + gap * 229, "S"),
					new Beat(startTime + gap * 231, "S"),
					new Beat(startTime + gap * 233, "S"),
					new Beat(startTime + gap * 236, "S"),
					new Beat(startTime + gap * 238, "D"),
					new Beat(startTime + gap * 241, "S"),
					new Beat(startTime + gap * 244, "S"),
					new Beat(startTime + gap * 247, "S"),
					new Beat(startTime + gap * 250, "S"),
					new Beat(startTime + gap * 252, "S"), // 나~데
				
					new Beat(startTime + gap * 257, "J"),
					new Beat(startTime + gap * 260, "K"),
					new Beat(startTime + gap * 263, "K"),
					new Beat(startTime + gap * 266, "K"),
					new Beat(startTime + gap * 269, "K"),
					new Beat(startTime + gap * 272, "K"), // 나~데
					
					
			};
		} else if (titleName.equals("Alan Walker - Faded")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125; // 최소박자의 갭차이
			beats = new Beat[] {
					new Beat(startTime, "D"),
					new Beat(startTime + gap * 10, "S"),
					new Beat(startTime + gap * 13, "D"),
					new Beat(startTime + gap * 16, "S"),
					new Beat(startTime + gap * 19, "K"),
					new Beat(startTime + gap * 22, "J"),
					new Beat(startTime + gap * 25, "K"),
					new Beat(startTime + gap * 28, "J"),
					new Beat(startTime + gap * 31, "K"),
					new Beat(startTime + gap * 34, "J"),
					new Beat(startTime + gap * 37, "K"),
					new Beat(startTime + gap * 39, "L"),					
					new Beat(startTime + gap * 40, "F"),
					new Beat(startTime + gap * 43, "D"),
					new Beat(startTime + gap * 46, "A"),
					new Beat(startTime + gap * 49, "D"),
					new Beat(startTime + gap * 52, "A"),
					new Beat(startTime + gap * 58, "S"),
					new Beat(startTime + gap * 61, "A"),
					new Beat(startTime + gap * 64, "S"),
					new Beat(startTime + gap * 67, "A"),
			};
		} else if (titleName.equals("월피스카터-시간의 비, 최종전쟁")) {
			int startTime = 3840 - Main.REACH_TIME * 1000;
			int gap = 125; // 최소박자의 갭차이
			beats = new Beat[] {
					// 왼손(반주)
					// 반주 1
					new Beat(startTime, "A"), // 2
					new Beat(startTime + gap * 2, "S"), // 2
					new Beat(startTime + gap * 4, "D"), // 2
					new Beat(startTime + gap * 6, "F"), // 2
					new Beat(startTime + gap * 9, "A"), // 3
					new Beat(startTime + gap * 11, "S"),// 2
					new Beat(startTime + gap * 13, "D"),// 2
					new Beat(startTime + gap * 15, "F"),// 2
					new Beat(startTime + gap * 18, "A"),// 3
					new Beat(startTime + gap * 20, "S"),// 2
					new Beat(startTime + gap * 22, "F"),// 2
					new Beat(startTime + gap * 24, "D"),// 2
					new Beat(startTime + gap * 26, "A"),// 2
					new Beat(startTime + gap * 28, "S"),// 2
					new Beat(startTime + gap * 30, "F"),// 2
					new Beat(startTime + gap * 32, "D"),// 2
					new Beat(startTime + gap * 35, "A"),// 3
					new Beat(startTime + gap * 37, "S"),// 2
					new Beat(startTime + gap * 39, "D"),// 2
					new Beat(startTime + gap * 41, "F"),// 2
					new Beat(startTime + gap * 44, "A"),// 3
					new Beat(startTime + gap * 46, "S"),// 2
					new Beat(startTime + gap * 48, "D"),// 2
					new Beat(startTime + gap * 50, "F"),// 2
					new Beat(startTime + gap * 52, "A"),// 2
					new Beat(startTime + gap * 54, "S"),// 2
					new Beat(startTime + gap * 56, "F"),// 2
					new Beat(startTime + gap * 58, "D"),// 2
					new Beat(startTime + gap * 60, "A"),// 2
					new Beat(startTime + gap * 62, "S"),// 2
					new Beat(startTime + gap * 64, "F"),// 2
					new Beat(startTime + gap * 66, "D"),// 2
					// 왼손 반주 완성
					new Beat(startTime + gap * 68, "A"), // 2
					new Beat(startTime + gap * 70, "S"), // 2
					new Beat(startTime + gap * 72, "D"), // 2
					new Beat(startTime + gap * 74, "F"), // 2
					new Beat(startTime + gap * 77, "A"), // 3
					new Beat(startTime + gap * 79, "S"),// 2
					new Beat(startTime + gap * 81, "D"),// 2
					new Beat(startTime + gap * 83, "F"),// 2
					new Beat(startTime + gap * 85, "A"),// 3 -> 2
					new Beat(startTime + gap * 87, "S"),// 2
					new Beat(startTime + gap * 89, "F"),// 2
					new Beat(startTime + gap * 91, "D"),// 2
					new Beat(startTime + gap * 93, "A"),// 2
					new Beat(startTime + gap * 95, "S"),// 2
					new Beat(startTime + gap * 97, "F"),// 2
					new Beat(startTime + gap * 99, "D"),// 2
					
					new Beat(startTime + gap * 102, "A"),// 3 -> 2
					new Beat(startTime + gap * 104, "S"),// 2
					new Beat(startTime + gap * 106, "D"),// 2
					new Beat(startTime + gap * 108, "F"),// 2
					new Beat(startTime + gap * 110, "A"),// 3 -> 2
					new Beat(startTime + gap * 112, "S"),// 2
					new Beat(startTime + gap * 114, "D"),// 2
					new Beat(startTime + gap * 116, "F"),// 2
					new Beat(startTime + gap * 118, "A"),// 2
					new Beat(startTime + gap * 120, "S"),// 2
					new Beat(startTime + gap * 122, "F"),// 2
					new Beat(startTime + gap * 124, "D"),// 2
					new Beat(startTime + gap * 126, "A"),// 2
					new Beat(startTime + gap * 128, "S"),// 2
					new Beat(startTime + gap * 130, "F"),// 2
					new Beat(startTime + gap * 132, "D"),// 2
					
					// 오른손(반주)
					new Beat(startTime + gap * 134, "J"), // 2
					new Beat(startTime + gap * 136, "K"), // 2
					new Beat(startTime + gap * 138, "L"), // 2
					new Beat(startTime + gap * 140, "K"), // 2
					new Beat(startTime + gap * 143, "J"), // 3
					new Beat(startTime + gap * 145, "K"),// 2
					new Beat(startTime + gap * 147, "L"),// 2
					new Beat(startTime + gap * 149, "K"),// 2
					new Beat(startTime + gap * 152, "J"),// 3
					new Beat(startTime + gap * 154, "L"),// 2
					new Beat(startTime + gap * 156, "K"),// 2
					new Beat(startTime + gap * 158, "L"),// 2
					new Beat(startTime + gap * 160, "J"),// 2
					new Beat(startTime + gap * 162, "L"),// 2
					new Beat(startTime + gap * 164, "K"),// 2
					new Beat(startTime + gap * 166, "L"),// 2
					new Beat(startTime + gap * 169, "J"),// 3
					new Beat(startTime + gap * 171, "K"),// 2
					new Beat(startTime + gap * 173, "L"),// 2
					new Beat(startTime + gap * 175, "K"),// 2
					new Beat(startTime + gap * 178, "J"),// 3
					new Beat(startTime + gap * 180, "K"),// 2
					new Beat(startTime + gap * 182, "L"),// 2
					new Beat(startTime + gap * 184, "K"),// 2
					new Beat(startTime + gap * 186, "J"),// 2
					new Beat(startTime + gap * 188, "L"),// 2
					new Beat(startTime + gap * 190, "K"),// 2
					new Beat(startTime + gap * 192, "L"),// 2
					new Beat(startTime + gap * 194, "J"),// 2
					new Beat(startTime + gap * 196, "L"),// 2
					new Beat(startTime + gap * 198, "K"),// 2
					new Beat(startTime + gap * 200, "L"),// 2
					// 오른손 가즈아
					new Beat(startTime + gap * 202, "J"), // 2
					new Beat(startTime + gap * 204, "K"), // 2
					new Beat(startTime + gap * 206, "L"), // 2
					new Beat(startTime + gap * 208, "K"), // 2
					new Beat(startTime + gap * 211, "J"), // 3
					new Beat(startTime + gap * 213, "K"),// 2
					new Beat(startTime + gap * 215, "L"),// 2
					new Beat(startTime + gap * 217, "K"),// 2
					new Beat(startTime + gap * 219, "J"),// 3 -> 2
					new Beat(startTime + gap * 221, "L"),// 2
					new Beat(startTime + gap * 223, "K"),// 2
					new Beat(startTime + gap * 225, "L"),// 2
					new Beat(startTime + gap * 227, "J"),// 2
					new Beat(startTime + gap * 229, "L"),// 2
					new Beat(startTime + gap * 231, "K"),// 2
					new Beat(startTime + gap * 233, "L"),// 2
					
					new Beat(startTime + gap * 235, "J"),// 3 -> 2
					new Beat(startTime + gap * 237, "K"),// 2
					new Beat(startTime + gap * 239, "L"),// 2
					new Beat(startTime + gap * 241, "K"),// 2
					new Beat(startTime + gap * 243, "J"),// 3 -> 2
					new Beat(startTime + gap * 245, "K"),// 2
					new Beat(startTime + gap * 247, "L"),// 2
					new Beat(startTime + gap * 249, "K"),// 2
					new Beat(startTime + gap * 251, "J"),// 2
					new Beat(startTime + gap * 253, "L"),// 2
					new Beat(startTime + gap * 255, "K"),// 2
					new Beat(startTime + gap * 257, "L"),// 2
					new Beat(startTime + gap * 259, "J"),// 2
					new Beat(startTime + gap * 261, "L"),// 2
					new Beat(startTime + gap * 263, "K"),// 2
					new Beat(startTime + gap * 265, "L"),// 2
			};
		} 
		int i = 0;
		gameMusic.start(); // 배열이 초기화되면서 오는 격차를 줄일 수 있기에 여기다 옮긴다.
		while(i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
				// i를 1씩 증가하면서 각각의 노트들을 하나하나 접근하면서 노트를 떨어뜨릴 수 있도록 한다.
				// 즉 현재 곡이 재생되는 시점을 실시간으로 파악해서 해당위치에 걸맞는 노트를 떨어뜨리는 간단한 논리
			}
			if(!dropped) { // dropped가 false 값이라면
				try {
					Thread.sleep(5); // 0.005초를 쉬도록 만들어준다.
				} catch (Exception e) {
					e.printStackTrace();
				} // 노트가 떨어지지 않은 경우에는 무한정 반복하는것이 아닌 텀을 두면서 떨어뜨린다.
			}
		}
	}
}
