package dynamic_beat_15;

public class Beat {
	private int time;
	private String noteName;
	
	// ��Ŭ�� �� source���� getters & setters�� �����.
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
	
	// ��Ŭ�� �� source - constructor using fields���� �����.(������)
	public Beat(int time, String noteName) {
		super();
		this.time = time;
		this.noteName = noteName;
	}
	
	
	
}
