package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to pattern matching in combination with recursion.
 *
 * Recursion is a key concept for the functional style programming.
 * In the exercises below you learn how to apply recursion in combination with Scala's pattern matching facilities.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the corresponding unittest work.
 *
 * Reference material to solve these exercises can be found here:
 * Pattern matching in general: http://programming-scala.labs.oreilly.com/ch03.html#PatternMatching
 * Pattern matching and recursion: http://programming-scala.labs.oreilly.com/ch08.html#Recursion
 */

object RecursionPatternMatchingExercise {

  /**
   * ***********************************************************************
   * Recursive algorithms with pattern matching
   * For expected solution see unittest @RecursionPatternMatchingExerciseTest
   * ***********************************************************************
   */
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  def checkValuesIncrease(seq: Seq[Int]): Boolean = {
    seq match {
      case a::b::c => b > a && checkValuesIncrease(b::c)
      case Seq(a, b) => b > a
      case _ => true
    }
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  def groupConsecutive[T](in: List[T]): List[List[T]] = {
    in match {
      case a::_ => {
        val (consec, remains) = in.span(_ == a)
        consec +: groupConsecutive(remains)
      }
      case _ => List.empty[List[T]]
    }
  }

  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  def groupEquals[T](in: List[T]): List[List[T]] = {
    in match {
      case a::_ => {
        val (equal, remains) = in.partition(_ == a)
        equal +: groupEquals(remains)
      }
      case _ => List.empty[List[T]]
    }
  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  def compress[T](in: List[T]): List[T] = {
    // Note: the tests claim "remove consecutive duplicates", which is
    // different from the above example. We're doing the above, removing
    // all duplicates.
    in match {
      case a::_ => {
        val (equal, remains) = in.partition(_ == a)
        a +: compress(remains)
      }
      case _ => List.empty[T]
    }
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = {
    in match {
      case a::_ => {
        val (equal, remains) = in.partition(_ == a)
        (equal.length, a) +: amountEqualMembers(remains)
      }
      case _ => List.empty[(Int,T)]
    }
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  def zipMultiple(in: List[List[_]]): List[List[_]] = {
    in match {
      case List(f::rest) => List(f) +: zipMultiple(List(rest))
      case (f::rest)::others => {
        val othersZipped = zipMultiple(others)
        (f +: othersZipped.head) +: zipMultiple(rest +: zipMultiple(othersZipped.tail))
      }
      case _ => List.empty[List[_]]
    }
  }

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    // zipMultiple(in.map{_.take(in.map{_.length}.min)})

      in match {
      case List(f::rest) => List(f) +: zipMultiple(List(rest))
      case (f::rest)::others => {
        zipMultipleWithDifferentSize(others) match {
          case othersHead::othersTail => {
            (f +: othersHead) +: {
              zipMultiple(othersTail) match {
                case Nil => List.empty[List[_]]
                case tail => zipMultipleWithDifferentSize(rest +: tail)
              }
            }
          }
          case _ => List.empty[List[_]]
        }
      }
      case _ => List.empty[List[_]]
    }
  }

}
