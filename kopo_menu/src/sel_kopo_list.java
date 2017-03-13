import java.util.Scanner;
public class sel_kopo_list {

	String list[][] = { {"대구캠퍼스", "http://www.kopo.ac.kr/daegu/content.do?menu=4175"}, 
			{"구미캠퍼스", "http://www.kopo.ac.kr/gumi/content.do?menu=4941"}, 
			{"달성캠퍼스", "http://www.kopo.ac.kr/dalseong/content.do?menu=5752"}, 
			{"포항캠퍼스", "http://www.kopo.ac.kr/pohang/content.do?menu=6012"}, 
			{"영주캠퍼스", "http://www.kopo.ac.kr/yeongju/content.do?menu=6229"}};
	
	// 그만해라 변수
	int pleasestop = 0;
	
	// 보안 관련 스캐너 변수 설정
	private Scanner selnum;
	
	// 스캐너 받기
	int sel_kopo_scanner()
	{
		selnum = new Scanner(System.in);

		// 문자열로 받아오는 경우 튕겨내는 코드
		while (!selnum.hasNextInt())
		{
			// 문자열이면 버리고 재입력 출력
			selnum.next();
			System.out.print("1~6번 숫자로 다시 선택하세요 :-)\n재입력:");
		}
		// 정수형이면 리턴으로 값 넘겨주기
		return selnum.nextInt();
		// 기존 소스
		/*
		sc = new Scanner(System.in);
		int selnum = sc.nextInt();
		return selnum;
		*/
	}
	
	// 폴리텍 Ⅵ대학 리스트 정보를 불려오기 위한 메소드 sel_kopo()
	String sel_kopo()
	{
		// 폴리텍 Ⅵ대학 리스트 고르는 안내 멘트
		System.out.println("원하는 번호를 입력 하세요.");
		System.out.println("현재 선택이 가능한 학교는 한국폴리텍대학 Ⅵ대학입니다. (다른 캠퍼스도 업데이트 예정)");
		System.out.println("토요일, 일요일 식단은 제공하지 않습니다.");
		System.out.println("1: 대구캠퍼스\n2: 구미캠퍼스\n3: 달성캠퍼스\n4: 포항캠퍼스\n5: 영주캠퍼스\n6: 프로그램 종료");
		// **캠퍼스 정보
		info_print sel_info = new info_print();
		// 학교 리스트 및 학교 URL 선택
		switch(sel_kopo_scanner())
		{
		// list[0][0] = 대구 캠퍼스, return list[0][1] = 대구 URL 넘겨주기
		case 1: sel_info.print(list[0][0]); return list[0][1];
		case 2: sel_info.print(list[1][0]); return list[1][1];
		case 3: sel_info.print(list[2][0]); return list[2][1];
		//case 3: System.out.println("급식 데이터를 제공하지 않아서 선택이 불가능합니다."); sel_kopo(); break;
		case 4: sel_info.print(list[3][0]); return list[3][1];
		case 5: sel_info.print(list[4][0]); return list[4][1];
		// 프로그램 종료 및 안내 멘트
		case 6: System.out.println("프로그램을 종료합니다. 감사합니다. :-)"); System.exit(0);
		// 틀리면 재귀(?) 방식으로 다시 불려오기 및 여러번 틀리면 빡침
		default: pleasestop++;
		if(pleasestop == 10) {System.out.println("장난 그만해!!!\n장난 그만해!!!\n장난 그만해!!!\n장난 그만해!!!\n장난 그만해!!!\n");}
		if(pleasestop == 15) {System.out.println("장난치지마!!!\n장난치지마!!!\n장난치지마!!!\n장난치지마!!!\n장난치지마!!!\n");}
		if(pleasestop == 20) {System.out.println("빼애액빼애액빼애액빼애액빼애액빼애액 프로그램을 강제 종료합니다!!!"); System.exit(0);}
		System.out.println("1~6번 숫자로 다시 선택하세요.");
		sel_kopo(); break;
		}
		// null 에러 방지용 기본값
		return list[0][1];
	}
}