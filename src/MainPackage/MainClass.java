package MainPackage;

import equation.*;
import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import models.*;

public class MainClass {

	public static void main(String[] args) throws Exception {

		try {
			Equation equation = new Equation();
			Factor a = new Factor();
			Factor b = new Factor();
			Factor c = new Factor();
			Scanner input = new Scanner(System.in);
			;
			System.out.print("a = ");
			a.value = input.nextDouble();
			equation._factors.addElement(a);
			System.out.print("b = ");
			b.value = input.nextDouble();
			equation._factors.addElement(b);
			System.out.print("c = ");
			c.value = input.nextDouble();
			equation._factors.addElement(c);
			Collections.reverse(equation._factors);

			input.close();
			equation.solveEcuation();

			System.out.println("Solutions of equation are: ");
			var i = new AtomicInteger(0);
			equation._solutions.forEach(x -> {
				System.out.println("x[" + i + "] = " + x.value);
				i.set(i.get() + 1);
			});

		} catch (Exception e) {
			System.out.print("Invalid Parameter " + e.getMessage());

		}
	}
}
