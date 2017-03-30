/*
 * P19.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import P05.reverse
import P17.split

object P19 {
	// scala> rotate(3, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	// res0: List[Symbol] = List('d, 'e, 'f, 'g, 'h, 'i, 'j, 'k, 'a, 'b, 'c)
	// scala> rotate(-2, List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k))
	// res1: List[Symbol] = List('j, 'k, 'a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i)
  
  implicit def tuple2ToList[T](t: (T,T)): List[T] = List(t._1, t._2)

  def rotate[A](n: Int, list: List[A]) = {
    val len = if (n >= 0) n else (list.length + n)
    reverse(split(len, list).toSeq.map(reverse _).reduce(_ ++ _))
  }

  def main(args: Array[String]) {
    val list = List('a, 'b, 'c, 'd, 'e, 'f, 'g, 'h, 'i, 'j, 'k)
    println(rotate(3, list))
    println(rotate(-2, list))
  }
}

