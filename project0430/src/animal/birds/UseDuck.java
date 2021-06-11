package animal.birds;

class UseDuck{

	public static void main(String[] args){
		//오리 한마리를 메모리에 올리고, (인스턴스 생성)canSwin 메서드를 호출해보자
		Duck d = new Duck("white");
		d.canSwim();
		
		Bird b = new Bird();
		b=d; // 가능? 불가능? b=Bird, d=Duck, 
		//오리는 새다 큰거는 작은걸 담을 수 있다.
		//하지만 거꾸로는 안됨 d=b; 오리는 새가 아니다 즉 작은걸로 큰것을 담을 수 없다.
		//byte	short		int		 long : 숫자형은 서로 같은 종류의 자료형이다!!
		//즉 같은 종류의 자료형 이기에 서로 형변환이 가능하다!!!
		byte b=5;
		int k=b;
		
		// 객체형도 자료형이다..  숫자, 문자, 논리값, 객체자료형
	}
}