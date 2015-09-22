package me.karpenko.codeforces.round321div2

import org.specs2.mutable._

object LongestSequenceSpec extends Specification {

  "LongestSequence" should {
    "test 1" in {
      LongestSequence.findTheLongestSequence(Seq(2, 2, 9)) mustEqual 3
    }

    "test 2" in {
      LongestSequence.findTheLongestSequence(Seq(1,2)) mustEqual 2
    }

    "test 3" in {
      LongestSequence.findTheLongestSequence(Seq(2,2)) mustEqual 2
    }

    "test 4" in {
      LongestSequence.findTheLongestSequence(Seq(2,2,3,3)) mustEqual 4
    }

    "test 5" in {
      LongestSequence.findTheLongestSequence(Seq(2)) mustEqual 1
    }

    "test 6" in {
      LongestSequence.findTheLongestSequence(Seq.empty) mustEqual 0
    }

    "test 7" in {
      LongestSequence.findTheLongestSequence(Seq(2, 2, 1, 3, 4, 1)) mustEqual 3
    }

    "test 8" in {
      LongestSequence.findTheLongestSequence(Seq(0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15)) mustEqual 2
    }

    "test 9" in {
      LongestSequence.findTheLongestSequence(Seq( 1, 9, 3, 8, 11, 4, 5, 6, 4, 19, 7, 1, 7)) mustEqual 3
    }

  }
}