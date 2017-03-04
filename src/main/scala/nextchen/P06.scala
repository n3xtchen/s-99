/*
 * P06.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

import P04.length
import P05.reverse

object P06 {
	// scala> isPalindrome(List(1, 2, 3, 2, 1))
	// res0: Boolean = true

  def isPalindrome[A](list: List[A]): Boolean = {
    val len = length(list)
    val mid = len / 2

    var s = 0
    var e = len - 1

    var r = true
    while (s <= e) {
      if (list(s) != list(e)) {
        r = false
      }
      s = s + 1
      e = e - 1
    }
    r
  }

	def main(args: Array[String]) {
    println(isPalindrome(List(1, 2, 3, 2, 1)))
	}
}

