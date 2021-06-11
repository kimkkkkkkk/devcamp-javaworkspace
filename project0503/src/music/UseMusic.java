package music;

class UseMusic{
	public static void main(String[] args){
	//추상클래스는 불완전하기에, 완전하게 되기 전에는 인스턴스를 생성할 수 없다.
	//자식이 부모를 구현할때 자식이 완성되어야 올라간다. 자식이 new 할때 올라간다.
	MusicPlayer mp = new MusicPlayer();
	}
}
