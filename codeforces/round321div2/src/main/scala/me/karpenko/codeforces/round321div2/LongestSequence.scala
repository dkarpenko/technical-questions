package me.karpenko.codeforces.round321div2


object LongestSequence {

  val in = io.Source.stdin.getLines()

  @inline def tokenizeLine = new java.util.StringTokenizer(in.next())
  def readInts(n: Int) = { val stringTokenizer = tokenizeLine; Array.fill(n)(stringTokenizer.nextToken.toInt) }
  def readLongs(n: Int) = { val stringTokenizer = tokenizeLine; Array.fill(n)(stringTokenizer.nextToken.toLong) }
  def readBigs(n: Int) = { val stringTokenizer = tokenizeLine; Array.fill(n)(BigInt(stringTokenizer.nextToken)) }

  def findTheLongestSequenceLength(values: Seq[Int]) = {

    def getTheLongestSequence(lengthOfCurrentSeq: Int, lengthOfTheLongestSeq: Int) =
      if (lengthOfCurrentSeq > lengthOfTheLongestSeq) lengthOfCurrentSeq else lengthOfTheLongestSeq

    def findLongestSequence(passedLength: Int, lengthOfTheLongestSeq: Int, currentValue: Int, values: Seq[Int]): Int = {
      val lengthOfCurrentSeq = passedLength + 1
      val updatedLongestLength = lengthOfCurrentSeq max lengthOfTheLongestSeq

      values.headOption.fold(getTheLongestSequence(lengthOfCurrentSeq, lengthOfTheLongestSeq)){ nextValue =>
        val updatedCurrentSeq = if (nextValue >= currentValue) lengthOfCurrentSeq else 0
        findLongestSequence(updatedCurrentSeq, updatedLongestLength, nextValue, values.tail)
      }
    }

    values.headOption.fold(0) { findLongestSequence(0, 0, _, values.tail) }

  }

  def main(args: Array[String]) {

    val Array(numberOfElements) = readInts(1)

    val moneyPerDay = readInts(numberOfElements)


    val growingPeriod = findTheLongestSequenceLength(moneyPerDay)

    println(growingPeriod)
  }
}