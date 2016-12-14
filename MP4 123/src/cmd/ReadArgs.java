package cmd;

import java.util.Scanner;

class ReadArgs {
	public static void main(String[] args) {
		int lel[][] = null;
		lel = new int[3][3];
		lel[1][0] = 1;
		lel[1][2] = 1;
		lel[0][0] = 1;
		for (int[] i : lel) {
			for (int j : i) {
				System.out.println(j);
			}

		}
		System.out.println();
		System.out.println(args.length);
		if (args.length >= 1) {
			System.out.println("Running commands in file: " + args[0]);
		} else {
			System.out.println("No args provided. Running in interactive mode");
		}
		System.out.println();
		// Initialize Scanner object
		Scanner scan = new Scanner("Anna Mills Female 18");
		// initialize the string delimiter
		scan.useDelimiter("\\s+");
		// Printing the tokenized Strings
		while (scan.hasNext()) {
			System.out.println(scan.next());
		}

		String lel2 = "We have good men 12";

		String[] lel3 = lel2.split("\\s+", 2);
		System.out.println(lel3.length);
		for(String str : lel3){
			System.out.println(str);
		}
		// closing the scanner stream
		scan.close();

		int firstArg;
		if (args.length > 0) {
			try {
				firstArg = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				System.err.println("Argument" + args[0] + " must be an integer.");
				System.exit(1);
			}
		}
	}
}