package dynamic_beat_13;

import java.awt.*;
import java.util.*;

import javax.swing.*;

public class Game extends Thread { // �����带 ��ӹ��� �� �ְ� �Ѵ�. ������� �ϳ��� ���α׷��ȿ��� ����Ǵ� ���� ���α׷�
	
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png"))
			.getImage(); // ��Ʈ�������� ������ ���δ� ����
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png"))
			.getImage(); // ������ ����
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png"))
			.getImage(); // �Ʒ� ��
	private Image noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage(); // ��Ʈ�������� ����
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteF1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage();
	private Image noteRouteF2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png"))
			.getImage(); // F �� ��Ʈ������ �ٸ� ���α��̺��� 2�� ��� ����
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
		gameMusic = new Music(this.musicTitle, false); // �ѹ��� ����ǵ���
		gameMusic.start();
		dropNotes(titleName);
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
		for (int i = 0; i < noteList.size(); i++) { // �������κ��� ���ʿ� ��µǾ���ϱ⿡ ����� ����.
			Note note = noteList.get(i);
			note.screenDraw(g);
		} // �ϳ��� ���� ����Ʈ�� �ִ� ��Ʈ���� �ҷ��ͼ� �� ��Ʈ���� �׷��� �� �ֵ��� �Ѵ�.
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		// ���ڰ� �����°� �����ϱ����� ��Ƽ�ٸ����
		g.setFont(new Font("Arial", Font.BOLD, 30)); // Arial �۾�ü�� ���ϰ� ũ�� 30����
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
		// ���� ��ġ�����س��� ����!
	}
	// Ű���带 ������ ��
	public void pressA() {
		noteRouteAImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png"))
				.getImage();
		// new Music("000.mp3", false).start(); ��� ������ Ű �Է½� �־�ߵǴ� ���� ������ ���ڴ� ���� �ʾҴ�. (11�� 11��) ���߿� ���������Ŵ�.
		
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
	
	// Ű���带 ���� ��
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
		
	}
	
	public void close() {
		gameMusic.close();
		this.interrupt(); // ���� ����ǰ� �ִ� �� Game�̶�� �����带 ����
	}
	
	public void dropNotes(String titleName) {
		Note note = new Note(228, "short"); // ����
		note.start();
		noteList.add(note);
	}
}
