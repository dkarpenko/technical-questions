package me.karpenko.codeforces.round321div2

import org.specs2.mutable.Specification

object PetyaSkillsSpec extends Specification {

  import PetyaSkills._

  "points: 4, current: 7,9 " in {
    solve(Accumulator(Seq(7, 9), 4)) mustEqual (2)
  }

  "points 8, current: 17, 15, 19" in {
    solve(Accumulator(List(17, 15, 19), 8)) mustEqual (5)
  }

  "points: 2, current: 99, 100" in {
    solve(Accumulator(List(99, 100), 2)) mustEqual (20)
  }

  "points: 0, current: 99, 100" in {
    solve(Accumulator(List(99, 100), 0)) mustEqual (19)
  }

  "points: 10, current: " in {
    solve(Accumulator(List(), 10)) mustEqual (0)
  }
  "points: 0, current: 12" in {
    solve(Accumulator(List(12), 0)) mustEqual (1)
  }

  "points: 200, current: 0, 0" in {
    solve(Accumulator(List(0, 0), 200)) mustEqual (20)
  }

  "points: 2213, current: 17 98 74 91 59 84 87 71 13 9 74 48 75 76 36 25 49 80 25 92 41 24 99 45 98 95 27 54 88 63 25 50 19 43 15 90 58 48 58 83 37 88 35 63 63 23 27 82 80 7 82 93 71 18 85 17 13 2 50 74" in {
    solve(Accumulator(List(17, 98, 74, 91, 59, 84, 87, 71, 13, 9, 74, 48, 75, 76, 36, 25, 49, 80, 25, 92, 41, 24, 99, 45, 98, 95, 27, 54, 88, 63, 25, 50, 19, 43, 15, 90, 58, 48, 58, 83, 37, 88, 35, 63, 63, 23, 27, 82, 80, 7, 82, 93, 71, 18, 85, 17, 13, 2, 50, 74), 2213)) mustEqual (552)
  }

  "points: 700, current: 43,35,51,91,44,51,86,20,64,10,50,40,16,25,37,89,18,44,94,99,18,30,11,27,73,3,90,78,28,98,87,43,85,88,29,93,6,81,78,16" in {
    solve(Accumulator(List(43, 35, 51, 91, 44, 51, 86, 20, 64, 10, 50, 40, 16, 25, 37, 89, 18, 44, 94, 99, 18, 30, 11, 27, 73, 3, 90, 78, 28, 98, 87, 43, 85, 88, 29, 93, 6, 81, 78, 16), 700)) mustEqual (276)
  }

  "points: 108, current: 20 100 99 50 8 78 44 67 91 75 93 53 96 81 96 86 81 0 58 9 51 63 70 73 80 79 28 82 4 15 60 74 19 17 54 81 11 67 71 66" in {
    solve(Accumulator(List(20,100,99,50,8,78,44,67,91,75,93,53,96,81,96,86,81,0,58,9,51,63,70,73,80,79,28,82,4,15,60,74,19,17,54,81,11,67,71,66), 108)) mustEqual (245)
  }

  "points: 44, current: 56" in {
    solve(Accumulator(List(56), 44)) mustEqual (10)
  }


}

