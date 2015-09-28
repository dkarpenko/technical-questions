package me.karpenko.codeforces.round321div2

import org.specs2.mutable.Specification

object EliteHouseSpec extends Specification {

  import EliteHouse._

  "1 2 3 1 2" in {
    solve(List(1, 2, 3, 1, 2)) mustEqual (List(3, 2, 0, 2, 0))
  }

  "1 2 3 1 2" in {
    solve(List(3, 2, 1, 4)) mustEqual (List(2, 3, 4, 0))
  }

  "1" in {
    solve(List(1)) mustEqual (List(0))
  }


}