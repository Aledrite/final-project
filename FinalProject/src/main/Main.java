package main;

import java.util.Scanner;
import visuals.Colors;

public class Main 
{
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		System.out.println(Colors.CYAN + "Welcome to Atom." + Colors.RESET);
		System.out.println(Colors.GREEN + "Would you like to start the program? Y/N" + Colors.RESET);
		
		Boolean programRunning = false;
		
		char answer = sc.nextLine().charAt(0);
		
		answer = Character.toUpperCase(answer);
		
		if (answer == "Y".charAt(0)) {programRunning = true;}
		
		while (programRunning) {}
		
		System.out.println("Program ended.");
		
	}
	
	private static void Calculator() 
	{
		
	}
	
}
