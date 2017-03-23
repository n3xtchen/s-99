/*
 * P09.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P09 {
  // scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	// res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))

  def pack[A](ls: List[A]) = {
    def pack[A](list: List[List[A]]): List[List[A]] = list match {
      case Nil => Nil
      case head :: sec :: tail if sec(0) == head(0) => pack((head ++  sec) :: pack(tail))
      case head :: tail => head :: pack(tail)
    }
    pack(ls.map(List(_)))
  }

  def main(args: Array[String]) {
    println(pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}

