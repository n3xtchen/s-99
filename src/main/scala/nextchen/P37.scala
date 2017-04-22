/*
 * P37.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P37 {
	// scala> 10.totient
	// res0: Int = 4

  implicit class S99Int(x: Int) extends P36.S99Int(x) {
    // 小于 X 并与 X 互质的正整数的个数
    // phi(m) = (p1-1)*p1^(m1-1) * (p2-1)*p2^(m2-1) * (p3-1)*p3^(m3-1) * ...
    // https://zh.wikipedia.org/wiki/%E6%AC%A7%E6%8B%89%E5%87%BD%E6%95%B0
    def totient: Int = {
      x.primeFactorMultiplicityR map { case (a, b) => (a-1)*Math.pow(a, b-1) toInt } reduce { _*_ }
    }
  }

  def main(args: Array[String]) {
    println(10.totient)
  }
}

