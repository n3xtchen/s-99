/*
 * P25.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import P23.randomSelect

object P25 {
  // scala> randomPermute(List('a, 'b, 'c, 'd, 'e, 'f))
	// res0: List[Symbol] = List('b, 'a, 'd, 'c, 'e, 'f)

  // O(N^2)
  def randomPermute[A](list: List[A]) = {
    randomSelect(list.length, list)
  }

  /**
   * 洗牌算法; O(N)
   * http://www.cnblogs.com/Jerry-Chou/archive/2012/01/04/2311610.html
   * scala 创建范性 Array, 需要函数定义定义范型类型 A: Manifest
   **/
  def FisherYatesShuffle[A: Manifest](list: List[A]) = {
    val rand = new util.Random
    val arr = list.toArray
    for (n <- arr.length - 1 to 1 by -1) {
      val k = rand.nextInt(n)
      val vk = arr(k)
      arr.update(k, arr(n))
      arr.update(n, vk)
    }
    arr.toList
  }

  def main(args: Array[String]) {
    println(randomPermute(List('a, 'b, 'c, 'd, 'e, 'f)))
    // println(FisherYatesShuffle(List('a, 'b, 'c, 'd, 'e, 'f)))
  }
}

