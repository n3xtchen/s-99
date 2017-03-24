/*
 * P10.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P11 {
  // scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
	// res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))

  def encodeModified[A](ls: List[A]) = {
    def proc(list: List[(Int,A)]): List[(Int, A)] = list match {
      case Nil => Nil
      case head :: sec :: tail if sec._2 == head._2 =>
        proc((head._1+sec._1, head._2) :: proc(tail))
      case head :: tail => head :: proc(tail)
    }
    proc(ls.map((1, _))).map(x => if (x._1 == 1) x._2 else x) 
  }

  def main(args: Array[String]) {
    println(encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}

