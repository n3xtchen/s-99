/*
 * P23.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import P20.removeAt

object P23 {
	// scala> randomSelect(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h))
	// res0: List[Symbol] = List('e, 'd, 'a)

  def randomSelect[A](n: Int, list: List[A]): List[A] = {
    if (n > 0) {
      val (l, s) = removeAt(new util.Random().nextInt(list.length), list)
      s :: randomSelect(n-1, l)
    } else {
      Nil
    }
  }

  def main(args: Array[String]) {
    println(randomSelect(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h)))
  }
}

