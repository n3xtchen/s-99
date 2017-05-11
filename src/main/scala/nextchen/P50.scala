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
    import scala.collection.mutable.Map

    def proc(
      tmp: List[(Any, Int)],
      result: Map[String, String] = Map.empty
    ): Map[String, String] = if (tmp.length == 1) {
      result 
    } else {
      val ( a :: b :: tail) = tmp.sortBy(_._2)
      println(a, b)
      result(a._1.toString) = "0" + result.getOrElse(a._1.toString, "")
      result(b._1.toString) = "0" + result.getOrElse(b._1.toString, "")
      proc((List(a._1, b._1), a._2+b._2) :: tail, result)
    }
    proc(l)
  }


  def main(args: Array[String]) {
    println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))))
  }
}

