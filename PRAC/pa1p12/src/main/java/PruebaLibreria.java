import libreria.*;

public class PruebaLibreria {
	/* Libros a añadir
	("george orwell", "1984", 8.20)
	("Philip K. Dick", "?Suenan los androides con ovejas electricas?", 3.50)
	("Isaac Asimov", "Fundacion e Imperio", 9.40)
	("Ray Bradbury", "Fahrenheit 451", 7.40)
	("Aldous Huxley", "Un Mundo Feliz", 6.50)
	("Isaac Asimov", "La Fundacion", 7.30)
	("William Gibson", "Neuromante", 8.30)
	("Isaac Asimov", "Segunda Fundacion", 8.10)
	("Isaac Newton", "arithmetica universalis", 7.50)
	("George Orwell", "1984", 6.20)
	("Isaac Newton", "Arithmetica Universalis", 10.50)
	*/
	
	public static void main(String[] args) {
		Libreria l = new Libreria();
		addLibros(l);
		System.out.println();
		System.out.println(l);
		System.out.println();
		remLibros(l);
		System.out.println();
		System.out.println(l);
		System.out.println();
		printPrecios(l);
	}
	private static void addLibros(Libreria l) {
		l.addLibro("george orwell", "1984", 8.20);
		l.addLibro("Philip K. Dick", "?Suenan los androides con ovejas electricas?", 3.50);
		l.addLibro("Isaac Asimov", "Fundacion e Imperio", 9.40);
		l.addLibro("Ray Bradbury", "Fahrenheit 451", 7.40);
		l.addLibro("Aldous Huxley", "Un Mundo Feliz", 6.50);
		l.addLibro("Isaac Asimov", "La Fundacion", 7.30);
		l.addLibro("William Gibson", "Neuromante", 8.30);
		l.addLibro("Isaac Asimov", "Segunda Fundacion", 8.10);
		l.addLibro("Isaac Newton", "arithmetica universalis", 7.50);
		l.addLibro("George Orwell", "1984", 6.20);
		l.addLibro("Isaac Newton", "Arithmetica Universalis", 10.50);
	}

	private static void remLibros(Libreria l) {
		l.remLibro("George Orwell", "1984");
		l.remLibro("Aldous Huxley", "Un Mundo Feliz");
		l.remLibro("Isaac Newton", "Arithmetica Universalis");
	}

	private static void printPrecios(Libreria l) {
		System.out.println("PrecioFinal(Philip K. Dick, ?Suenan los androides con ovejas electricas?): "
				+ l.getPrecioFinal("Philip K. Dick", "?Suenan los androides con ovejas electricas?"));
		System.out.println("PrecioFinal(isaac asimov, fundacion e imperio): "
				+ l.getPrecioFinal("isaac asimov", "fundacion e imperio"));
		System.out.println("PrecioFinal(Ray Bradbury, Fahrenheit 451): "
				+ l.getPrecioFinal("Ray Bradbury", "Fahrenheit 451"));
		System.out.println("PrecioFinal(Isaac Asimov, La Fundacion): "
				+ l.getPrecioFinal("Isaac Asimov", "La Fundacion"));
		System.out.println("PrecioFinal(william gibson, neuromante): "
				+ l.getPrecioFinal("william gibson", "neuromante"));
		System.out.println("PrecioFinal(Isaac Asimov, Segunda Fundacion): "
				+ l.getPrecioFinal("Isaac Asimov", "Segunda Fundacion"));
		System.out.println("PrecioFinal(Isaac Newton, Arithmetica Universalis): "
				+ l.getPrecioFinal("Isaac Newton", "Arithmetica Universalis"));
	}
}
