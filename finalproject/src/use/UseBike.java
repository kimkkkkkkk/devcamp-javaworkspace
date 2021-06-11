package use;
import traffic.Bike; //traffic 이전 디렉토리 경로는 클래스패스에서 참조
class UseBike{
	public static void main(String[] args){
		Bike b = new Bike(); 
		b.run();
		//new가 안되는 이유 바이크를 알수 없음 환경변수 만들어줘야함 클래스패스
		//컴퓨터 마다 디렉토리가 틀리기 떄문에 중립성을 지키기 위해서 위에 import 만들어주기
	}

}