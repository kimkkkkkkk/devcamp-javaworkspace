package animal.birds;
/*아래 코드의 상속관계가 같은 종류가 될 수 있다는 근거!!
1) 자바에서는 기본 자료형들의 유형은 크게 3가지로 분류
	문자, 숫자, 논리값
	특히 숫자 (byte, short, int, long, float, double)와 char(0포함 양수) 들 간에는
	서로 같은 종류의 자료형으로 보고 형변환이 가능하다!!
2) 자바의 자료형은 총 4가지로서, 객체자료형도 자료형이다!!

3) 결론 : 2번과 같이 객체자료형도 자료형이라면, 기본 자료형들간에 적용되었던 객체간 형변환이
			객체자료형에도 적용되어야 한다!!
			왜? 객체 자료형도 자료형이니까!!!!!!!!!!!!!!!!!!!!!!!!!1
4) 문제?
	사용자가 만든 자료형인 클래스간에도 같은 종류의 자료형이 있을 수 있는가?
	있다!! 바로 상속을 이용하면 부모, 자식간의 관계가 형성되고, 부모, 자식 간의 관계를 우리는
	같은 종류의 자료형으로 볼 수 있다...
*/




// Duck을 정의하자 
public class Duck extends Bird{ 
	//						is a  앞으로 상속에서는 is a가 보여야함 오리는 새다 흑인은 사람이다. (같은 자료형이다)
	// extends Bird (상속관계 만들기)
	//덮어쓴다 안덮어쓴다? 안덮어쓰고 새로운 생성자가 생김
	String name="난 오리";
	String color;

	public Duck(String color){ // 생성자 만듬!!
		super(color); // 생략되어 있던걸 내보내야함!!!!! 배웠짢아!!!!!!
	}

	//수영이 가능함
	public void canSwim(){
		System.out.println("수영을 잘합니다");
	}
}