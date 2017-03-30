/*
 *
 * P18.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P18 {
	// scala> slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	// res0: List[symbol] = List('d, 'e, 'f, 'g)

  def slice[A](i: Int, k: Int, list: List[A]) = {
    for {
      (item, index) <- list.zipWithIndex
      if index >= i && index < k
    } yield item
  } toSeq

  def main(args: Array[String]) {
    println(slice(3, 7, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}

