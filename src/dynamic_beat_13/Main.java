package dynamic_beat_13;

public class Main {

	public static final int SCREEN_WIDTH = 1280;	// 해상도 1280*720
	public static final int SCREEN_HEIGHT = 720;	// 보통 상수는 완전히 대문자로 만듬
	// public static은 모든 프로젝트 내부에서 공유할수있는 변수를 의미
	public static final int NOTE_SPEED = 7; // 노트가 떨어지는 속도
	public static final int SLEEP_TIME = 10; // 노트가 무한정으로 떨어지는 것이 아니라 얼마 주기로 떨어지느냐
	
	public static void main(String[] args) {
		// 리듬게임을 만들어보자(동빈나)

		new DynamicBeat();
		
	}

}
