package main;

import java.util.Scanner;
import visuals.Color;
import java.util.concurrent.TimeUnit;

public class Main 
{
	
	public static void main(String[] args) 
	{		
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Color.CYAN_BOLD + "\n= = = = Welcome to Atom. = = = = \n");
		System.out.println(
				"                  .----.\r\n"
				+ "      .---------. | == |\r\n"
				+ "      |.-\"\"\"\"\"-.| |----|\r\n"
				+ "      || 0   0 || | == |\r\n"
				+ "      ||   v   || |----|\r\n"
				+ "      |'-.....-'| |::::|\r\n"
				+ "      `\"\")---(\"\"` |___.|\r\n"
				+ "     /:::::::::::\\\" _  \"\r\n"
				+ "    /:::=======:::\\`\\`\\\r\n"
				+ "    `\"\"\"\"\"\"\"\"\"\"\"\"\"`  '-'"
				);
		System.out.println(Color.YELLOW + "\nWould you like to start the program? Y/N \r\n");
		
		Boolean programRunning = false;
		
		char answer = sc.nextLine().charAt(0);
		
		answer = Character.toUpperCase(answer);
		
		if (answer == 'Y') {
			programRunning = true;
			loadingScreen(1000, 30);
			clearScreen();
			}
		
		while (programRunning) {
			
			System.out.println(Color.GREEN_BOLD);
			System.out.println("Select an application. \n");
			System.out.println("1. Calculator");
			System.out.println("2. Area & Circumference");
			System.out.println("3. Area & Perimeter");
			System.out.println("4. Distance Unit Conversion");
			System.out.println("5. Exit");
			System.out.println(Color.RESET);
			char choice = sc.nextLine().charAt(0);
			
			switch (choice) {
			case '1':
				clearScreen();
				loadingScreen(1200, 32);
				clearScreen();
				calculator(sc);
				break;
			case '2':
				clearScreen();
				loadingScreen(1100, 68);
				clearScreen();
				areaCircumference(sc);
				break;
			case '3':
				clearScreen();
				loadingScreen(1300, 10);
				clearScreen();
				areaPerimeter(sc);
				break;
			case '4':
				clearScreen();
				loadingScreen(1500, 92);
				clearScreen();
				distanceUnitConversion(sc);
				break;
			case '5':
				programRunning = false;
				clearScreen();
				break;
			}
			
		}
		
