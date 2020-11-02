package dynamic_beat_13;

import java.io.*;

import javazoom.jl.player.*; // javazoom ����Ʈ���� �뷡���� ������ ������ ����ȭ�鿡 �ٿ����

public class Music extends Thread {
	// Thread�� ���α׷� ���� ���� ���α׷�
	
	private Player player; // Player�� javazoom����Ʈ�� ���̺귯�� �� �ϳ�
	private boolean isLoop; // ���� ���ѹݺ����� �ѹ��� ������� �׿����� ������ ���� ����
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop ) {
	//�����ڸ� �����. ���� �����, ���ѹݺ����� ���ο� �Բ�
		try { // try catch���� ����ó���� ���� ��. try������ ������ �߻��ϸ� catch������ �Ѿ��.
			this.isLoop = isLoop; // isLoop��� ���� �ʱ�ȭ
			file = new File(Main.class.getResource("../Music/" + name).toURI());
            fis = new FileInputStream(file); //�ش� ���������� �ҷ��´�
            bis = new BufferedInputStream(fis); // �ҷ��� ���������� ���ۿ� ��´�
            player = new Player(bis); // player�� �ش������� ���� �� �ְ� ���ش�.
		} catch (Exception e) {
			System.out.println(e.getMessage()); //���� �޼��� ����
		}
	}
    public int getTime() { /* getTime�� ���� ����ǰ� �ִ� ������ ���ġ���� ����ǰ� �ִ��� Ȯ��
			���� ������ 10������ ����ǰ������� �� �Լ��� 10000�� ��ȯ��, �� 0.001�� �������� �˷���
			���Ŀ� � ��Ʈ�� ����߸��� getTime�Լ��� ���� �ð��� �м��ϰԵ�    */
    	if (player == null)
    		return 0;
    	return player.getPosition();
    }
    public void close() { // ������ ��� ��ġ���� ����Ǵ��� �׻� ����ɼ� �ֵ��� �Ѵ�. ex) ���� �� �ڷΰ��� 
        isLoop = false;
        player.close();
        this.interrupt(); // interrupt�� �ش� Thread�� �������·� �����.(�� ��� ������Ų��.)(���� �κ�)
    }
    
    @Override
    /* �θ� Ŭ������ �ִ� �޼ҵ带 �ڽ� Ŭ�������� ������ �ϴ� ���Դϴ�.
     * �ڽ� Ŭ������ �θ� Ŭ������ ����Ͽ� �ڽĿ��� ���� �޼ҵ带 ȣ���ϸ� �θ�Ŭ������ ���� �ش� �޼ҵ带 ã�� �˴ϴ�.
     * ���� �θ� Ŭ������ �޼ҵ带 �ڽ�Ŭ�������� ������ �̸����� �ٽ� ������ �ϸ� �θ� Ŭ������ �޼ҵ带 ã�� �ʰ�
     * �ڽ� Ŭ������ �޼ҵ带 ȣ���ϰ� �˴ϴ�. �̰��� �������̵�(������)��� �մϴ�.    */
    public void run() { // Thread�� ���� �ݵ�� ����ؾߵǴ� run
        try {
            do {
                player.play(); // ���� �����Ų��.
                fis = new FileInputStream(file); //�ش� ���������� �ҷ��´�
                bis = new BufferedInputStream(fis); // �ҷ��� ���������� ���ۿ� ��´�
                player = new Player(bis);
            } while(isLoop); // isLoop�� true���̶�� ���ѹݺ�
        }catch(Exception e) {
            System.out.println(e.getMessage()); //���� �޼��� ����
        }
        
    }
}
