package Application;

import java.util.Locale;
import java.util.Scanner;

import Model.entities.Account;
import Model.exceptions.DomainException;

public class Program_Account {

	public static void main(String[] args) {
		// Account Program
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
		System.out.println("Enter account data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		System.out.print("Holder: ");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance: ");
		double balance = sc.nextDouble();
		System.out.print("WithDraw Limit: ");
		double withDraw = sc.nextDouble();
		Account acc = new Account(number, holder, balance, withDraw);
		
		System.out.println();
		System.out.print("Enter amount for withdraw: ");
		acc.withdraw(sc.nextDouble());
		System.out.println(acc.toString());
		}
		
		catch(DomainException e) {
			System.out.println("WithDraw error: " + e.getMessage());
		}
		catch(RuntimeException e) {
			System.out.println("Unexpected error: ");
		}
		System.out.println();
		sc.close();
	}

}
