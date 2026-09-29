package com.ghanshyam.logic;

import java.util.Scanner;

import com.ghanshyam.ConnectionFactory.Curd;
import com.ghanshyam.dto.DTO;

public class Logic {
	private final int INSERT_DATA = 1;
	private final int READ_DATA = 2;
	private final int UPDATE_DATA = 3;
	private final int DELETE_DATA = 4;
	private final int TEST_DATA = 5;
	private final int EXIT_DATA = 6;
	private static final int MAX_ATTEMPTS = 3;

	private String user;

	private String password;

	private String fullname;

	private String address;

	private int salary;
	private Curd cu;

	public Logic() {
		cu = new Curd();
	}

	public void DoStart() {
		Scanner sc = new Scanner(System.in);

		int attempts = 0;
		while (true) {
			System.out.println("=========MENU========");
			System.out.println("Press-1 : INSERT DATA");
			System.out.println("Press-2 : READ DATA");
			System.out.println("Press-3 : UPDATE DATA");
			System.out.println("Press-4 : DELETE DATA");
			System.out.println("Press-5 : Test DATA");
			System.out.println("Press-6 : EXIT\n");

			System.out.println("Enter Our Choice:");
			int choice = 0;

			try {
				choice = sc.nextInt();
			} catch (Exception e) {
				System.out.print("Enter Valid Number! Kindly Enter Number 1 to 6:\n");
				sc.nextLine();
				attempts++;
				if (attempts >= MAX_ATTEMPTS) {
					System.out.println("You have riched the Limit:");
					sc.close();
					return;
				}
				continue;
			}

			if (choice < 1 || choice >= 6) {

				attempts++;
				if (attempts >= MAX_ATTEMPTS) {
					System.out.println("You have riched the Limit:");
					sc.close();
					return;
				}
			}

			switch (choice) {
			case INSERT_DATA:
				System.out.println("======INSERT DATA======");
//                	    System.out.println("Enter ID;");
//                	     int id = sc.nextInt();

				System.out.println("Enter UserName:");
				user = sc.next();

				System.out.println("Enter Password:");
				password = sc.next();

				sc.nextLine();
				System.out.println("Enter Full Name:");
				fullname = sc.nextLine();

				System.out.println("Enter Address:");
				address = sc.nextLine();

				System.out.println("Enter Salary:");
				salary = sc.nextInt();

				DTO dt = new DTO(user, password, fullname, address, salary);

				cu.insert(dt);
				break;
			case READ_DATA:
				System.out.println("Enter UserName:");
				user = sc.next();

				System.out.println("Enter Password:");
				password = sc.next();
				cu.read(user,password);
				System.out.println("READ DATA");
				break;
			case UPDATE_DATA:
				System.out.println("Enter UserName:");
				user = sc.next();

				System.out.println("Enter Salary:");
				salary = sc.nextInt();
				  
				cu.update(user,salary);
				
				System.out.println("UPDATE DATA");
				break;
			case DELETE_DATA:
				System.out.println("Enter UserName:");
				user = sc.next();
				
				cu.delete(user);
				System.out.println("DELETE DATA");
				break;
				
			case TEST_DATA:
				String sql="SELECT * FROM employee2 ";
				String sql2 = "INSERT INTO employee2" + "(USERNAME, PASSWORD, FULLNAME, ADDRESS, SALARY) " + "VALUES ('abc','abc123','abcd','asdff',21345)";
				
				System.out.println("p1-select Quary \n p2-inset data");
				choice =sc.nextInt();
				if(choice==1) {
					cu.test(sql);
				}else {
					cu.test(sql2);
				}
				break;
			case EXIT_DATA:
				System.out.println("EXIT");
				sc.close();
				break;

			}
		}
	}
}
