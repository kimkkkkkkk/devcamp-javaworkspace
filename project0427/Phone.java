/*정말 중요함!*/
class Phone{ // 멤버변수는 3개, 멤버 메서드는 1개

	int price=5000; 
	String name="G21";
	static String company="Samsung"; // static 인 '고정적인' 이란 뜻의 수정자라 불린다
													// static 으로 선언된 변수, 메서드는 new할때
													//해당 인스턴스에 소속되지 않는다.. 따라서 원본 클래스에
													//존재하게 된다.. 따라서 static에 선언된 멤버변수를
													//특히나 클래스 변수라 한다.
	
	public void ring(){
		System.out.println("벨이 울려요");
	}
	public static void main(String[] args){
		//String c= Phone.company; //클래스가 보유한 클래스 변수는 이렇게 접근하는 거다!!
		Phone p1 = new Phone();
		p1.company="LG";

		company="Motor";

		Phone p2 = new Phone();
		p2.company="Sambo";

		System.out.println(p1.company);

	} // 실행부
}
//static이 있으면 공유 뿐만 아니라 전역변수로도 쓰일 수 있다.
//Phone p1은 new Phone()을 만나면 스택으로 p1이라는 스택이 생김
// 2~14번줄까지 new를 하여 heap으로 감 
// company는 올라가려다가 안올라감 (static : 고정됨)
// company이라는 변수는 뉴할때 인스턴스 소속일까 클래스 원본 소속일까
// (여기서 인스턴스란 new 에 의해서 딸려 온 것들을 인스턴스 변수, 인스턴스 메서드라 한다)
// 클래스 원본 소속이 된다 컴퍼니의 위치는 언제나 원본의 소속이 되어있기 때문에
// 컴퍼니를 접근하기 위해서 new할필요가 없어짐 왜 heap에 없으니까
// 클래스가 원본에 있잖아..  컴퍼니라는 녀석은 main도 static으로 되어 있음 15번줄
// 그래서 같은 클래스에 들어있어서  같은 static이니 접근이 가능하고, 인스턴스로 접근이 안됨
// ------두가지 방법으로 접근 가능---------------------------
// 1) 메인과 같이 있다고 전제하지 말고 company는  원본꺼 접근할때 그냥
// 15번줄 아래 String c= Phone.company; 클래스가 보유한 클래스변수는 이렇게 접근
// 2) 만약 main이 다른 창에 있다면 그떄는 폰이 가진 company로 말할 수 있다.


//누군가 p1 new를 stack에 올리면 stack 에 올라가고
// new를 하면 가격, 이름이 heap에 올라감
//하지만 company는 static으로 올라갈 수 없음 고정됨 이것을
// 멤버 변수들중 클래스 소속이라 하여 이러한 변수를 클래스 변수라 함

