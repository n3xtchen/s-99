/*
 * P27.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import P26.combinations

object P27 {
	// scala> group3(List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
	// res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David, Evi), List(Flip, Gary, Hugo, Ida)), ...
  
  // scala> group(List(2, 2, 5), List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida"))
	// res0: List[List[List[String]]] = List(List(List(Aldo, Beat), List(Carla, David), List(Evi, Flip, Gary, Hugo, Ida)), ...

  def group3[A](list: List[A]) = for {
    list2 <- combinations(2, list)
    l = list diff list2
    list3 <- combinations(3, l)
  } yield List(list2, list3, l diff list3)

  def group[A](sizes: List[Int], list: List[A]): List[List[List[A]]] = sizes match {
    case List(size: Int) => combinations(size, list).map(List(_))
    case head::tail => for {
      subList <- combinations(head, list)
      item <- group(tail, list diff subList)
    } yield subList :: item
  }

  def main(args: Array[String]) {
    val list = List("Aldo", "Beat", "Carla", "David", "Evi", "Flip", "Gary", "Hugo", "Ida")
    val g0 = group3(list)
    val g1 = group(List(2,3,4), list)
    println(g1==g0)
  }
}

