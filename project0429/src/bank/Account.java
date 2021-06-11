package bank;

//계좌를 정의해본다!!
//자바는, 클래스간 서로 사용이 가능하므로 보안상 뜻하지 않았던 문제가 발생
//할수 있기 때문에 이를 보완하기 위해 접근제한자는 보안처리를 지원한다..
//자바의 보안 처리는 다음과 같이 총 4단계로 구성된다. (접근제한)
/*
(공개)		상속관계 or 같은패키지		같은패키지만			나의 멤버만 접근가능
public			< protected			< default			< private

default는 무조건 같은 패키지만 있어야 쓰게해줌, 개발자가 아무것도 명시 하지 않으면 default 우리가 쓰고 있는거 다 default는 
private : 그다음 강력한거 오로지 나만 쓸 수 있음
*/
public class Account{ // 하나의 인스턴스 안에 들어있는 것들은 멤버라고 불림
	private String bankName="기업은행";
	private String master="배트맨"; //아무것도 명시되어 있지 않아서 default가 적혀있는 거고 
	private int balance=5000; // 멤버 메서드만 이 변수를 접근 할 수 있다..
	private String num="084-45678-01"; //연산목적, 하이픈 : 0을 인정받기 위해서는 int 가 아닌 String으로 가야함
/*public void test(){
		balance =6000; // 하나의 몸체 이 멤버 메서드가 그 위의 배트맨 메서드 접근 가능 하지만 외부는 접근 불가능

	}
*/

	// 데이터에 대한 직접 전근을 막았으나, 선의의 사용자도 사용하지 못하게 되었으므로,
	// 선의의 사용자가 접근할 수 있는 어떤 장치를 마련해주자!!
	public void setBalance(int balance){  // 메서드 (변경용, 값을 조작하기 위한 조작용)
		//반환형이 없기 때문에 앞에 void 그리고 공개해야하기 때문에 public
		//값을 조작할때는 setter으로 시작
		this.balance=balance; // 왼쪽:위에 있는 멤버메서드 그래서 this로 가리킴
	}
	//값을 반환받아 갈 수 있는 메서드 정의 (return이 있는 메서드)
	public int getBalance(){ // 직접 접근을 못하므로 메서드를 통해서 접근, (가져오기 위한 용도)
		//값을 가져올때는 getter을 씀
		return balance;
	}


	//데이터는 보호하고, 이 데이터를 사용할 수 있는 메서드를 제공해줘야 개발이 가능하므로
	//이렇게 습관화, 관례화된 메서드 정의 기법을 가리켜  setter,getter라 한다..
	//setter, getter는 메서드 정의 규칙이 있다..get변수, set변수
	//변수의 첫 철자는 대문자로 한다..

	//master
	public void setMaster(String master){
		this.master = master;
	}
	public String getMaster(){
		return master;
	}
	//bankname
	public void setBankName(String bankName){
		this.bankName = bankName;
	}
	public String getBankName(){
		return bankName;
	}
	//num
	public void setNum(String num){
		this.num = num;
	}
	public String getNum(){
		return num;
	}
}