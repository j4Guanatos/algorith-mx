package j4g.sorting

import scala.io.StdIn.readLine;

/**
  * Banco Azteca is implementing a notification system, to prevent their clients
  * with credit cards and abonos chiquitos y congelados to overflow the limits of their cards.
  * They have a period of d days, in which they calculate the median of these d days
  * and send a notification if the total amount of expenses during a day is
  * equal or greater than two times the calculated median.
  *
  * For example, for the following data,
  *
  *   9 (days of expenses) 5 (days to calculate median)
  *   2 3 4 2 3 6 8 4 5 (expenses data)
  *
  * the client will receive two notifications, on day 6th and 7th.
  * The first 5 days they will not have enough data, as they require 5 days to calculate the median.
  * On 6th day, median of the past expenses is (2,3,4,2,3) = 3, and the expenses are equal to 6,
  * so they will send notification. The same for 7th day, where median(3,4,2,3,6) = 3 and expenses are 8.
  * For the last two days, there will be no notifications as medians are 4 and 4 and expenses 4 and 5.
  *
  * Median is calculated as follows:
  *
  * - Sorted the data, if the length is odd, the element at the middle is taken.
  * - Otherwise, if the length is even, the two elements at the middle are averaged.
  *
  * Given the number of days with expenses, the length of the median calculation and the expenses per day,
  * the problem is to calculate the number of notifications sent to the card owner in the given amount of time.
  */
object BancoAzteca {

  def main(args: Array[String]) {
    val (m,d) = (readLine().split(' ').map(x => x.toInt)) match { case Array(a:Int,b:Int,_*) => (a,b) }
    val data = readLine().split(' ').map(x => x.toInt).toList
    println(notifications(m, d, data))
  }

  def limit(data: List[Int]) = {
    val half = data.length / 2
    if (data.length % 2 == 0) data(half) + data(half-1)
    else data(half) * 2
  }

  def notifications(m:Int, d: Int, data: List[Int]): Int = 1

}
