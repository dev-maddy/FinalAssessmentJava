package com.te.essportal;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class PermissionGrant {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Employee");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction trans = manager.getTransaction();
	Scanner sc = new Scanner(System.in);
	Leave_Info leaf = new Leave_Info();

	public void show() {
		Query createQuery = manager.createQuery("from Leave_Info");
		@SuppressWarnings("unchecked")
		List<Leave_Info> res = createQuery.getResultList();
		for (Leave_Info leave_Info : res) {
			System.out.println(leave_Info);
		}
	}

	public void grant() {
		try {
		System.out.println("Enter the Emplpoyee Id To Approve/Reject Request!");
		int id = sc.nextInt();
		Query createQuery = manager.createQuery("select Employee1_Id from Leave_Info");
		@SuppressWarnings("unchecked")
		List<Employee_Info> res = createQuery.getResultList();
		@SuppressWarnings("unlikely-arg-type")
		boolean contains = res.contains(id);
		if (contains) {
			System.out.println("Enter your Decision");
			Leave_Info find = manager.find(Leave_Info.class, id);
			find.setLeave_Status(sc.next());
			trans.begin();
			manager.persist(find);
			trans.commit();
			System.out.println("--------Leave Status Updated By the Manager------");
		} else {
			System.out.println("-----Employee_ID is Not Found--------");
		}}catch (Exception e) {
			System.out.println("Employee has Already Applied For Leave");
		}
	}
}
