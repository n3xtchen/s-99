/*
 * P05.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P05 {
	// scala> reverse(List(1, 1, 2, 3, 5, 8))
	// res0: List[Int] = List(8, 5, 3, 2, 1, 1)
  
  // 知识点： List + element => l :+ element
  def  reverse[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    case head :: tail => reverse(tail) :+ head
  }

  // Pure functional
  def reverseFunctional[A](ls: List[A]): List[A] =
    ls.foldLeft(List[A]()) { (r, h) => h :: r }

	def main(args: Array[String]) {
    println(reverse(List(1, 1, 2, 3, 5, 8)))
	}
}

