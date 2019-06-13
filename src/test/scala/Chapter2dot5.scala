import cats.Monoid
import cats.instances.int._    // for Monoid
import cats.syntax.semigroup._
import org.scalatest.FlatSpec
// for Monoid


class Chapter2dot5 extends FlatSpec {

  def add(items: List[Int]): Int =
    items.foldLeft(Monoid[Int].empty)(_ |+| _)

  it should "add all numbers" in {
    assert( 10 == add(List(1,2,3,4)))
  }
}
