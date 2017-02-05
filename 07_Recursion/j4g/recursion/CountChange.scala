package j4g.recursion

/**
  * Created by nacho on 05/02/17.
  */
object CountChange extends App {
  def countChange(money:Int, coins:List[Int]): Int = {
    def count(coins: List[Int], acc: Int): Int =
      if (acc > money || coins.isEmpty) 0
      else if (acc == money) 1
      else count(coins, acc + coins.head) + count(coins.tail, acc)
    count(coins, 0)
  }

  println(countChange(4,List(1,2)))
  println(countChange(9,List(1,2,5)))
}
