/*
 * P17.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P17 {
  // scala> split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	// res0: (List[Symbol], List[Symbol]) = (List('a, 'b, 'c),List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k))

  def split[A](n: Int, list: List[A]): (List[A], List[A]) = {
    def proc(a: List[A], b: List[A]=Nil): (List[A], List[A]) = a match {
      case a if b.length == n => (b, a)
      case head :: tail => proc(tail, b ++ List(head))
      case Nil => throw new Exception("位数不够")
    }
    proc(list)
  }

  def main(args: Array[String]) {
    println(split(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)))
  }
}

