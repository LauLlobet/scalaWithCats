import cats.Show
import cats.instances.int._
import cats.instances.string._
import cats.instances.option._
import cats.syntax.show._
import org.scalatest.FlatSpec      // for show
import cats.Eq

final case class Cat(name: String, age: Int, color: String)

import catshowImplicits._

class Chapter14 extends FlatSpec  {

  behavior of "Chapter14"

  it should "SingleHttpGetshould work " in {
    assert("Garfield is a 15 old blue cat" == catShow.show(Cat("Garfield",15,"blue")))
  }

  it should "ompare equals" in {
    val cat1 = Cat("Garfield",   38, "orange and black")
    val cat2 = Cat("Heathcliff", 33, "orange and black")

    val optionCat1 = Option(cat1)
    val optionCat2 = Option.empty[Cat]

    implicit val catEq: Eq[Cat] =
      Eq.instance[Cat] { (cat1, cat2) =>
        cat1.age == cat2.age &&
        cat1.color == cat2.color &&
        cat1.name === cat2.name
      }


    val catComparer = Eq[Cat]

    val catOptComparer = Eq[Option[Cat]]

    assert(true == catComparer.eqv(cat1,cat1))
    assert(false == catComparer.eqv(cat1,cat2))

    assert(true == catOptComparer.eqv(optionCat1,optionCat1))
    assert(false == catOptComparer.eqv(optionCat1,optionCat2))
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

