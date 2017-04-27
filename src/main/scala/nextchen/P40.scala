/*
 * P40.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P40 {
	// scala> 28.goldbach
	// res0: (Int, Int) = (5,23)

  implicit class S99Int(val n: Int) extends P35.S99Int(n) {
    // 歌德巴赫猜想
    def goldbach() = {

      def proc(ps: Stream[Int]): (Int, Int) = ps match {
        case x #:: _ if (n-x).isPrime => (x, n-x)
        case _ #:: tail => proc(tail)
      } 

      proc(P35.S99Int.primes)
      // P35.S99Int.primes
      //   .map { x => (x, (n-x)) }
      //   .takeWhile { !_._2.isPrime }
    }
  }

  def main(args: Array[String]) {
    println(28.goldbach)
  }
}

