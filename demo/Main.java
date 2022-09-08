package com.sbs.example.demo;
import java.util.Scanner;

public class Main {

	
		public static void main(String[] args) {
			
				Scanner scan = new Scanner(System.in);
				DBUTil db = new DBUTil();
				
				
				while(true) {
					
						System.out.print("명령어를 입력해주세요 : ");
						String cmd = scan.nextLine();
						
						if(cmd.equals("add")) {
								System.out.println("========= 주소록 등록 =========");
								System.out.print("이름 : ");
								String name = scan.nextLine();
								
								System.out.print("주소 :");
								String address = scan.nextLine();
								
								
								System.out.print("전화번호 :");
								String phone = scan.nextLine();
								
								db.insertAddress(name, address, phone);
								System.out.println("주소록 등록 완료.");
								
						}
							
				}
				
				
		}
}
