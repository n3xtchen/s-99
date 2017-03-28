/*
 * P14.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P15 {
	// scala> duplicate(List('a, 'b, 'c, 'c, 'd))
	// res0: List[Symbol] = List('a, 'a, 'b, 'b, 'c, 'c, 'c, 'c, 'd, 'd)
  
  def duplicateN[A](n: Int, list: List[A]) = {
    for {
      i <- list
      _ <- 1 to n
    } yield i
  } toSeq

  def main(args: Array[String]) {
    println(duplicateN(3, List('a, 'b, 'c, 'c, 'd)))
  }
}

