package com.te.essportal;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("• Press 1 to register employee\n\n");
			System.out.println("• Press 2 to login\n\n");
			System.out.println("• Press 3 to Exit\n\n");
			int key = sc.nextInt();
			Actions Act = new Actions();
			switch (key) {
			case 1:
				Act.register();
				break;
			case 2:
				Act.login();
				break;
			case 3:
				System.exit(1);
				break;
			default:
				System.out.println("Enter Correct Option");
				break;
			}
		}
	}
}
