package dynamic_beat_14;

import java.awt.*;

import javax.swing.*;

public class Note extends Thread { // 각각의 노트 또한 하나의 부분적인 기능으로써 떨어지는 역할을 수행해야하기 때문에 스레드로 만든다.
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	// 노트 위치 및 노트는 생성된후 정확히 1초 뒤에 떨어진다.
	private String noteType;
	
	public Note(String noteType) {
		if(noteType.equals("A")) {
			x = 228;
		} else if(noteType.equals("S")) {
			x = 332;
		} else if(noteType.equals("D")) {
			x = 436;
		} else if(noteType.equals("F")) {
			x = 540;
		} else if(noteType.equals("J")) {
			x = 744;
		}  else if(noteType.equals("K")) {
			x = 848;
		}  else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw (Graphics2D g) {
		if(!noteType.equals("F")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null); // long은 보통 스페이스바 같은 긴 것에 사용(기본 노트 가로폭이 100이라 200길이만큼 만듬)
		}
	}
	
	public void drop() {
		y += Main.NOTE_SPEED; 
	}
	
	@Override
	public void run() {
		try {
			while(true) {
			drop();
			Thread.sleep(Main.SLEEP_TIME);
			}
			
		} catch(Exception e) { 
			System.err.println(e.getMessage());
		}
		
	}

	
}
