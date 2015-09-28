package me.karpenko.codeforces.round321div2

import org.specs2.mutable.Specification


object HipsterSocksSpec extends Specification {

  import HipsterSocks._

  "3 1" in {
    solve(3, 1) mustEqual ((1, 1))
  }

  "2 3" in {
    solve(2, 3) mustEqual ((2, 0))
  }
  "7 3" in {
    solve(7, 3) mustEqual ((3, 2))
  }

  "0 1" in {
    solve(0, 1) mustEqual ((0, 0))
  }
}