/*
 * P50.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P50 {
	// scala> huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5)))
	// res0: List[String, String] = List((a,0), (b,101), (c,100), (d,111), (e,1101), (f,1100))
  
  def huffman(l: List[(String, Int)]) = {
    var tmp: List[(Any, Int)] = l
    val keys = l.map(x => (x._1, "")).toMap
    while (tmp.length > 1) {
      val ( a :: b :: tail) = tmp.sortBy(_._2)
      tmp = ((a._1, b._1), a._2+b._2) :: tail
    }
    tmp(0)._1
  }

  def main(args: Array[String]) {
    println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))))
  }
}

