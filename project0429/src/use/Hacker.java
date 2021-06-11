//Account 와는 다른 패키지에서 접근 제한을 실습해본다!!
package use;
import bank.Account;

class Hacker{
	public static void main(String[] args){
	//은행 계좌를 메모리에 올려놓고, 맘대로 장난쳐보자
	//어카운트가 없음  루트가 없다.
	//어카운트는 클래스 밑 뱅크 밑에있다. 그래서 위에 import에 명시
	Account acc = new bank.Account();
	
	//아래의 코드는 패키지 위치와 상관없이 balance 변수 자체가 private이기 때문에
	//그 어떤 누구도 접근이 불가..
	//System.out.println("현재 "+acc.master+"이 보유한 잔고는"+acc.balance);
	
	//은행명, 계좌주, 계좌번호 접근 가능? 여기까지,, 불가능 다른 패키지여서
	System.out.println("은행명 : "+acc.bankName);
	System.out.println("계좌주 : "+acc.master);
	System.out.println("계좌번호 : "+acc.num);

	}
}