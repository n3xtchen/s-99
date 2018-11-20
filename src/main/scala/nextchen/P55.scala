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
    List(
      Node(name)
      )
  }
  def bBalanced[T](nodes: Int, value: T): List[Tree[T]] = nodes match {
    case n if n < 1 => List(End)
    case n if n % 2 == 1 => {
      val subtrees = bBalanced(n / 2, value)
      subtrees.flatMap(l => subtrees.map(r => Node(value, l, r)))
    }
    case n if n % 2 == 0 => {
      val lesserSubtrees = bBalanced((n - 1) / 2, value)
      val greaterSubtrees = bBalanced((n - 1) / 2 + 1, value)
      lesserSubtrees.flatMap(l => greaterSubtrees.flatMap(g => List(Node(value, l, g), Node(value, g, l))))
    }
  }

}

object P55 {
  def main(args: Array[String]) {
    println(Tree1.bBalanced(4, 'x'))
  }
}

