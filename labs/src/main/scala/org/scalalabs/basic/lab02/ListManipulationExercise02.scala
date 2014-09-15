package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.reduce{ (first, second) => if (first > second) first else second}
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    (l1 zipAll (l2, 0, 0)).map{case (a,b) => a + b}
    /* (l1, l2) match {
      case (x::xs, y::ys) => (x+y) +: sumOfTwo(xs, ys)
      case (x::xs, ys) => x +: sumOfTwo(xs, ys)
      case (xs, y::ys) => y +: sumOfTwo(xs, ys)
      case (_, _) => List.empty[Int]
    } */
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    l.reduce(sumOfTwo(_, _))
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    List(persons.filter{_.age < 18}, persons.filter{_.age >= 18}).map(_.sortBy(_.age).map(_.firstName))
    
    // var youngins: ListBuffer[Person] = new ListBuffer[Person]()
    // var elders: ListBuffer[Person] = new ListBuffer[Person]()
    // var validYoungNames: ListBuffer[String] = new ListBuffer[String]()
    // var validOldNames: ListBuffer[String] = new ListBuffer[String]()

    // for (person <- persons) {
    //     if (person.age < 18) {
    //       youngins += person
    //     } else {
    //       elders += person
    //     }
    // }

    // var sortedYoung = youngins.toList.sortBy(_.age)
    // var sortedOld = elders.toList.sortBy(_.age)

    // for (young <- sortedYoung) {
    //   validYoungNames += young.firstName
    // }
    // for (old <- sortedOld) {
    //   validOldNames += old.firstName
    // }
    // List(validYoungNames.toList, validOldNames.toList)
  }

}