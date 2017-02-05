package j4g.recursion

/**
  * Created by nacho on 05/02/17.
  */
object Flattener extends App {

  def flatten(obj: Any): List[Any] = obj match {
    case arr: List[_] => if (arr.isEmpty) List() else flatten(arr.head) ::: flatten(arr.tail)
    case _ => List(obj)
  }

  println(flatten(1))
  println(flatten(List(1,2,3)))
  println(flatten(List(1,2,List(3,4,5,List(6,7),8),9,10,List(11,12),13)))
}
