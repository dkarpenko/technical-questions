package me.karpenko.codeforces.round321div2

/**
 * http://codeforces.com/contest/581/problem/A
 */
object HipsterSocks {

  val in = io.Source.stdin.getLines()

  @inline def tokenizeLine = new java.util.StringTokenizer(in.next())

  def readInts(n: Int) = {
    val stringTokenizer = tokenizeLine;
    Array.fill(n)(stringTokenizer.nextToken.toInt)
  }

  def solve(leftSocks: Int, rightSocks: Int): (Int, Int) = {
    val coolDays = leftSocks min rightSocks

    val notCoolDays: Int = ((leftSocks max rightSocks) - coolDays) / 2
    (coolDays, notCoolDays)
  }

  def main(args: Array[String]) {
    val Array(leftSocks, rightSocks) = readInts(2)
    val (coolDays, notCoolDays) = solve(leftSocks, rightSocks)
    println(coolDays + " " + notCoolDays)
  }

}
