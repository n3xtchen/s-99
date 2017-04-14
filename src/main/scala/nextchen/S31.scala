/*
 * S31.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P31 {
	// scala> 7.isPrime
	// res0: Boolean = true

  implicit class S99Int(x: Int) {
    /**
     * 是否是质数
     *
     * 只能被 1 和 本身整除
     **/
    def isPrime = {
      (2 to x-1).filter(x % _ == 0).length == 0
    }
  }


  def main(args: Array[String]) {
    println(7.isPrime)
  }
}

