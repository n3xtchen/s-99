/*
 * P08.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P08 {
  // scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
  // res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
  
  /*
   * occupy：匹配后续的字符是否与其相同
   */
  def compress[A](list: List[A], occupy: A=Nil): List[A] = list match {
    case Nil => Nil
    case head :: tail if occupy == head => compress(tail, occupy)
    case head :: tail => head :: compress(tail, head)
  }
  
  def compress[A](list: List[A]): List[A] = list match {
    case Nil => Nil
    // case (head :: sec :: tail, x) if x == head => compress(tail, x)
    case head :: sec :: tail if sec == head => compress(head :: compress(tail))
    case head :: tail => head :: compress(tail)
  }

  def main(args: Array[String]) {
    println(compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }
}

