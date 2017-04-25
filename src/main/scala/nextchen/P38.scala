/*
 * P38.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P38 {

  def time[A](label: String)(block: => A): A = {
    val now = System.currentTimeMillis()
    val ret = block
    println(label + ": " + (System.currentTimeMillis() - now) + " ms.")
    ret
  }

  def main(args: Array[String]) {
    time("Preload primes") {
      (P35.S99Int.primes takeWhile { _ <= Math.sqrt(10090) }).force
    }
    time("P34") {
      import P34._
      10090.totient
    }
    time("P37") {
      import P37._
      10090.totient
    }
  }
}

