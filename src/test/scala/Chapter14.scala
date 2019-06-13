import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.syntax.show._
import org.scalatest.FlatSpec      // for show

final case class Cat(name: String, age: Int, color: String)

import catshowImplicits._

class Chapter14 extends FlatSpec  {

  behavior of "Chapter14"

  it should "SingleHttpGetshould work " in {
    assert("Garfield is a 15 old blue cat" == catShow.show(Cat("Garfield",15,"blue")))
  }

}
object catshowImplicits {
  implicit val catShow = Show.show[Cat] {
    cat =>
      val name = cat.name
      val age = cat.age
      val color = cat.color
      s"$name is a $age old $color cat"
  }
}

