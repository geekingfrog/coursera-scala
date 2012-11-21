package week2.recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if (c == 0 || c == r) 1
    else
      pascal(c, r - 1) + pascal(c - 1, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {

    def countBalance(charsCopy: List[Char], count: Int): Boolean = {
      if (count < 0) false
      else if (charsCopy.isEmpty) count == 0
      else if (charsCopy.head == '(') countBalance(charsCopy.tail, count + 1)
      else if (charsCopy.head == ')') countBalance(charsCopy.tail, count - 1)
      else countBalance(charsCopy.tail, count)
    }

    countBalance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (coins.isEmpty) 0
    else if (coins.head > money) countChange(money,coins.tail)
    else if (coins.head==money) 1+countChange(money,coins.tail)
    else countChange(money-coins.head,coins) + countChange(money,coins.tail)

  }
}
