package dynamic_beat_1;

import javax.swing.*; // ctrl + shift + O�� ������ �ʿ��� �̷��͵��� �߰�������.

public class DynamicBeat extends JFrame {
	// �׷��� ����� �ޱ����� ����ϴ°�(1�� 11��)
	public DynamicBeat() {
		// �����ڴ� �ڽ��� Ŭ������ ���� �̸��� ������ ����
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // �ѹ� ������� ����â�� ����ڰ� ���Ƿ� ���̰ų� �ø�������.
		setLocationRelativeTo(null); // �������� �� â�� ��ǻ�� ���߾ӿ� ���.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// ����â�� ���������� ���α׷� ��ü�� ����(�̰� �ȳ־��ָ� â ���� ���α׷��� ��� ���ư�)
		setVisible(true); // �츮�� ���� â�� ȭ�鿡 �������� ��µǵ��� �ϴ°�
		

	}

}
