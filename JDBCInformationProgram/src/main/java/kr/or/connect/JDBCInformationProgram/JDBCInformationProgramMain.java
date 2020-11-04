package kr.or.connect.JDBCInformationProgram;
import java.util.Scanner;

import kr.or.connect.JDBCInformationProgram.dao.businesscardDao;
import kr.or.connect.JDBCInformationProgram.dao.businesscardInsert;
import kr.or.connect.JDBCInformationProgram.dto.businesscard;
public class JDBCInformationProgramMain {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("------------------------------------");
			System.out.println("1. 명함 입력");
			System.out.println("2. 명함 검색");
			System.out.println("3. 종료");
			System.out.println("------------------------------------");
			System.out.print("메뉴를 입력하세요. : ");
			
			int choice = scanner.nextInt();
			
			if(choice == 1) {
				System.out.println("이름을 입력하세요. : ");
				String name = scanner.next();
				System.out.println("전화번호를 입력하세요. : ");
				String phone = scanner.next();
				System.out.println("회사를 입력하세요. : ");
				String company = scanner.next();
				
				businesscardInsert b_insert = new businesscardInsert(name, phone, company);
				System.out.println("입력이 완료되었습니다.");
			}
			else if(choice == 2) {
				System.out.println("검색할 이름을 입력하세요. (like검색) : ");
				String name = scanner.next();
				businesscardDao dao = new businesscardDao();
				businesscard b_card = dao.getName(name);
				System.out.println(b_card);			
			}
			else if(choice == 3) {
				System.out.println("종료합니다.");
				break;	
			}
			else System.out.println("잘못된 입력입니다.");
		}
	}
}
