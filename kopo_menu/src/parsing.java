import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class parsing {
	void parsing_call() throws IOException
	{
		sel_kopo_list selnum = new sel_kopo_list();
		
		// 평일 및 아침, 점심, 저녁 배열 선언
		String weekday[] = { "월요일", "화요일", "수요일", "목요일", "금요일" };
		String sigdan[] = { "아침", "점심", "저녁" };
		
		// 클래스 sel_kopo_list에서 선택한 폴리텍 링크 파싱
		Document doc = Jsoup.connect(selnum.sel_kopo()).get();
		
		// 식단표 날짜  출력 예- (2016-11-28 ~ 2016-12-04)
		for (Element week : doc.select("span.week"))
		{
			System.out.println("                         "+week.data().substring(23, 27) + "-" + week.data().substring(27, 29) + "-" + week.data().substring(29, 31) + " ~ " + week.data().substring(58, 62) + "-" + week.data().substring(62, 64) + "-" +week.data().substring(64, 66));
		    // System.out.println("                         "+week.data().substring(23, 27) + "-" + week.data().substring(27, 29) + "-" + week.data().substring(29, 31) + " ~ " + week.data().substring(58, 62) + "-" + week.data().substring(62, 64) + "-" +week.data().substring(64, 66));
		}
		
		// 아침, 점심, 저녁 출력
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("            아침\t\t\t     점심\t\t\t\t     저녁");
		
		// 아침, 점심 , 저녁 식사 시간 출력 예- (07:50 ~ 08:30		     12:00 ~ 13:30		     17:30 ~ 18:30)
		for(int i = 0; i < 3; i++)
		{
			for (Element tbl_table_time : doc.select("table.tbl_table.time"))
			{
			    System.out.print(tbl_table_time.getElementsByTag("td").get(i).text());
			}
			System.out.print("\t\t     ");
		}
				
		//Elements menu = doc.select("table.tbl_table.menu tbody");
		
		// 월요일 ~ 금요일 아침, 점심, 저녁 식단표 출력
		for(int i = 0; i < 5; i++)
		{
			System.out.println("\n----------------------------------*" + weekday[i] + "*----------------------------------");
			for(int j = 0; j < 3; j++)
			{
				//for (Element e : menu)
				for (Element e : doc.select("table.tbl_table.menu tbody"))
				{
				    System.out.println(sigdan[j] + " - " + e.getElementsByTag("tr").get(i).getElementsByTag("td").get(j+1).text());
				}
			}
			System.out.println("--------------------------------------------------------------------------");
		}
	}
}
