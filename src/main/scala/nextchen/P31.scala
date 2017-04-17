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
    def isPrime: Boolean = {
      (x > 1) && (2 to x-1).filter(x % _ == 0).length == 0
    }

    /**
     * 拭除法来验证质数
     * 将 n 除以每个大于1且小于等于 n 的平方根之整数 m。
     * 若存在一个相除为整数的结果，则 n 不是素数；反之则是个素数。
     *
     **/
    def isPrimeA: Boolean = {
      Stream.from(2).takeWhile { _ <= Math.sqrt(x) }.forall { x % _ != 0 }
    }

  }


  def main(args: Array[String]) {
    println(7.isPrimeA)
  }
}

