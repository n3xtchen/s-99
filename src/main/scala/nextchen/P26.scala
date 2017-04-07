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

  def combinations[A](k: Int, list: List[A]): List[List[A]] = (k, list) match {
    case (1, _) => list.map(List(_))
    case _ => {
      for {
        (item, i) <- list.zipWithIndex
        val (_, tail) = list.splitAt(i+1)
        if i < list.length-k+1
        e <- combinations(k-1, tail).map(item::_)
      } yield e 
    } toList
  }

  def main(args: Array[String]) {
    println(combinations(3, List('a, 'b, 'c, 'd, 'e, 'f)))
  }
}

