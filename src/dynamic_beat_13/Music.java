package dynamic_beat_13;

import java.io.*;

import javazoom.jl.player.*; // javazoom 사이트에서 노래실행 가능한 파일을 바탕화면에 다운받음

public class Music extends Thread {
	// Thread는 프로그램 안의 작은 프로그램
	
	private Player player; // Player은 javazoom사이트의 라이브러리 중 하나
	private boolean isLoop; // 곡이 무한반복인지 한번만 재생인지 그에대한 설정을 위한 변수
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	
	public Music(String name, boolean isLoop ) {
	//생성자를 만든다. 곡의 제목과, 무한반복인지 여부와 함께
		try { // try catch문은 예외처리를 위한 문. try문에서 오류가 발생하면 catch문으로 넘어간다.
			this.isLoop = isLoop; // isLoop라는 변수 초기화
			file = new File(Main.class.getResource("../Music/" + name).toURI());
            fis = new FileInputStream(file); //해당 음악파일을 불러온다
            bis = new BufferedInputStream(fis); // 불러온 음악파일을 버퍼에 담는다
            player = new Player(bis); // player는 해당파일을 담을 수 있게 해준다.
		} catch (Exception e) {
			System.out.println(e.getMessage()); //오류 메세지 전송
		}
	}
    public int getTime() { /* getTime은 현재 실행되고 있는 음악이 어떤위치에서 실행되고 있는지 확인
			만약 음악이 10초정도 진행되고있으면 이 함수는 10000을 반환함, 즉 0.001초 단위까지 알려줌
			추후에 곡에 노트를 떨어뜨릴때 getTime함수를 통해 시간을 분석하게됨    */
    	if (player == null)
    		return 0;
    	return player.getPosition();
    }
    public void close() { // 음악이 어느 위치에서 실행되더라도 항상 종료될수 있도록 한다. ex) 게임 중 뒤로가기 
        isLoop = false;
        player.close();
        this.interrupt(); // interrupt는 해당 Thread를 중지상태로 만든다.(이 곡만을 중지시킨다.)(작은 부분)
    }
    
    @Override
    /* 부모 클래스에 있는 메소드를 자식 클래스에서 재정의 하는 것입니다.
     * 자식 클래스가 부모 클래스를 상속하여 자식에게 없는 메소드를 호출하면 부모클래스에 가서 해당 메소드를 찾게 됩니다.
     * 만약 부모 클래스의 메소드를 자식클래스에서 동일한 이름으로 다시 재정의 하면 부모 클래스의 메소드를 찾지 않고
     * 자식 클래스의 메소드를 호출하게 됩니다. 이것을 오버라이드(재정의)라고 합니다.    */
    public void run() { // Thread를 사용시 반드시 사용해야되는 run
        try {
            do {
                player.play(); // 곡을 실행시킨다.
                fis = new FileInputStream(file); //해당 음악파일을 불러온다
                bis = new BufferedInputStream(fis); // 불러온 음악파일을 버퍼에 담는다
                player = new Player(bis);
            } while(isLoop); // isLoop이 true값이라면 무한반복
        }catch(Exception e) {
            System.out.println(e.getMessage()); //오류 메세지 전송
        }
        
    }
}
