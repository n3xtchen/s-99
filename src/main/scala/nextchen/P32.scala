/*
 * P32.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P32 {
	// scala> gcd(36, 63)
	// res0: Int = 9

  /**
   * 求最大公约数
   *
   **/
  def myGcd(a: Int, b: Int): Int = if (b == 0) {
    a
  } else {
    val (x, y) = if (a < b) (a, b) else (b, a)
    myGcd(x, y % x)
  }

  /**
   * 求最大公约数
   * 使用欧几里得算法（Euclid）
   *
   **/
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def main(args: Array[String]) {
    println(myGcd(36, 63))
    println(gcd(36, 63))
  }
}

