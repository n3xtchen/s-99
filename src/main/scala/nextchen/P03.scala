/*
 * P03.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P03 {
  // scala> nth(2, List(1, 1, 2, 3, 5, 8))
  // res0: Int = 2

  def nth[A](n: Int, list: List[A]): A = (n, list) match {
    case (0, l :: _) => l
    case (n, _ :: tail) => nth(n-1, tail)
    case (_, _) => throw new NoSuchElementException
  }

	def main(args: Array[String]) {
    println(nth(2, List(1, 1, 2, 3, 5, 8)))
	}
}