		System.out.println("Program ended.");
		sc.close();
		
		
	}
	
	private static void loadingScreen(long waitTimeMS, int intervals) 
	{
		System.out.println(Color.CYAN);
		long waitTime = waitTimeMS / intervals;
		for (int i = 0; i <= intervals; i++) {
			float percent = i * 100/intervals;
			System.out.print("Loading... " + percent + "%\r");
			
			try {
				TimeUnit.MILLISECONDS.sleep(waitTime);
			}catch (Exception e) {}
			
		}
		System.out.println("\nLoad Finished " + Color.RESET);
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch (Exception e) {}
	}
	
	private static void clearScreen() {
		for (int i = 0; i<=100;i++) {
			System.out.println("\n");
		}
	}
	
	private static void calculator(Scanner sc) {
		
		Boolean running = true;
		
		char[] operations = {'+', '-', '*', '/'};
		
		char chosenOperation = '.';
		
		int num1 = 0;
		int num2 = 0;
		
		System.out.println(Color.CYAN + "Welcome to the Calculator. \n" + Color.RESET);
		
		while (running) {
			Boolean loop = true;
			
			while(loop) {
				System.out.println("Input the first number: ");
				String response = sc.nextLine();
				
				try {
					num1 = Integer.parseInt(response);
					loop = false;
				} catch (Exception e) {
					System.out.println(Color.RED_BACKGROUND + "Invalid input." + Color.RESET + "\n");
				}
				
			}
			
			loop = true;
			
			while(loop) {
				System.out.println("Input the second number: ");
				String response = sc.nextLine();
				
				try {
					num2 = Integer.parseInt(response);
					loop = false;
				} catch (Exception e) {
					System.out.println(Color.RED_BACKGROUND + "Invalid input." + Color.RESET + "\n");
				}
				
			}
			
			loop = true;
			
			while(loop) {
				System.out.println("Select an operation (+ , - , * , /): ");
				char response = sc.nextLine().charAt(0);
				
				for (char item : operations) {
					
					if (response == item) {
						chosenOperation = response;
						loop = false;
					}
					
				}
				
			}
			
			double result = 0.0;
			String e = "";
			
			switch (chosenOperation) {
			
			case '+':
				result = num1 + num2;
				e = "Sum: ";
				break;
			case '-':
				result = num1 - num2;
				e = "Difference: ";
				break;
			case '*':
				result = num1 * num2;
				e = "Product: ";
				break;
			case '/':
				if (num2 == 0) {
					System.out.println(Color.RED_BACKGROUND + "Cannot divide by 0." + Color.RESET);
					break;
				} else {
					result = num1/num2;
					e = "Quotient: ";
					break;
				}
			
			}
			
			
			System.out.println(Color.CYAN + e + result + Color.RESET + "\n");
			
			System.out.println("Would you like to continue? (Y/N)");
			char response = sc.nextLine().charAt(0);
			response = Character.toUpperCase(response);
			
			if (response == 'Y') {
				running = true;
			} else {
				running = false;
			}
			clearScreen();
		}
		
		
		
	}
	
	private static void distanceUnitConversion(Scanner sc) {
		boolean running = true;
		while (running) {
			
			String[] units = {"km", "m", "cm", "mm"};
			System.out.println(Color.GREEN + "Welcome to the distance unit converter." + Color.RESET);
			
			String unit1 = "";
			String unit2 = "";
			int unit1value = 0;
			
			
			
			boolean get = true;
			
			for (int r = 0; r < 2; r++) {
				get = true;
				if (r == 0) {System.out.println("Convert from: ");}
				else {System.out.println("Convert to: ");}
				
				for (int i = 0; i < 4; i++) {
					System.out.print(i+1 + ". "+ units[i] + " ");
				}
				
				if (r == 0) 
				{
					while (get) {
						unit1 = sc.nextLine();
						try {
							
							unit1 = units[Integer.parseInt(unit1)-1];
							get = false;
							
						}catch(Exception e) {
							System.out.println(Color.RED_BACKGROUND + "Invalid input." + Color.RESET);
						}
					}
					
					
				} else if (r == 1) 
				{
					unit2 = sc.nextLine();
					try {
						
						unit2 = units[Integer.parseInt(unit2)-1];
						get = false;
						
					}catch(Exception e) {
						System.out.println(Color.RED_BACKGROUND + "Invalid input." + Color.RESET);
					}
				}
				
			}
			
			get = true;
			
			while (get) {
				System.out.println("What is the value of the " + unit1 + "?");
				String e = sc.nextLine();
				
				try {
					unit1value = Integer.parseInt(e);
					get = false;
				}catch(Exception ex) {
					System.out.println(Color.RED_BACKGROUND + "Invalid input." + Color.RESET);
				}
				
			}
			
			System.out.println(unit1value + unit1 + " is converted to " + convertUnits(unit1, unit2, unit1value) + unit2);
			
			System.out.println("Would you like to continue? (Y/N)");
			char response = sc.nextLine().charAt(0);
			response = Character.toUpperCase(response);
			
			if (response == 'Y') {
				running = true;
			} else {
				running = false;
			}
			clearScreen();
		}
		
		
		
	}
	
	private static double convertUnits(String u1, String u2, int uv1) {
		
		double result = uv1;
		
		switch (u1) 
		{
		
		case "km":
			switch (u2) {
			case "km":
				result = result;
				break;
			case "m":
				result = result * 1000;
				break;
			case "cm":
				result = result * 100000;
				break;
			case "mm": 
				result = result * 1000000;
				break;
			}
			break;
		case "m":
			switch (u2) {
			case "km":
				result = result / 1000;
				break;
			case "m":
				result = result;
				break;
			case "cm":
				result = result * 100;
				break;
			case "mm": 
				result = result * 1000;
				break;
			}
			break;
		case "cm":
			switch (u2) {
			case "km":
				result = result / 100000;
				break;
			case "m":
				result = result / 100;
				break;
			case "cm":
				result = result;
				break;
			case "mm": 
				result = result * 10;
				break;
			}
			break;
		case "mm":
			switch (u2) {
			case "km":
				result = result / 1000000;
				break;
			case "m":
				result = result / 1000;
				break;
			case "cm":
				result = result / 10;
				break;
			case "mm": 
				result = result;
				break;
			}
			break;
		
		}
		
		return result;
	}
	
	
	private static void areaPerimeter(Scanner sc) {
		System.out.println(Color.YELLOW + "Welcome to the Area & Perimeter calculator." + Color.RESET);
		
		Boolean running = true;
		
		while(running) {
			System.out.println("Square [S] or Rectangle [R] ?");
			char response = Character.toUpperCase(sc.nextLine().charAt(0));
			
			if (response == 'S') 
			{
				double area = 0.0;
				double perimeter = 0.0;
				
				double size = 0.0;
				
				Boolean loop = true;
				
				while (loop) {
					System.out.println(Color.CYAN + "What is the size of the square?" + Color.RESET);
					
					String sizeAnswer = sc.nextLine();
					
					try {
						
						size = Double.parseDouble(sizeAnswer);
						loop = false;
						
					} catch (Exception e) {
						System.out.println(Color.RED_BACKGROUND + "Invalid input." + Color.RESET);
					}
				}
				
				area = size * size;
				perimeter = size * 4;
				
				System.out.println(Color.CYAN);
				
				System.out.println("Area: " + area);
				System.out.println("Perimeter: " + perimeter + Color.RESET);
				
				
				
			}
			else if(response == 'R')
			{
				double width = 0.0;
				double length = 0.0;
				
				double area = 0.0;
				double perimeter = 0.0;
				
				System.out.println(Color.CYAN + "What are the dimensions of the rectangle?" + Color.RESET);
				
				Boolean loop = true;
				
				while (loop) {
					System.out.println("Width: ");
					String s = sc.nextLine();
					
					try {
						width = Double.parseDouble(s);
						loop = false;
					}catch(Exception e) {
						System.out.println(Color.RED_BACKGROUND + "Invalid input." + Color.RESET);
					}
					
				}
				loop = true;
				while (loop) {
					System.out.println("Length: ");
					String s = sc.nextLine();
					
					try {
						length = Double.parseDouble(s);
						loop = false;
					}catch(Exception e) {
						System.out.println(Color.RED_BACKGROUND + "Invalid input." + Color.RESET);
					}
					
				}
				
				area = width * length;
				perimeter = (width + length) * 2;
				
				System.out.println(Color.CYAN);
				
				System.out.println("Area: " + area);
				System.out.println("Perimeter: " + perimeter + Color.RESET);
				
			}
			else 
			{
				System.out.println(Color.RED_BACKGROUND + "Inputted answer is not an option." + Color.RESET);
			}
			
			System.out.println("\nWould you like to continue? (Y/N)");
			char r = sc.nextLine().charAt(0);
			r = Character.toUpperCase(r);
			
			if (r == 'Y') {
				running = true;
			} else {
				running = false;
			}
			clearScreen();
			
		}
		
		
	}
	
	private static void areaCircumference(Scanner sc) {
		System.out.println(Color.YELLOW + "Welcome to the Area & Circumference calculator." + Color.RESET);
		
		Boolean running = true;
		
		while (running) {
			
			double radius = 0.0;
			
			double area = 0.0;
			double circumference = 0.0;
			
			Boolean loop = true;
			
			
			System.out.println(Color.CYAN + "What is the radius of the circle?" + Color.RESET);
			
			while (loop) {
				String sizeAnswer = sc.nextLine();
				
				try {
					
					radius = Double.parseDouble(sizeAnswer);
					loop = false;
					
				} catch (Exception e) {
					System.out.println(Color.RED_BACKGROUND + "Invalid input." + Color.RESET);
				}
			}
			
			area = Math.PI * (radius*radius);
			circumference = 2*Math.PI * radius;
			
			System.out.println(Color.CYAN);
			
			System.out.println("Area: " + area);
			System.out.println("Circumference: " + circumference + Color.RESET);
			
			System.out.println("\nWould you like to continue? (Y/N)");
			char r = sc.nextLine().charAt(0);
			r = Character.toUpperCase(r);
			
			if (r == 'Y') {
				running = true;
			} else {
				running = false;
			}
			clearScreen();
			
		}
		
	}
		
		
}

