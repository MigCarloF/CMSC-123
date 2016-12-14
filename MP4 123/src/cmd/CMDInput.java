package cmd;

import java.util.Scanner;

import exceptions.InvalidInputException;
import exceptions.NotEnoughArgumentsException;

public class CMDInput {

	public static void run() {
		CommandCenter commandCenter = new CommandCenter();
		Scanner sc = new Scanner(System.in);
		String input;
		while (true) {
			System.out.print(commandCenter.showCurrentFolder() + ">");
			input = sc.nextLine();
			input = input.toLowerCase();
			if (input.equals("exit")) {
				break;
			} else {
				try {
					commandCenter.perform(input);
				} catch (InvalidInputException e) {
					System.out.println(e.getMessage());
				} catch (NotEnoughArgumentsException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		sc.close();
	}
}
