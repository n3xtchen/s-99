/*
 * arithmetic.scala
 * Copyright (C) 2017 n3xtchen <echenwen@gmail.com>
 *
 * Distributed under terms of the GPL-2.0 license.
 */

package nextchen

object Arithmetic {

  // 性能测试
  def time[A](label: String)(block: => A): A = {
    val now = System.currentTimeMillis()
    val ret = block
    println(label + ": " + (System.currentTimeMillis() - now) + " ms.")
    ret
  }

  implicit class S99Int(x: Int) {
    /**
     * 是否是质数
     *
     * 只能被 1 和 本身整除
     **/
    def isPrimeM: Boolean = {
      (x > 1) && (2 to x-1).filter(x % _ == 0).length == 0
    }

    /**
     * 拭除法来验证质数
     * 将 n 除以每个大于1且小于等于 n 的平方根之整数 m。
     * 若存在一个相除为整数的结果，则 n 不是素数；反之则是个素数。
     *
     **/
    def isPrime: Boolean = {
      Stream.from(2).takeWhile { _ <= Math.sqrt(x) }.forall { x % _ != 0 }
    }

    // x, y 是否互质
    def isCoprimeTo(y: Int) = gcd(x, y) == 1

    // 小于 X 并与 X 互质的正整数的个数
    def totient: Int = (1 to x).filter({ x.isCoprimeTo(_) }).length

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

    // 递归法
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

    def primeFactorMultiplicity = 
      P10.encode(this.primeFactors).map(_.swap)

    // 递归法
    def primeFactorMultiplicityR = {
      // y, x => a, b
      // y = (x^a)*b
      def multiplicity(y: Int, x: Int): (Int, Int) = if (y % x != 0) {
        (0, y)
      } else {
        val (a, b) = multiplicity(y/x, x)
        (a+1, b)
      }

      /**
       * n: 要分解的值
       * ps: primeStream, 质数流
       **/
      def proc(n: Int, ps: Stream[Int]): List[(Int, Int)] = {
        if (n.isPrime) List((n, 1))
        else {
          multiplicity(n, ps.head) match {
            case (0, _) => proc(n, ps.tail)
            case (a, b) => (ps.head, a) :: proc(b, ps.tail)
          }
        }
      }
      proc(x, P35.S99Int.primes)
    }

    // 小于 X 并与 X 互质的正整数的个数
    // phi(m) = (p1-1)*p1^(m1-1) * (p2-1)*p2^(m2-1) * (p3-1)*p3^(m3-1) * ...
    // https://zh.wikipedia.org/wiki/%E6%AC%A7%E6%8B%89%E5%87%BD%E6%95%B0
    def totientM: Int = {
      x.primeFactorMultiplicityR map { case (a, b) => (a-1)*Math.pow(a, b-1) toInt } reduce { _*_ }
    }

    // 歌德巴赫猜想
    def goldbach() = {
      def proc(ps: Stream[Int]): (Int, Int) = ps match {
        case n #:: _ if (x-n).isPrime => (n, x-n)
        case _ #:: tail => proc(tail)
      } 
      proc(P35.S99Int.primes)
    }

  }

  object S99Int {
    val primes = Stream.cons(2, Stream.from(3, 2) filter { _.isPrime })
  }

  def listPrimesinRangeM(list: List[Int]) = {
    list.filter(_.isPrime)
  }

  def listPrimesinRange(r: Range) = {
    S99Int.primes.dropWhile(_ < r.start) takeWhile { _ <= r.end }
  }.toList

  /**
   * 求最大公约数
   *
   **/
  def myGcd(a: Int, b: Int): Int = if (b == 0) {
    a
  } else {
    val (x, y) = if (a < b) (a, b) else (b, a)
    myGcd(x, y % x)
  }

  /**
   * 求最大公约数
   * 使用欧几里得算法（Euclid）
   *
   **/
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def  printGoldbachList(r: Range) = {
    for ( i <- r if i % 2 == 0) yield {
      val (a, b) = i.goldbach
      s"$i = $a + $b"
    }
  }

  def  printGoldbachListLimited(r: Range, min: Int) = for {
    i <- r
    if i % 2 == 0
    (a, b) = i.goldbach
    if a > min
  } yield s"$i = $a + $b"
}

