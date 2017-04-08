/*
 * P16.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P16 {
	// scala> drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	// res0: List[Symbol] = List('a, 'b, 'd, 'e, 'g, 'h, 'j, 'k)
  
  def drop[A](n: Int, list: List[A]) = {
    for {
      (item, i) <- list.zipWithIndex
      if (i+1) % n != 0
    } yield item
  }.toSeq

  def main(args: Array[String]) {
    println(drop(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}

