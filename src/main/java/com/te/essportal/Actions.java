package com.te.essportal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Actions {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Employee");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction trans = manager.getTransaction();

	Scanner sc = new Scanner(System.in);

	LeaveRequest leReq = new LeaveRequest();
	Leave_Info lefo = new Leave_Info();
	Employee_Info emp_info = new Employee_Info();
	PermissionGrant grant = new PermissionGrant();
	StatusOfRequest status = new StatusOfRequest();

	public void register() {
		try {
			System.out.println("--------REGISTER-PAGE--------");
			System.out.println("Enter Employee Details:\n");
			System.out.println("Enter Employee ID:");
			emp_info.setEmployee_Id(sc.nextInt());
			System.out.println("Enter Employee Name");
			emp_info.setName(sc.next());
			System.out.println("Enter Employee Type");
			emp_info.setType(sc.next());
			System.out.println("Enter Employee Mail_ID");
			emp_info.setEmail(sc.next());
			System.out.println("Enter Employee Password");
			emp_info.setPass(sc.next());
			trans.begin();
			manager.persist(emp_info);
			trans.commit();
			System.out.println("Registerd Successfully");
		} catch (Exception e) {
			System.out.println("Enter Correct Format / key");
		}

	}

	public void login() {
		System.out.println("-----LOGIN PAGE------");
		System.out.println("Enter Employee Details");
		System.out.println("Enter Employee ID");
		int id = sc.nextInt();
		System.out.println("Enter Employee Password");
		String pass = sc.next();
		Query query = manager.createQuery("select Employee_Id from Employee_Info");
		@SuppressWarnings("unchecked")
		List<Employee_Info> res = query.getResultList();
		@SuppressWarnings("unlikely-arg-type")
		boolean contains = res.contains(id);
		if (contains) {
			Employee_Info find = manager.find(Employee_Info.class, id);
			String cross = find.getPass();
			if (cross.equals(pass)) {
				String type = find.getType();
				if (type.equals("employee")) {
					int choice;
					do {
						System.out.println("1.Request For the Leave");
						System.out.println("2.Show All The leave Request");
						System.out.println("3.Exit From this Part");
						choice = sc.nextInt();
						switch (choice) {
						case 1:
							leReq.Leave(id);
							break;
						case 2:
							status.getStatus(id);
							break;
						case 3:
							System.out.println("welcome");
							break;
						default:
							break;
						}
					} while (choice != 3);
				} else if (type.equals("manager")) {
					System.out.println("welcome Manager. " + find.getName());
					int choice;
					do {
						System.out.println("1.Show All The leave Request");
						System.out.println("2.Approve/Reject the Request");
						System.out.println("3.Exit the manager operation");
						choice = sc.nextInt();
						switch (choice) {
						case 1:
							grant.show();
							break;
						case 2:
							grant.grant();
							break;
						case 3:
							System.out.println("Welcome");
							break;
						default:
							System.out.println("Enter the Correct choice");
							break;
						}
					} while (choice != 3);
				}
			} else {
				System.out.println("Password is incorrect");
			}
		} else {
			System.out.println("Employee Cannot Be Recognized By Admin");
		}
	}
}
