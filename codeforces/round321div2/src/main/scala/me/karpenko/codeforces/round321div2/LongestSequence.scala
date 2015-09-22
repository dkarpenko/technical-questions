package me.karpenko.codeforces.round321div2


object LongestSequence {
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


  def findTheLongestSequence(values: Seq[Int]) = {
    values.headOption.fold(0) { findLongestSequence(0, 0, _, values.drop(1)) }
  }

  def main(args: Array[String]) {
    val in = io.Source.stdin.getLines()
    in.next().toInt

    val moneyPerDay = in.next().toString.split(" ").map(_.toInt)

    val growingPeriod = findTheLongestSequence(moneyPerDay)


    val numbers = List(5, 4, 8, 6, 2)
    println(numbers.fold(0) { (z, i) =>
      z + i
    })


    println(growingPeriod)
  }
}