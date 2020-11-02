package dynamic_beat_15;

import java.awt.event.*;

public class KeyListener extends KeyAdapter{ // Ű���� �Է½� �����ϱ� ���� Ŭ����
	
	@Override
	public void keyPressed(KeyEvent e) { // Ű�� �������� �̺�Ʈ ó��
		if(DynamicBeat.game == null) { // �� ���� ������ ����ǰ����� �ʴٸ� 
			return; // �Ʒ� �۾��� ���� �ʵ���, �� Ű���带 �������� ��� ��ȭ�� ������ �ʵ��� �Ѵ�.
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
	public void keyReleased(KeyEvent e) { // Ű�� ������ ���� ����� �̺�Ʈó��
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
