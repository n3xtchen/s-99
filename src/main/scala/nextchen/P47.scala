/*
 * P47.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P47 {
	// scala> table2((a: Boolean, b: Boolean) => a and (a or not(b)))
	// A     B     result
	// true  true  true
	// true  false true
	// false true  false
	// false false false

  def not(a: Boolean) = a match {
    case true  => false
    case false => true
  }

  implicit class Logic(a: Boolean) {
    def and(b: Boolean): Boolean = (a, b) match {
      case (true, true) => true
      case _            => false
    }
    def or(b: Boolean): Boolean = (a, b) match {
      case (true, _) => true
      case (_, true) => true
      case _         => false
    }

    def ===(b: Boolean): Boolean = (a and b) or (not(a) and not(b))

    def nand(b: Boolean): Boolean = not(a and b)

    def nor(b: Boolean): Boolean = not(a and b)

    def xor(b: Boolean): Boolean = not(a === b)

    def impl(b: Boolean): Boolean = b or not(a)
  }

  def table2(f: (Boolean, Boolean) => Boolean): Unit = {
    val items = List(true, false)
    println("A\tB\tresult")
    for {
      a <- items
      b <- items
    } {
      val result = f(a, b)
      println(s"$a\t$b\t$result")
    }
  
  }

  def main(args: Array[String]) {
    table2((a: Boolean, b: Boolean) => a and (a or not(b)))
  }
}

