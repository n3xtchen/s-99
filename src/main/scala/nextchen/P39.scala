/*
 * P39.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P39 {
	// scala> listPrimesinRange(7 to 31)
	// res0: List[Int] = List(7, 11, 13, 17, 19, 23, 29, 31)

  import P35._

  def listPrimesinRangeM(list: List[Int]) = {
    list.filter(_.isPrime)
  }

  def listPrimesinRange(r: Range) = {
    S99Int.primes.dropWhile(_ < r.start) takeWhile { _ <= r.end }
  }.toList

  def main(args: Array[String]) {
    println(listPrimesinRange(7 to 31))
  }
}

