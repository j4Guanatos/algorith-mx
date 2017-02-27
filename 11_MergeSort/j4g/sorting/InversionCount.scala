package j4g.sorting

import java.io.File
import java.util.Scanner

import scala.io.StdIn.readLine

/**
 * Scala implementation of the inversion counter.
 */
object InversionCount {

  val path = "11_MergeSort/io/"

  def cut(arr: Array[Int], len: Int) = arr.mkString take len

  def isSorted(arr: Array[Int], p: Int, q: Int) = {
    def isSorted(i: Int): Boolean =
      if (i == q) true
      else if (arr(i) > arr(i+1)) false
      else isSorted(i + 1)
    require(p <= q)
    isSorted(p)
  }

  def swaps(arr: Array[Int], aux: Array[Int])(p: Int, q: Int): Long = {
    val mid = (p + q) / 2
    val ops = swaps(arr, aux) _
    def merge(i: Int, j: Int, k: Int): Int = {
      if (k > q) 0
      else {
        arr(k) = if (arr(i) <= arr(j) || j > q) aux(i) else aux(j)
        merge(if (arr(i) > arr(j)) 1 else 0



      while (k <= q) {
        {
          if (i > mid) arr(k) = aux({
            j += 1; j - 1
          })
          else if (j > q) arr(k) = aux({
            i += 1; i - 1
          })
          else if (aux(i) > aux(j)) {
            count += mid - i + 1
            arr(k) = aux({
              j += 1; j - 1
            })
          }
          else arr(k) = aux({
            i += 1; i - 1
          })
        }
        {
          k += 1; k - 1
        }
      }

      return count
    }
    if (isSorted(arr, p, q)) 0
    else ops(p, mid) + ops(mid + 1, q) + merge(p, mid, q)
  }

  def swaps(arr: Array[Int]) = swaps(arr, arr.clone)(0, arr.length - 1)

  def main(args: Array[String]): Unit = {
    val file = readLine()
    val in = new Scanner(new File(path + file + ".in"))
    val out = new Scanner(new File(path + file + ".out"))
    val cases = in.nextInt()

    for (it <- 1 to cases) {
      val n = in.nextInt()
      in.nextLine()
      val arr = in.nextLine().split(' ').map(x => x.toInt)
      printf("| Case %d | n = %d arr = %s | Res: %d | Exp: %d |\n", it, n, cut(arr,50), swaps(arr), out.nextLong())
    }
  }
}
