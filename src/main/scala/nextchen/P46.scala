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

  def not(a: Boolean) = a match {
    case true  => false
    case false => true
  }
  def and(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (true, true) => true
    case _            => false
  }
  def or(a: Boolean, b: Boolean): Boolean = (a, b) match {
    case (true, _) => true
    case (_, true) => true
    case _         => false
  }
  def equ(a: Boolean, b: Boolean): Boolean = or(and(a, b), and(not(a), not(b)))

  def notM(a: Boolean): Boolean = !a
  def equM(a: Boolean, b: Boolean): Boolean = a == b
  def andM(a: Boolean, b: Boolean): Boolean = a && b
  def orM(a: Boolean, b: Boolean): Boolean = a || b

  def nand(a: Boolean, b: Boolean): Boolean = not(and(a, b))

  def nor(a: Boolean, b: Boolean): Boolean = not(or(a, b))

  def xor(a: Boolean, b: Boolean): Boolean = not(equ(a, b))

  def impl(a: Boolean, b: Boolean): Boolean = or(b, not(a))

  def implM(a: Boolean, b: Boolean): Boolean = b match {
    case true => true
    case false => a == false
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
    table2((a: Boolean, b: Boolean) => and(a, or(a, b)))
  }
}

