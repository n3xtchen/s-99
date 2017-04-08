/*
 * P26.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import P17.split

object P26 {
	// scala> combinations(3, List('a, 'b, 'c, 'd, 'e, 'f))
	// res0: List[List[Symbol]] = List(List('a, 'b, 'c), List('a, 'b, 'd), List('a, 'b, 'e), ...

  def subList[A](k: Int, list: List[A]): List[(A, List[A])] = {
    if (k == 0) {
      Nil
    } else {
      val head :: tail = list
      (head, tail) :: subList(k-1, tail)
    }
  }

  def combinations[A](k: Int, list: List[A]): List[List[A]] = {
    if (k == 1) {
      list.map(List(_))
    } else {
      for {
        (item, tail) <- subList(list.length-k+1, list)
        e <- combinations(k-1, tail).map(item::_)
      } yield e 
    }.toList
  }

  def main(args: Array[String]) {
    println(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)))
  }
}

