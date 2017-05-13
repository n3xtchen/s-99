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
    import nextchen.P07.flatten

    def proc(
      tmp: List[(List[String], Int)],
      result: Map[String, String] = Map[String, String]()
    ): Map[String, String] = if (tmp.length == 1) {
      result 
    } else {
      val (a, va)  :: (b, vb) :: tail = tmp.sortBy(_._2)
      for ( (k,v)  <- b.map((_,"1")) ++ a.map((_, "0")))
        result(k) = v + result.getOrElse(k, "")
      proc(
        (a++b, va+vb) :: tail,
        result
      )
    }
    proc(l.map { case (k, v) => (List(k), v) }).toSeq.sortBy(_._1)
  }

  def main(args: Array[String]) {
    println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))))
  }
}

