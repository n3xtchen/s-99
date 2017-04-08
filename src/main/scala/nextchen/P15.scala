/*
 * P14.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P14 {
	// scala> duplicate(List('a, 'b, 'c, 'c, 'd))
	// res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  
  def duplicate[A](list: List[A]) = {
    for {
      i <- list
      _ <- 1 to 2
    } yield i
  }.toSeq

  def main(args: Array[String]) {
    println(duplicate(List('a, 'b, 'c, 'c, 'd)))
  }
}

