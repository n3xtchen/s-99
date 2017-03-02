/*
 * P04.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P04 {
	// scala> length(List(1, 1, 2, 3, 5, 8))
	// res0: Int = 6
  
  // my
  def len[A](list: List[A]): Int = {
    var i = 0
    for (_ <- list) {
      i = i + 1
    }
    i
  }

  def length[A](list: List[A]): Int = list match {
    case Nil => 0
    case _ :: tail => 1 + length(tail)
  }

	def main(args: Array[String]) {
    println(length(List(1, 1, 2, 3, 5, 8)))
    println(len(List(1, 1, 2, 3, 5, 8)))
	}
}

