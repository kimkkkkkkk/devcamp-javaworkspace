package race;

//인간을 정의한다. ( 상위 객체일 수록 보편적 특징이 와야함)
public class Human{
	int IQ = 90;
	boolean hasName=true;
	/*
	public Human(){
	}
	생성자가 한개 (default)
	*/

	public Human(int IQ){
		this.IQ=IQ;
		System.out.println("Human의 초기화");

	}
	//생성자 오버로딩 ,부모에 매개변수 없는 생성자를 만든다
	public Human(){
	
	}

	public void speak(){
		System.out.println("말할 수 있다");
	}
	public void drive(){
		System.out.println("운전 할 수 있다");
	}
	
}