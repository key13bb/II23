package star.key13bb
package basics

object Eje6:
	def segundo(array: Array[Int]): Int =
		if array.length < 2 then
			throw new IllegalArgumentException("Array must have at least 2 elements")
		else
			val temp = array.sorted.reverse
			temp(1)