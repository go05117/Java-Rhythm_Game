package dynamic_beat_11;

public class Track {
	private String titleImage; // ���� �κ� �̹���
	private String startImage; // ���� ���� â ǥ�� �̹���
	private String gameImage; // �ش� ���� �������� �� ǥ�� �̹���
	private String startMusic; // ���� ����â ����
	private String gameMusic; // �ش� ���� �������� �� ����
	
	// Track ��Ŭ�� sourse - generals getters & setters - selected all - generate
	public String getTitleImage() {
		return titleImage;
	}
	public void setTitleImage(String titleImage) {
		this.titleImage = titleImage;
	}
	public String getStartImage() {
		return startImage;
	}
	public void setStartImage(String startImage) {
		this.startImage = startImage;
	}
	public String getGameImage() {
		return gameImage;
	}
	public void setGameImage(String gameImage) {
		this.gameImage = gameImage;
	}
	public String getStartMusic() {
		return startMusic;
	}
	public void setStartMusic(String startMusic) {
		this.startMusic = startMusic;
	}
	public String getGameMusic() {
		return gameMusic;
	}
	public void setGameMusic(String gameMusic) {
		this.gameMusic = gameMusic;
	}
	
	// ������ �߰� : track�� �̿��ؼ� ���ο� ������ ������� �� �ѹ��� ���� �������� �ʱ�ȭ���ִ� ����� �ϴ� �޼ҵ�
	// Track ��Ŭ�� sourse - generals constructor using fields - selected all - generate
	public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic) {
		super();
		this.titleImage = titleImage;
		this.startImage = startImage;
		this.gameImage = gameImage;
		this.startMusic = startMusic;
		this.gameMusic = gameMusic;
	}
	
	

}
