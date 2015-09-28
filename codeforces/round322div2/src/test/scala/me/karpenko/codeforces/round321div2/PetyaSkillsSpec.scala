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

}