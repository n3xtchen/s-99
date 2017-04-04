/*
 * P24.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import P23.randomSelect

object P24 {
	// scala> lotto(6, 49)
	// res0: List[Int] = List(23, 1, 17, 33, 21, 37)

  /*
   * 相当于从 M 个数字中不放回的抽取 N 个
   */
  def lotto(n: Int, m: Int) = {
    randomSelect(n, (1 to m+1).toList)
  }

  def main(args: Array[String]) {
    println(lotto(6, 49))
  }
}

