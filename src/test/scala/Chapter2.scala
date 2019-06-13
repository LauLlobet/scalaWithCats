import catshowImplicits.catShow
import org.scalatest.FlatSpec

class Chapter2 extends FlatSpec{

  trait Semigroup[A] {
    def combine(x: A, y: A): A
  }

  trait Monoid[A] extends Semigroup[A] {
    def empty: A
  }

  object Monoid {
    def apply[A](implicit monoid: Monoid[A]) =
      monoid
  }

  object  BooleanMonoid {
    implicit val booleanMonoidAnd: Monoid[Boolean] = new Monoid[Boolean] {
      override def empty: Boolean = true
      override def combine(x: Boolean, y: Boolean): Boolean = x == true && y == true
    }

    //identity false and true ==> false             true and true ===> false
    //associative        ( false & true ) & true === false & (true & true)
    //associative        ( true & true ) & false === true & (true & false)

    implicit val booleanMonoidOr: Monoid[Boolean] = new Monoid[Boolean] {
      override def empty: Boolean = false
      override def combine(x: Boolean, y: Boolean): Boolean = x == true || y == true
    }

    //identity true or false ==> true             false or false ===> false
    //associative        ( false || true ) || true === false || (true || true)
    //associative        ( true || true ) || false === true || (true || false)

  }

  import BooleanMonoid._

  it should "SingleHttpGetshould work " in {
    assert(true == booleanMonoidAnd.combine(true,true))
    assert(false == booleanMonoidAnd.combine(true,false))
    assert(false == booleanMonoidAnd.combine(false,true))
    assert(false == booleanMonoidAnd.combine(false,false))
  }
}
