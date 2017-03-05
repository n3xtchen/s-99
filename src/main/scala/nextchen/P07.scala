/*
 * P07.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P07 {
	// scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
	// res0: List[Any] = List(1, 1, 2, 3, 5, 8)
  
  def flatten(list: List[Any]): List[Any] = {
    for (
         item <- list; 
         i <- (item match {
           case ms: List[_] => flatten(ms)
           case head: Any => head :: Nil
         })
       ) yield i
  }

  def main(args: Array[String]) {
    println(flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  }
}

