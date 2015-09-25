package me.karpenko.misc.t1

import scala.concurrent.duration._
import scala.concurrent.{Future, _}

object SizeOfDoublyLinkedList {

  def sizeOfList(node: Node): Int = {
    val result = Promise[Int]
    node.getListSize(result)
    Await.result(result.future, 5.seconds)
  }

}
