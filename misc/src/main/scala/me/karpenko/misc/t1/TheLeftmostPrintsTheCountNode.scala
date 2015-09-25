package me.karpenko.misc.t1

import scala.concurrent.{Future, Promise, ExecutionContext}

class TheLeftmostPrintsTheCountNode(implicit context: ExecutionContext) extends Node {

  def getListSize(callback: Promise[Int]): Future[Int] = {

    if (!hasLeft() && !hasRight()) returnResult(1, callback)
    else if (hasRight()) sendRight(-1, callback)
    else if (hasLeft()) sendLeft(1, callback)

    callback.future
  }

  override def receiveLeft(message: Int, callback: Promise[Int]): Unit =
    if (hasRight()) sendRight(-1, callback) else sendLeft(1, callback)

  override def receiveRight(message: Int, callback: Promise[Int]): Unit =
    if (hasLeft()) sendLeft(message + 1, callback) else returnResult(message + 1, callback)

  override implicit val executionContext: ExecutionContext = context

  def getLeft: Option[Node] = left

  def getRight: Option[Node] = right

  var left: Option[Node] = None
  var right: Option[Node] = None

}