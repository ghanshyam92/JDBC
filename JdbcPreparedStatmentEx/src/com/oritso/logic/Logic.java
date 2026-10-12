package com.oritso.logic;

import java.util.Scanner;

import com.oritso.ConectionFactory.OprationMethod;
import com.oritso.dto.DtoEx;

public class Logic {

	private final int ISERT_DATA = 1;
	private final int UPDATE_DATA = 2;
	private final int READ_DATA = 3;
	private final int DELETE_DATA = 4;
	private final int TEST_DATA = 5;
	private final int EXIT = 6;
	private static final int MAX_ATTEMPTS = 3;
	private String Department;
	private String Name;
	private int RollNo;
	private String Section;

	private OprationMethod op;

	public Logic() {
		op = new OprationMethod();
	}

	public void start() {
		Scanner sc = new Scanner(System.in);

		int attempt = 0;
		while (true) {

			System.out.println("==========MENUE=========");

			System.out.println("PRESS: 1 INSERT DATA");
			System.out.println("PRESS: 2 UPDATE DATA");
			System.out.println("PRESS: 3 READ DATA");
			System.out.println("PRESS: 4 DELETE DATA");
			System.out.println("PRESS: 5 TEST DATA");
			System.out.println("PRESS: 6  Exit\n");

			System.out.println("Enter Our Choise:");
			int Choise = 0;

			try {
				Choise = sc.nextInt();
			} catch (Exception e) {
				System.out.print("Enter Valid Number! Kindly Enter Number 1 to 6:\n");
				sc.nextLine();
				attempt++;
				if (attempt > MAX_ATTEMPTS) {
					System.out.println("You have to riched the limit:");
					sc.close();
					return;
				}

			}

			if (Choise < 1 || Choise > 6) {
				System.out.println("Plese Enter valid mumber:");
				attempt++;
				if (attempt > MAX_ATTEMPTS) {
					System.out.println("You have to riched the limit:");
					sc.close();
					return;
				}
				continue;
			}

			switch (Choise) {
			case ISERT_DATA:
				System.out.println("INSERT DATA");
				System.out.println("Enter out Department");
				Department = sc.next();

				sc.nextLine();
				System.out.println("Enter Your Name:");
				Name = sc.nextLine();

				System.out.println("Enter Roll Number:");
				RollNo = sc.nextInt();

				System.out.println("Enter Section:");
				Section = sc.next();

				DtoEx dt = new DtoEx(Department, Name, RollNo, Section);

				op.Insert(dt);
				break;
			case UPDATE_DATA:
				System.out.println("Enter Roll Number:");
				RollNo = sc.nextInt();

				sc.nextLine(); 

				System.out.println("Enter Your Name:");
				Name = sc.nextLine();

				op.update(RollNo, Name);

				System.out.println("UPDATE DATA");
				break;
			case READ_DATA:
				sc.nextLine();
				System.out.println("Enter Your Name:");
				Name = sc.nextLine();

				
				System.out.println("Enter Roll Number:");
				RollNo = sc.nextInt();
				op.Read(Name, RollNo);
				
				System.out.println("READ DATA");
				break;
			case DELETE_DATA:
			    sc.nextLine();
				System.out.println("Enter Your Name:");
				Name = sc.nextLine();			
				op.Delete(Name);
				System.out.println("DELET DATA");
				break;
				
			case TEST_DATA:
				String sql="SELECT * FROM stude";
				String sql2 = "INSERT INTO stude" + "(DEPARTMENT,NAME,ROLLNO,SECTION)" + "VALUES ('abc','abc123',333,'a')";
				
				System.out.println("p1-select Quary \n p2-inset data");
			int	choice =sc.nextInt();
				if(choice==1) {
				op.test(sql);
				}else {
					op.test(sql2);
				}
				break;
			case EXIT:
				System.out.println("EXIT");
				sc.close();
				break;

			}
		}

	}
}
