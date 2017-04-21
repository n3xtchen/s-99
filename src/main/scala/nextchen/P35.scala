/*
 * P35.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P35 {
	// scala> 315.primeFactors
	// res0: List[Int] = List(3, 3, 5, 7)

  implicit class S99Int(val x: Int) extends P31.S99Int(x) {

    // 质因数分解
    def primeFactors = {
      var y = x
      for {
        n <- S99Int.primes.takeWhile(_ < x)
        _ <- Stream.from(2).takeWhile(x => y % n == 0) 
      } yield {
          y = y / n
          n
      }
    }.toList
  }

  object S99Int {
    val primes = Stream.cons(2, Stream.from(3, 2) filter { _.isPrime })
  }

  def main(args: Array[String]) {
    println(315.primeFactors)
  }
}

