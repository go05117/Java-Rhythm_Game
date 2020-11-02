package dynamic_beat_15;

public class Beat {
	private int time;
	private String noteName;
	
	// 우클릭 후 source에서 getters & setters로 만든다.
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public String getNoteName() {
		return noteName;
	}
	public void setNoteName(String noteName) {
		this.noteName = noteName;
	}
	
	// 우클릭 후 source - constructor using fields에서 만든다.(생성자)
	public Beat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}
	
	
	
}
