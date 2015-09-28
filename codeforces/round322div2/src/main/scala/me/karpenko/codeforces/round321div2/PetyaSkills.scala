package me.karpenko.codeforces.round321div2

/**
 * http://codeforces.com/contest/581/problem/C
 */
object PetyaSkills {

  val in = io.Source.stdin.getLines()

  @inline def tokenizeLine = new java.util.StringTokenizer(in.next())

  def readInts(n: Int) = {
    val stringTokenizer = tokenizeLine;
    Array.fill(n)(stringTokenizer.nextToken.toInt)
  }

  def floorSum(x: Int, res: Int) = res + x / 10

  def calculateRank(skills: Seq[Int]) = skills.foldRight(0)(floorSum)

  case class Accumulator(skills: Seq[Int], availablePoints: Int)

  def solve(accumulator: Accumulator): Int = {
    val skills = distributeSkills(accumulator).skills
    calculateRank(skills)
  }


  def distributeSkills(accumulator: Accumulator): Accumulator = {

    accumulator.skills.foldRight(Accumulator(Seq.empty, accumulator.availablePoints)) { (currentElement, result) =>
      val gap = needTo10(currentElement)
      if (result.availablePoints < gap || currentElement == 100) {
        val skillsWithUnchangedCurrentElement = result.skills.+:(currentElement)
        Accumulator(skillsWithUnchangedCurrentElement, result.availablePoints)
      } else {
        val updatedSkills = result.skills.+:(currentElement + gap)
        val availablePoints = result.availablePoints - gap
        Accumulator(updatedSkills, availablePoints)
      }
    }
  }

  def needTo10(element: Int): Int = {
    10 - element % 10
  }

  def main(args: Array[String]) {

    val Array(numberOfSkills, availablePoints) = readInts(2)
    val currentSkills = readInts(numberOfSkills).sortBy(needTo10)

    println(solve(Accumulator(currentSkills, availablePoints)))
  }

}
