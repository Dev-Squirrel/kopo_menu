import java.io.IOException;

public class Main{
	public static void main(String[] args) throws IOException {
		
		// parsing 클래스에 parsing_call 메서드 불려오기
		parsing call = new parsing();
		call.parsing_call();
		
		// 콘솔 프로그램 엔터 치면 종료
		System.out.println("엔터를 치면 프로그램이 종료됩니다.");
			try {
				System.in.read();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	}
}
