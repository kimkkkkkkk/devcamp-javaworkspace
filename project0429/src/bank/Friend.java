package bank;

class Friend{
	
	public static void main(String[] args){
			Account acc = new Account(); // 앞에 아무것도 명시하지 않으면 현재 디렉토리부터 조사가 들어감
			System.out.println("친구의 조작 전 잔고는 "+acc.getBalance()); // private이어서 접근 못함, 
			//account에서 메서드를 통해 접근하고 acc.balance -> acc.getbalnce()로 변경
			//acc.balance = acc.balance+8000; // 은행직원인 friend는 접근해야하기 때문에
			//변수에 대한 직접접근을 하지말고, 메서드 호출로 데이터를 변경해보자.
			acc.setBalance(1500000); //직접 접근 한 것이기 아니기때문에 실행하면 증액된 금액을 볼 수 없다.

			System.out.println("친구의 조작 후 잔고는 "+acc.getBalance());
			//실행 할땐 현재 디렉토리가 어디 들어갔는지 (bank에 있음) 
			


			//현재 Friend 클래스는 Account와 같은 패키지에 있으므로, Account가 보유한
			//defaul 접근제한이 걸려 있는 모든 변수에 맘대로 접근이 가능하다!!
			System.out.println("은행명 : "+acc.bankName);
			System.out.println("계좌주 : "+acc.master);
			System.out.println("계좌번호 : "+acc.num);

	}
}