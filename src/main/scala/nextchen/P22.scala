/*
 * P22.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import P05.reverse

object P22 {
	// scala> range(4, 9)
	// res0: List[Int] = List(4, 5, 6, 7, 8, 9)

  def range(start: Int, end: Int) = {
    def proc(s: Int, list: List[Int] = Nil): List[Int] = s match {
      case `end` => s :: list
      case _ => proc(s+1, s :: list)
    }
    reverse(proc(start))
  }

  def main(args: Array[String]) {
    println(range(4, 9))
  }
}

