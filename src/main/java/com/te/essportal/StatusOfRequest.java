package com.te.essportal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class StatusOfRequest {
	EntityManagerFactory factory = Persistence.createEntityManagerFactory("Employee");
	EntityManager manager = factory.createEntityManager();
	EntityTransaction trans = manager.getTransaction();
	Leave_Info status = new Leave_Info();

	public void getStatus(int id) {
		Query createQuery = manager.createQuery("from Leave_Info");
		List<Leave_Info> resultList = createQuery.getResultList();
//		System.out.println(resultList);
		for (Leave_Info leave_Info : resultList) {
			if(leave_Info.getEmployee1_Id()==id) {
					System.out.println(leave_Info);
			}
		}
	}
}
