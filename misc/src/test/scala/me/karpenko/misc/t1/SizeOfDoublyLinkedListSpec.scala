package me.karpenko.misc.t1

import org.specs2.mutable._

object SizeOfDoublyLinkedListSpec extends Specification {

  implicit val executionContext = scala.concurrent.ExecutionContext.Implicits.global
  "Return 1 when there is only one node" in {
    val node = new TheLeftmostPrintsTheCountNode()
    node.left = None
    node.right = None
    SizeOfDoublyLinkedList.sizeOfList(node) must be_==(1)
  }

  "Size of list of 2" should {
    val left = new TheLeftmostPrintsTheCountNode()
    val right = new TheLeftmostPrintsTheCountNode()
    right.left = Some(left)
    left.right = Some(right)


    "Return 2 when there are two nodes and starting from the left" in {
      SizeOfDoublyLinkedList.sizeOfList(left) must be_==(2)
    }

    "Return 2 when there are two nodes and starting from the right" in {
      SizeOfDoublyLinkedList.sizeOfList(right) must be_==(2)
    }

  }

  "Size of list of 3" should {
    val left = new TheLeftmostPrintsTheCountNode()
    val center = new TheLeftmostPrintsTheCountNode()
    val right = new TheLeftmostPrintsTheCountNode()
    left.right = Some(center)
    center.left = Some(left)
    center.right = Some(right)
    right.left = Some(center)

    "Return 3 when there are two nodes and starting from the right" in {
      SizeOfDoublyLinkedList.sizeOfList(right) must be_==(3)
    }

    "Return 3 when there are two nodes and starting from the center" in {
      SizeOfDoublyLinkedList.sizeOfList(center) must be_==(3)
    }

    "Return 3 when there are two nodes and starting from the left" in {
      SizeOfDoublyLinkedList.sizeOfList(left) must be_==(3)
    }


  }

  "Size of list of 5" should {
    val n1 = new TheLeftmostPrintsTheCountNode()
    val n2 = new TheLeftmostPrintsTheCountNode()
    val n3 = new TheLeftmostPrintsTheCountNode()
    val n4 = new TheLeftmostPrintsTheCountNode()
    val n5 = new TheLeftmostPrintsTheCountNode()
    n1.right = Some(n2)
    n2.left = Some(n1)
    n2.right = Some(n3)
    n3.left = Some(n2)
    n3.right = Some(n4)
    n4.left = Some(n3)
    n4.right = Some(n5)
    n5.left = Some(n4)


    "Return 5 for any starting node" in {

      SizeOfDoublyLinkedList.sizeOfList(n1) must be_==(5)
      SizeOfDoublyLinkedList.sizeOfList(n2) must be_==(5)
      SizeOfDoublyLinkedList.sizeOfList(n3) must be_==(5)
      SizeOfDoublyLinkedList.sizeOfList(n4) must be_==(5)
      SizeOfDoublyLinkedList.sizeOfList(n5) must be_==(5)

    }
  }
}
