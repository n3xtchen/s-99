/*
 * P01.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import scala.util.Try

object P01 {
  // scala> last(list(1, 1, 2, 3, 5, 8))
  // res0: Int = 8
  
  // 原本实现没有使用范性，会出现 warning
  // 实际上还有一种 Try[Int]
  def myLast(list: List[Int]): Try[Int] = list match {
    case l :: Nil => Try(l)
    case _ :: tail => myLast(tail)
    case _ => throw new NoSuchElementException
  }

  def last[A](list: List[A]): A = list match {
    case l :: Nil => l
    case _ :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }
  
	def main(args: Array[String]) {
    val l = List(1, 1, 2, 3, 5, 8)
    println(last(l))
	}
}

