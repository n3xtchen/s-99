/*
 * P33.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import P32.gcd

object P33 {
	// scala> 35.isCoprimeTo(64)
	// res0: Boolean = true

  implicit class S99Int(x: Int) {
    // x, y 是否互质
    def isCoprimeTo(y: Int) = gcd(x, y) == 1
  }

  def main(args: Array[String]) {
    println(35.isCoprimeTo(64))
  }
}

