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
    var s = 0
    var e = length(list) - 1
    while (s <= e) {
      if (list(s) != list(e)) {
        return false
      }
      s = s + 1
      e = e - 1
    }
    true
  }

  def isPalindromeSimple[A](list: List[A]) = list == reverse(list)

	def main(args: Array[String]) {
    println(isPalindrome(List(1, 2, 3, 2, 1)))
    println(isPalindromeSimple(List(1, 2, 3, 2, 1)))
	}
}

