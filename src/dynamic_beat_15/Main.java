package dynamic_beat_15;

public class Main {

	public static final int SCREEN_WIDTH = 1280;	// �ػ� 1280*720
	public static final int SCREEN_HEIGHT = 720;	// ���� ����� ������ �빮�ڷ� ����
	// public static�� ��� ������Ʈ ���ο��� �����Ҽ��ִ� ������ �ǹ�
	public static final int NOTE_SPEED = 3; // ��Ʈ�� �������� �ӵ�
	public static final int SLEEP_TIME = 10; // ��Ʈ�� ���������� �������� ���� �ƴ϶� �� �ֱ�� ����������
	public static final int REACH_TIME = 2; // ��Ʈ�� ������ �� �����ٿ� �����ϰԵǴ� �ð�
	
	public static void main(String[] args) {
		// ��������� ������(����)

		new DynamicBeat();
		
	}

}
