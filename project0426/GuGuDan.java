/*이중 포문으로 구구단 출력*/
class GuGuDan{
	public static void main(String[] args) {

		for(int i =1;i<=9;i++){
			for(int a=1;a<=9;a++){
				System.out.println(a"*"+i+"="+a*i);
			}
			System.out.println();
		}
	}
}
