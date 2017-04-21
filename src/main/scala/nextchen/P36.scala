/*
 * P36.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P36 {
	// scala> 315.primeFactorMultiplicity
	// res0: List[(Int, Int)] = List((3,2), (5,1), (7,1))
  // scala> 315.primeFactorMultiplicity
	// res0: Map[Int,Int] = Map(3 -> 2, 5 -> 1, 7 -> 1)

  implicit class S99Int(x: Int) extends P35.S99Int(x) {
    def primeFactorMultiplicity = 
      P10.encode(this.primeFactors).map(_.swap)

    // 递归法
    def primeFactorMultiplicityR = {
      // y, x => a, b
      // y = (x^a)*b
      def multiplicity(y: Int, x: Int): (Int, Int) = if (y % x != 0) {
        (0, y)
      } else {
        val (a, b) = multiplicity(y/x, x)
        (a+1, b)
      }

      /**
       * n: 要分解的值
       * ps: primeStream, 质数流
       **/
      def proc(n: Int, ps: Stream[Int]): List[(Int, Int)] = {
        if (n.isPrime) List((n, 1))
        else {
          multiplicity(n, ps.head) match {
            case (0, _) => proc(n, ps.tail)
            case (a, b) => (ps.head, a) :: proc(b, ps.tail)
          }
        }
      }
      proc(x, P35.S99Int.primes)
    }
  }

  def main(args: Array[String]) {
    println(315.primeFactorMultiplicityR)
  }
}

