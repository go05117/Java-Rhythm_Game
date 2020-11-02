package dynamic_beat_3;

import java.awt.*; // private���� image, graphics�� ���� ��

import javax.swing.*; // ctrl + shift + O�� ������ �ʿ��� �̷��͵��� �߰�������.

public class DynamicBeat extends JFrame {
	// �׷��� ����� �ޱ����� ����ϴ°�(1�� 11��)
	
	private Image screenImage;
	private Graphics screenGraphic; // �� 2���� ���� ���۸��� ���� �͵�
	
	private Image introBackground; // ���� images�� ��� �� ������ ��ƿ��� ��
	
	
	public DynamicBeat() {
		// �����ڴ� �ڽ��� Ŭ������ ���� �̸��� ������ ����
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // �ѹ� ������� ����â�� ����ڰ� ���Ƿ� ���̰ų� �ø�������.
		setLocationRelativeTo(null); // �������� �� â�� ��ǻ�� ���߾ӿ� ���.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����â�� ���������� ���α׷� ��ü�� ����(�̰� �ȳ־��ָ� â ���� ���α׷��� ��� ���ư�)
		setVisible(true); // �츮�� ���� â�� ȭ�鿡 �������� ��µǵ��� �ϴ°�
		
		introBackground = new ImageIcon(Main.class.getResource("../images/introbackground(title).jpg")).getImage();
		/* main Ŭ���� ��ġ�� ������� imtrobackground.jpg�� getresource(���� ����)
		      �� �̹��� �ν��Ͻ��� introBackground�� �ʱ�ȭ ��Ų��. 	*/
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
		this.repaint(); // paint�� GUI�� ����� ���ӿ��� ���� ù��°�� ȭ���� �׷��ִ� �Լ�(�޼ҵ�)
		/* �� ��üȭ���� �� �������� paint�� �ٽ� �ҷ����鼭 ��� �ݺ���Ű�� ��
		 * �ѹ��� ������ �ϸ� ���۸��� ���ϰ� �ɸ��Ƿ� ���� ���۸��� ����Ѵ�.	 */
	}

}
