package star.key13bb
package basics

object Eje4:
	// Función que imprime los n primeros números primos
	def primos(n: Int): List[Int] = 
		var i = 2
		var count = 0
		var primos = List[Int]()
		while (count < n)
			if (esPrimo(i))
				println(i)
				primos = i :: primos
				count += 1
			i += 1
		primos.reverse
	
	private def esPrimo(i: Int): Boolean =
		if (i < 2) false
		else if (i == 2) true
		else if (i % 2 == 0) false
		else
			var j = 3
			while (j * j <= i)
				if (i % j == 0) return false
				j += 2
			true