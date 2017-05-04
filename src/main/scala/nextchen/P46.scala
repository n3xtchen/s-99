/*
 * P46.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P46 {
	// scala> table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
	// A     B     result
	// true  true  true
	// true  false true
	// false true  false
	// false false false

  def and(a: Boolean, b: Boolean): Boolean = a && b

  def or(a: Boolean, b: Boolean): Boolean = a || b

  def nand(a: Boolean, b: Boolean): Boolean = ???

  def nor(a: Boolean, b: Boolean): Boolean = ???

  def xor(a: Boolean, b: Boolean): Boolean = ???

  def impl(a: Boolean, b: Boolean): Boolean = ???

  def equ(a: Boolean, b: Boolean): Boolean = ???

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
    table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
  }
}

