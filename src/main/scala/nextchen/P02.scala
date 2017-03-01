/*
 * P02.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P02 {
  // scala> penultimate(List(1, 1, 2, 3, 5, 8))
  // res0: Int = 5

  def penultimate[A](list: List[A]): A = list match {
    case l :: _ :: Nil => l
    case _ :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }

	def main(args: Array[String]) {
    println(penultimate(List(1, 1, 2, 3, 5, 8)))
	}
}

