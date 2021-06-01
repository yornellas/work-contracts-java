package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Department's name: ");
		String departmentName = sc.nextLine();
		
		System.out.println("ENTER WORKER DATA:");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmentName));
		
		
		System.out.print("How many contracts to this worker? ");
		int n = sc.nextInt();
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		for(int i = 0; i < n; i++) {
			System.out.println("Enter contract #" +(i + 1) +" data");
			System.out.print("Date (DD/MM/YYYY): ");
			Date contractDate = dateFormat.parse(sc.next());
			System.out.print("Value per hour: ");
			double valuePerHour = sc.nextDouble();
			System.out.print("Durtion (hours): ");
			int duration = sc.nextInt();
			
			HourContract contract = new HourContract(contractDate, valuePerHour, duration);
			
			worker.addContract(contract);
		}
		
		System.out.print("Enter month and year to calculate income: (MM/YYYY)");
		String monthAndYear = sc.next();
		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));
		System.out.println("Name: " +worker.getName());
		System.out.println("Department: " +worker.getDepartment().getName());
		System.out.println("Income for " +monthAndYear +": " +String.format("%.2f", worker.income(year, month)));
		
		sc.close();
	}

}
