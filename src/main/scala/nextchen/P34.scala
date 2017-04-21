/*
 * P34.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen


object P34 {
	// scala> 10.totient
	// res0: Int = 4

  implicit class S99Int(x: Int) extends P33.S99Int(x) {
    // 小于 X 并与 X 互质的正整数的个数
    def totient: Int = (1 to x).filter({ x.isCoprimeTo(_) }).length
  }

  def main(args: Array[String]) {
    println(10.totient)
  }
}

