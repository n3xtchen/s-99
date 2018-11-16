/*
 * P55.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object Tree1 {
  /**
   * 返回所有的满足要求的平衡二叉树
   * params
   *  n: 节点数
   *  name: 节点命名
   *
   **/
  def cBalance[T](n: Int, name: T): List[Node[T]] = {
    List(Node(name))
  }
}

object P55 {
  def main(args: Array[String]) {
    println(Tree1.cBalance(4, 'x'))
  }
}

