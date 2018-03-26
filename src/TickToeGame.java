import java.util.Scanner;
import java.util.*;
import java.util.Random;

//TODO istaysiti kad programa nelustu ivedus 1 skaiciu , panaudoti try ir catch

public class TickToeGame {
	Map<String, Set<Integer>> moves = new HashMap<String, Set<Integer>>();
	Set<Integer> firstCell = new HashSet<Integer>();
	Set<Integer> secondCell = new HashSet<Integer>();
	Set<Integer> thirdCell = new HashSet<Integer>();
	private int playerTurn, m, q;
	private String a, b, c, d, e, f, g, h, i, n;
	private boolean pirmas, antras, trecias, ketvirtas, penktas, sestas, septintas, astuntas, devintas;
	boolean ats = false;
	Random randomGen = new Random();

	public static void main(String[] args) {
		TickToeGame objektas = new TickToeGame(); // konstruktorius
													// yra panaudojamas kai
													// sukuri objekta
		objektas.welcomeScreen();
		objektas.printTable();
		System.out.println("Please write down the cell there you want to put X\n");
		while (!objektas.arLaimetas()) {
			objektas.nuskaitymas();
			objektas.printTable();

		}
	}

	TickToeGame() { // konstruktorius kiekvieno zaidimo pradzioje nustatantis
					// vertes
		a = " ";
		b = " ";
		c = " ";
		d = " ";
		e = " ";
		f = " ";
		g = " ";
		h = " ";
		i = " ";
		n = "";
		pirmas = true;
		antras = true;
		trecias = true;
		ketvirtas = true;
		penktas = true;
		sestas = true;
		septintas = true;
		astuntas = true;
		devintas = true;
		playerTurn = 0;
	}

	void printTable() { // Spausdiname lentele su kintamaisiais

		if (playerTurn % 2 == 0) {
			n = "X";
		} else
			n = "O"; // tikriam kuris zaidejas

		if (firstCell.contains(3) && pirmas == true) {
			a = n;
			pirmas = false;
			System.out.println(firstCell);
		}
		if (firstCell.contains(4) && antras == true) {
			d = n;
			antras = false;
		}
		if (firstCell.contains(5) && trecias == true) {
			g = n;
			trecias = false;
		}

		if (secondCell.contains(3) && ketvirtas == true) {
			b = n;
			ketvirtas = false;
		}
		if (secondCell.contains(4) && penktas == true) {
			e = n;
			penktas = false;
		}
		if (secondCell.contains(5) && sestas == true) {
			h = n;
			sestas = false;
		}

		if (thirdCell.contains(3) && septintas == true) {
			c = n;
			septintas = false;
		}
		if (thirdCell.contains(4) && astuntas == true) {
			f = n;
			astuntas = false;
		}
		if (thirdCell.contains(5) && devintas == true) {
			i = n;
			devintas = false;
		}

		// lenteles spauzdinimas

		System.out.println("   1" + " " + "2" + " " + "3" + " ");
		System.out.println("  _" + "_" + "_" + "_" + "_" + "_" + "_");
		System.out.println("3" + " |" + a + "|" + b + "|" + c + "|");
		System.out.println("  _" + "_" + "_" + "_" + "_" + "_" + "_");
		System.out.println("4" + " |" + d + "|" + e + "|" + f + "|");
		System.out.println("  _" + "_" + "_" + "_" + "_" + "_" + "_");
		System.out.println("5" + " |" + g + "|" + h + "|" + i + "|");
		System.out.println("  _" + "_" + "_" + "_" + "_" + "_" + "_");
	}

	void welcomeScreen() { // Prisistatymo ekranas
		System.out.println("*****Welcome to the TickToeGame!*****\n");
	}

	void nuskaitymas() {
			boolean teisingasInputas = true;
			Scanner keybord = new Scanner(System.in);
			String a = keybord.nextLine();
			String[] numbers = a.split(" "); // issiplitinu i du skirtingus
												// stringus
			m = Integer.parseInt(numbers[0]);// ir irasau juos kaip kintamuosius
			q = Integer.parseInt(numbers[1]);
			if (m < 1 || m > 3 || q < 3 || q > 5) {
				while (teisingasInputas) { // apsisaugau nuo reiksmiu kurios
											// negali
											// buti lenteleje
					System.out.println("Wrong input! Please make use numbers to pick the cell!");
					a = keybord.nextLine();
					numbers = a.split(" ");
					m = Integer.parseInt(numbers[0]);
					q = Integer.parseInt(numbers[1]);
					if (m < 1 || m > 3 || q < 3 || q > 5) {
					} else
						teisingasInputas = false;
				}
			}

			if (m == 1)

			{
				if (firstCell.contains(q))
					System.out.println("Cell is already taken !");
				if (!firstCell.contains(q)) {
					firstCell.add(q);
					playerTurn += 1;// ivedam pasirinkima i seta

				}
			}
			if (m == 2)

			{
				if (secondCell.contains(q))
					System.out.println("Cell is already taken !");
				if (!secondCell.contains(q)) {
					secondCell.add(q);
					playerTurn += 1;// ivedam pasirinkima i seta
				}
			}
			if (m == 3)

			{
				if (thirdCell.contains(q))
					System.out.println("Cell is already taken !");
				if (!thirdCell.contains(q)) {
					thirdCell.add(q);
					playerTurn += 1;// ivedam pasirinkima i seta
				}
			}
		
	}

	boolean arLaimetas() { // tikrinu ar nera laimetas zaidimas
		boolean rezultatas = false;
		String input = "X";
		for (int em = 0; em <= 2; em++) {
			if (a == input && b == input && c == input) {
				System.out.print(a + " Has won!");
				rezultatas = true;
			}
			if (d == input && e == input && f == input) {
				System.out.print(d + " Has won!");
				rezultatas = true;
			}
			if (g == input && h == input && i == input) {
				System.out.print(g + " Has won!");
				rezultatas = true;
			}
			if (a == input && d == input && g == input) {
				System.out.print(a + " Has won!");
				rezultatas = true;
			}
			if (b == input && e == input && h == input) {
				System.out.print(b + " Has won!");
				rezultatas = true;
			}
			if (c == input && f == input && i == input) {
				System.out.print(c + " Has won!");
				rezultatas = true;
			}
			if (a == input && e == input && i == input) {
				System.out.print(a + " Has won!");
				rezultatas = true;
			}
			if (c == input && e == input && g == input) {
				System.out.print(c + " Has won!");
				rezultatas = true;
			}
			if (!rezultatas)
				input = "O";
			em++;
		}
		return rezultatas;
	}

}