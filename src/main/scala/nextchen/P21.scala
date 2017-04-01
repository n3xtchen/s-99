/*
 * P20.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P21 {
	// scala> insertAt('new, 1, List('a, 'b, 'c, 'd))
	// res0: List[Symbol] = List('a, 'new, 'b, 'c, 'd)

  def insertAt[A](v: A, n: Int, list: List[A]) = {
    def proc(b: List[A], a: List[A]=Nil, i: Int=0): List[A] = (i, b) match {
      case (`n`, _) => a ++ (v :: b)
      case (_, head::tail) => proc(tail, head::a, i+1)
      case (_, Nil) => throw new Exception("索引超出")
    }
    proc(list)
  }

  def main(args: Array[String]) {
    println(insertAt('new, 1, List('a, 'b, 'c, 'd)))
  }
}

