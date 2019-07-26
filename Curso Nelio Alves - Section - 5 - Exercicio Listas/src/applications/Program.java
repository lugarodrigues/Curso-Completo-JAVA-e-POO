package applications;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.Employee;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many employees will be registered? ");
		int n = sc.nextInt();
		
		List<Employee> list = new ArrayList<>();
			
		for (int i = 1; i <= n; i++) {
			
			System.out.println("Employee #" + i + ":");
			System.out.print("ID: ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Salary: ");
			double salary = sc.nextDouble();
			
			list.add(new Employee(id, name, salary));
		}
		
		System.out.print("Enter the employee that will have salary increase: ");
		int incid = sc.nextInt();
		Employee emp = list.stream().filter(x -> x.getId() == incid).findFirst().orElse(null);
		
		if (emp == null) {
			System.out.println("This ID does not exist!");
		}
		else {
			System.out.print("Enter the porcentage: ");
			double porcentage = sc.nextDouble();
			emp.increaseSalary(porcentage);
		}
		
		System.out.println("List of employees:");
		for (Employee obj : list) {
			System.out.println(obj);
		}
		
		sc.close();
	}

}
