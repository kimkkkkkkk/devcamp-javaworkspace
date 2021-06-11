/*잘 사용하지 않지만..*/
public class Desk {
	int x;
	static int y;

	//변수, 함수 여기서 변수 함수만 수행 할 수 있음
	// 굳이 반복문 포함하여 코드르수행하고 싶다면? 블럭을 만들 수 있다..
/*
	public void test(){
		for(int i=1;i<=10;i++){
			x+=i;
		}
	}
	*/

	{ //A
		for(int i=0;i<10;i++){
			x++;
		}
	}
	
	//인스턴스 초기화 블럭
	//이 클래스인 Desk로부터 인스턴스가 생성될 때마다, 아래의 코드가 실행
	//static 붙이면: static 초기화 블럭
	/*
	1) 인스턴스 초기화 블럭 : 해당 인스턴스가 생성될때 동작하는 코드 영역
								생성자의 역할과 비슷
	2) static 초기화 블럭 : 실행직전의 
	*/

	static { //B ,  클래스가 로드될때 동작한다!!실행시 동작한다!!
			//main 메서드 호출시 동작함!!
		for(int i=0;i<20;i++){
			y++;
		}
	}
	                              
	public static void main(String[] args){
		//System.out.println(x); //C 메모리 올라온적도 없고, static 영역에서 레퍼런스변수
		// 없이 x 를 접근할 수도 없다..
		int a=new Desk().x; //D  10
		System.out.println(a); //E 10
		System.out.println(y); //F 20
		
	}
}