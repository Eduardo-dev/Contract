package application;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException{
		Locale.setDefault(Locale.US);
		Scanner scan = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String department = scan.nextLine();
		System.out.println("Enter worker data: ");
		System.out.print("Name: ");
		String workerName = scan.nextLine();
		System.out.print("Level: ");
		String level = scan.nextLine();
		System.out.print("Base salary: ");
		double salary = scan.nextDouble();
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(level), salary, new Department(department));
		
		System.out.print("How many contracts to this worker? ");
		int workers = scan.nextInt();
		
		for (int i = 1; i<= workers; i ++) {
			System.out.println("Enter contract #" + i + " data: ");
			System.out.print("Date (DD/MM/YYYY): ");
			Date date = sdf.parse(scan.next());
			System.out.print("Value per hour: ");
			double value = scan.nextDouble();
			System.out.print("Duration (hours): ");
			int duration = scan.nextInt();
			HourContract contract = new HourContract(date, value, duration);
			worker.addContract(contract);
		}
			
			System.out.println();
			System.out.println("Enter month and year to calculate income (MM/YYYY): ");
			String monthAndYear = scan.next();
			int year = Integer.parseInt(monthAndYear.substring(3));
			int month =Integer.parseInt(monthAndYear.substring(0,2));
			
			System.out.println("Name: " + worker.getName()); 
			System.out.println("Department: " + worker.getDepartment().getName());
			System.out.printf("Income for %s: %.2f", monthAndYear, worker.income(year,month));
		
		scan.close();	
		}
				
		
	}



/*Enter department's name: Design
Enter worker data:
Name: Alex
Level: MID_LEVEL
Base salary: 1200.00
How many contracts to this worker? 3
Enter contract #1 data:
Date (DD/MM/YYYY): 20/08/2018
Value per hour: 50.00
Duration (hours): 20
Enter contract #2 data:
Date (DD/MM/YYYY): 13/06/2018
Value per hour: 30.00
Duration (hours): 18
Enter contract #3 data:
Date (DD/MM/YYYY): 25/08/2018
Value per hour: 80.00
Duration (hours): 10
Enter month and year to calculate income (MM/YYYY): 08/2018*/