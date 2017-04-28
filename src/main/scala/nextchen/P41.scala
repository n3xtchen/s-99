/*
 * P41.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P41 {
	// scala> printGoldbachList(9 to 20)
	// 10 = 3 + 7
	// 12 = 5 + 7
	// 14 = 3 + 11
	// 16 = 3 + 13
	// 18 = 5 + 13
	// 20 = 3 + 17
	
  import P40._

  def  printGoldbachList(r: Range) = {
    for ( i <- r if i % 2 == 0) yield {
      val (a, b) = i.goldbach
      s"$i = $a + $b"
    }
  }

  def main(args: Array[String]) {
    printGoldbachList(9 to 20).foreach(println)
  }
}

