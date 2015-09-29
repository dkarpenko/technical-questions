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

  def calculateRank(accumulator: Accumulator) = accumulator.skills.foldRight(0)(floorSum)

  case class Accumulator(skills: Seq[Int], points: Int)

  def solve(accumulator: Accumulator): Int = {
    def validForProcessing: Boolean = accumulator.skills.isEmpty || accumulator.points == 0
    val skills = if (validForProcessing) accumulator else improveSkills(accumulator)
    calculateRank(skills)
  }


  def improveSkills(accumulator: Accumulator): Accumulator = {

    def canNotBeIncreased(currentElement: Int, availablePoints: Int, gap: Int): Boolean = 
      availablePoints < gap || currentElement == 100
    
    def canImproveSkills(profile: Accumulator) = profile.skills.head < 100 && profile.points >= needTo10(profile.skills.head)

    val sortedSkills = accumulator.skills.sortBy(x => ((x % 10, x)))

    val updatedProfile = sortedSkills
      .foldRight(accumulator.copy(skills = Seq.empty)) { (currentSkill, profile) =>
      
      val gap = needTo10(currentSkill)
      if (canNotBeIncreased(currentSkill, profile.points, gap)) {
        val skillsWithUnchangedCurrentElement = profile.skills.+:(currentSkill)
        Accumulator(skillsWithUnchangedCurrentElement, profile.points)
      } else {
        val updatedSkills = profile.skills.+:(currentSkill + gap)
        val availablePoints = profile.points - gap
        
        Accumulator(updatedSkills, availablePoints)
      }
    }

    
    if (canImproveSkills(updatedProfile)) {
      improveSkills(updatedProfile.copy(skills = updatedProfile.skills))
    } else {
      updatedProfile
    }

  }

  def needTo10(element: Int): Int = {
    10 - element % 10
  }

  def main(args: Array[String]) {

    val Array(numberOfSkills, availablePoints) = readInts(2)

    val currentSkills = readInts(numberOfSkills)

    println(solve(Accumulator(currentSkills, availablePoints)))
  }

}
