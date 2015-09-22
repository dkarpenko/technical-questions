package me.karpenko.codeforces.round321div2


object LongestSequence {

  def findTheLongestSequenceLength(values: Seq[Int]) = {
    
    def getTheLongestSequence(lengthOfCurrentSeq: Int, lengthOfTheLongestSeq: Int) =
      if (lengthOfCurrentSeq > lengthOfTheLongestSeq) lengthOfCurrentSeq else lengthOfTheLongestSeq

    def findLongestSequence(passedLength: Int, lengthOfTheLongestSeq: Int, currentValue: Int, values: Seq[Int]): Int = {
      val lengthOfCurrentSeq = passedLength + 1
      val updatedLongestLength = if (lengthOfCurrentSeq > lengthOfTheLongestSeq) lengthOfCurrentSeq else lengthOfTheLongestSeq

      values.headOption.fold(getTheLongestSequence(lengthOfCurrentSeq, lengthOfTheLongestSeq)){ nextValue =>
        val updatedCurrentSeq = if (nextValue >= currentValue) lengthOfCurrentSeq else 0
        findLongestSequence(updatedCurrentSeq, updatedLongestLength, nextValue, values.tail)
      }
    }

    values.headOption.fold(0) { findLongestSequence(0, 0, _, values.tail) }

  }

  def main(args: Array[String]) {
    val in = io.Source.stdin.getLines()
    in.next().toInt

    val moneyPerDay = in.next().toString.split(" ").map(_.toInt)

    val growingPeriod = findTheLongestSequenceLength(moneyPerDay)

    println(growingPeriod)
  }
}