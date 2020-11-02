package dynamic_beat_13;

import java.awt.*;

import javax.swing.*;

public class Note extends Thread { // ������ ��Ʈ ���� �ϳ��� �κ����� ������ν� �������� ������ �����ؾ��ϱ� ������ ������� �����.
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = 580 - 1000 / Main.SLEEP_TIME * Main.NOTE_SPEED; // ��Ʈ ��ġ �� ��Ʈ�� �������� ��Ȯ�� 1�� �ڿ� ��������.
	private String noteType;
	
	public Note(int x, String noteType) {
		this.x = x;
		this.noteType = noteType;
	}
	
	public void screenDraw (Graphics2D g) {
		if(noteType.equals("short")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else if (noteType.equals("long")) {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null); // long�� ���� �����̽��� ���� �� �Ϳ� ���(�⺻ ��Ʈ �������� 100�̶� 200���̸�ŭ ����)
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
