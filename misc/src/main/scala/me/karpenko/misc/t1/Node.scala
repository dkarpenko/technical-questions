package me.karpenko.misc.t1

import scala.concurrent.{Future, Promise, ExecutionContext}

trait Node {
  implicit val executionContext: ExecutionContext

  // !!!!!!!!!!!!!!
  // Implement these
  def getListSize(resultPromise: Promise[Int]): Future[Int]

  def receiveRight(message: Int, result: Promise[Int]): Unit

  def receiveLeft(message: Int, result: Promise[Int]): Unit
  // END Implement these
  // !!!!!!!!!!!!!!


  // These are implemented for you
  protected def sendLeft(message: Int, resultCallback: Promise[Int]): Unit =
    getLeft.map(_.receiveRight(message, resultCallback))

  protected def sendRight(message: Int, resultCallback: Promise[Int]): Unit =
    getRight.map(_.receiveLeft(message, resultCallback))

  protected def hasLeft(): Boolean = getLeft.isDefined

  protected def hasRight(): Boolean = getRight.isDefined

  protected def getLeft: Option[Node]

  protected def getRight: Option[Node]

  protected def returnResult(count: Int, resultPromise: Promise[Int]) = resultPromise completeWith Future(count)

}
