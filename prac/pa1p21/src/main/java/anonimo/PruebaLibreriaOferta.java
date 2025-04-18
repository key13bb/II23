package anonimo;

import libreria.LibreriaOferta;

public class PruebaLibreriaOferta {
	/*
	("george orwell", "1984", 8.20)
	("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50)
	("Isaac Asimov", "Fundación e Imperio", 9.40)
	("Ray Bradbury", "Fahrenheit 451", 7.40)
	("Aldous Huxley", "Un Mundo Feliz", 6.50)
	("Isaac Asimov", "La Fundación", 7.30)
	("William Gibson", "Neuromante", 8.30)
	("Isaac Asimov", "Segunda Fundación", 8.10)
	("Isaac Newton", "arithmetica universalis", 7.50)
	("George Orwell", "1984", 6.20)
	("Isaac Newton", "Arithmetica Universalis", 10.50)
	*/
	public static void main(String[] args) {
		String[] biblioteca = {"George Orwell", "Isaac Asimov"};

		LibreriaOferta lib = new LibreriaOferta(20, biblioteca);

		lib.addLibro("george orwell", "1984", 8.20);
		lib.addLibro("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?", 3.50);
		lib.addLibro("Isaac Asimov", "Fundación e Imperio", 9.40);
		lib.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		lib.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		lib.addLibro("Isaac Asimov", "La Fundación", 7.30);
		lib.addLibro("William Gibson", "Neuromante", 8.30);
		lib.addLibro("Isaac Asimov", "Segunda Fundación", 8.10);
		lib.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		lib.addLibro("George Orwell", "1984", 6.20);
		lib.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);

		System.out.println(lib);

		lib.remLibro("George Orwell", "1984");
		lib.remLibro("Aldous Huxley", "Un Mundo Feliz");
		lib.remLibro("Isaac Newton", "Arithmetica Universalis");

		System.out.println(lib);

		System.out.println(lib.precioFinal("Philip K. Dick", "¿Sueñan los androides con ovejas eléctricas?"));
		System.out.println(lib.precioFinal("isaac asimov", "fundación e imperio"));
		System.out.println(lib.precioFinal("Ray Bradbury", "Fahrenheit 451"));
		System.out.println(lib.precioFinal("Isaac Asimov", "La Fundación"));
		System.out.println(lib.precioFinal("william gibson", "neuromante"));
		System.out.println(lib.precioFinal("Isaac Asimov", "Segunda Fundación"));
		System.out.println(lib.precioFinal("Isaac Newton", "Arithmetica Universalis"));

	}
}
