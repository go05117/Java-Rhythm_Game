package dynamic_beat_1;

import javax.swing.*; // ctrl + shift + O를 누르면 필요한 이런것들을 추가시켜줌.

public class DynamicBeat extends JFrame {
	// 그래픽 기반을 받기위해 사용하는것(1강 11분)
	public DynamicBeat() {
		// 생성자는 자신의 클래스와 같은 이름을 가지고 있음
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false); // 한번 만들어진 게임창은 사용자가 임의로 줄이거나 늘릴수없다.
		setLocationRelativeTo(null); // 실행했을 때 창이 컴퓨터 정중앙에 뜬다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 게임창을 종료했을때 프로그램 전체가 종료(이거 안넣어주면 창 꺼도 프로그램이 계속 돌아감)
		setVisible(true); // 우리가 만든 창이 화면에 정상적을 출력되도록 하는것
		

	}

}
