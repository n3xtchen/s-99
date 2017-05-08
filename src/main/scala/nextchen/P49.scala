/*
 * P49.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P49 {

  // scala> gray(3)
  // res0 List[String] = List(000, 001, 011, 010, 110, 111, 101, 100)


  /*
   * 格雷码
	 * n = 1: C(1) = ("0", "1").
	 * n = 2: C(2) = ("00", "01", "11", "10").
	 * n = 3: C(3) = ("000", "001 ", "011", "010", "110", "111", "101", "100").
   *
   *   1   2    3                     n
   *            000
   *            001
   *       0 0  011 
   *   0   0 1  010
   *   -------------------------      除了第一位，都是前一阶镜像
   *   1   1 1  110
   *       1 0  111
   *            101
   *            100
  */
  def gray(n: Int): List[Any] = if (n == 0) {
    List("")
  } else {
    val g = gray(n - 1)
    g.map("0"+_) ::: g.reverse.map("1"+_)
  }

  def main(args: Array[String]) {
    println(gray(3))
  }
}

