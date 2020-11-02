package dynamic_beat_15;

import java.awt.event.*;

public class KeyListener extends KeyAdapter{ // 키보드 입력시 감지하기 위한 클래스
	
	@Override
	public void keyPressed(KeyEvent e) { // 키를 누를때의 이벤트 처리
		if(DynamicBeat.game == null) { // 즉 현재 게임이 진행되고있지 않다면 
			return; // 아래 작업을 하지 않도록, 즉 키보드를 누르더라도 어떠한 변화도 생기지 않도록 한다.
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A) {
			DynamicBeat.game.pressA();
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			DynamicBeat.game.pressS();
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.pressD();
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.pressF();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.pressJ();
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.pressK();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.pressL();
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) { // 키를 눌렀다 때는 경우의 이벤트처리
		if(DynamicBeat.game == null) {
			return;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A) {
			DynamicBeat.game.releaseA();
		} else if(e.getKeyCode() == KeyEvent.VK_S) {
			DynamicBeat.game.releaseS();
		}else if(e.getKeyCode() == KeyEvent.VK_D) {
			DynamicBeat.game.releaseD();
		}else if(e.getKeyCode() == KeyEvent.VK_F) {
			DynamicBeat.game.releaseF();
		}else if(e.getKeyCode() == KeyEvent.VK_J) {
			DynamicBeat.game.releaseJ();
		}else if(e.getKeyCode() == KeyEvent.VK_K) {
			DynamicBeat.game.releaseK();
		}else if(e.getKeyCode() == KeyEvent.VK_L) {
			DynamicBeat.game.releaseL();
		}
	}
	
	

}
