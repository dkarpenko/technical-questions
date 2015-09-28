package me.karpenko.codeforces.round321div2

object EliteHouse {

  val in = io.Source.stdin.getLines()

  @inline def tokenizeLine = new java.util.StringTokenizer(in.next())

  def readInts(n: Int) = {
    val stringTokenizer = tokenizeLine;
    Array.fill(n)(stringTokenizer.nextToken.toInt)
  }

  case class Pair(elements: List[Int], max: Int)

  def solve(houses: Seq[Int]): List[Int] =
    houses.foldRight(Pair(List.empty, 0)) { (currentElement, statusToTheRight) =>
      val maxToTheRight = currentElement max statusToTheRight.max
      val stairsToAdd = if (currentElement > statusToTheRight.max) 0 else statusToTheRight.max - currentElement + 1

      Pair(statusToTheRight.elements.+:(stairsToAdd), maxToTheRight)
    }.elements

  def main(args: Array[String]) {
    val Array(numberOfHouses) = readInts(1)
    val housesHeight = readInts(numberOfHouses)

    println(solve(housesHeight) mkString " ")
  }

}
