/*
 * P35.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object P35 {
	// scala> 315.primeFactors
	// res0: List[Int] = List(3, 3, 5, 7)

  implicit class S99Int(val x: Int) extends P31.S99Int(x) {

    // 质因数分解(迭代法)
    def primeFactors = {
      var y = x
      for {
        n <- S99Int.primes.takeWhile(_ < x)
        _ <- Stream.from(2).takeWhile(x => y % n == 0) 
      } yield {
          y = y / n
          n
      }
    }.toList

    // 递归发
    def primeFactorsR = {
      /**
       * n: 要分解的值
       * primeStream：质数流
       **/
      def proc(n: Int, primeStream: Stream[Int]): List[Int] = {
        if (n.isPrime) List(n)  // 如果本身是质数，只有被本身因式分解
        else if (n % primeStream.head == 0) primeStream.head :: proc(n / primeStream.head, primeStream) // 是因子，轮询
        else proc(n, primeStream.tail)  // 不是的话，下一个质数
      }
      proc(x, S99Int.primes)
    }
  }

  object S99Int {
    val primes = Stream.cons(2, Stream.from(3, 2) filter { _.isPrime })
  }

  def main(args: Array[String]) {
    println(315.primeFactors)
    println(315.primeFactorsR)
  }
}

