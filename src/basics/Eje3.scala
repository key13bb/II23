package star.key13bb
package basics

object Eje3:
	def main(args: Array[String]): Unit =
		//Determinar si una palabra es palíndroma

		val pal = "ADA"
		if (palindromo(pal)) println(s"La palabra $pal si es palíndroma")
		else println(s"La palabra $pal no es palíndroma")

	def palindromo(pal: String): Boolean = pal == pal.reverse