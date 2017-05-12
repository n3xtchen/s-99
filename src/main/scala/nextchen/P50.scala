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
      tmp: List[(Any, Int)],
      result: Map[String, String] = Map.empty
    ): Map[String, String] = if (tmp.length == 1) {
      result 
    } else {
      def updateCode(r: Any, prefix: String) = r match {
        case i:String => result(i) = prefix + result.getOrElse(i, "")
        case x: List[Any] => flatten(x)
          .map { case y: String => result(y) = prefix + result.getOrElse(y, "") }
      }
      val ( a :: b :: tail) = tmp.sortBy(_._2)
      updateCode(a._1, "0")
      updateCode(b._1, "1")
      proc((List(a._1, b._1), a._2+b._2) :: tail, result)
    }
    proc(l).toList.sorted
  }


  def main(args: Array[String]) {
    println(huffman(List(("a", 45), ("b", 13), ("c", 12), ("d", 16), ("e", 9), ("f", 5))))
  }
}

