import cats.Monoid
import cats.instances.int._    // for Monoid
import cats.syntax.semigroup._
import org.scalatest.FlatSpec


class Chapter2dot5 extends FlatSpec {


  def add[A](items: List[A])(implicit monoid: Monoid[A]): A =
    items.foldLeft(monoid.empty)(_ |+| _)


  import cats.instances.option._ // for Monoid

  it should "add all numbers" in {
    assert( 10 == add(List(1,2,3,4)))
    assert( Some(10) == add(List(Option(1),None,Option(2),Option(3),Option(4))))
  }
}
