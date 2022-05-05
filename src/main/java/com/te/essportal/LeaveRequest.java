package com.te.essportal;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LeaveRequest {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Employee");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction trans = manager.getTransaction();
	
	 Leave_Info li = new Leave_Info();
	 
	Scanner sc = new Scanner(System.in);
	
	public void Leave(int id) {
		try {
		 li.setEmployee1_Id(id);
		 System.out.println("Enter the Date");
		 li.setLeave_Date(sc.next());
		 li.setLeave_Status("Pending");
		 trans.begin();
		 manager.persist(li);
		 trans.commit();
		}catch (Exception e) {
			System.out.println("-----Dupicalte Entry---");
		}
	 }
	
}
