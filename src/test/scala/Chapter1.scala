import org.scalatest.FlatSpec

import PrintableInstances._

class Chapter1 extends FlatSpec  {

  behavior of "Chapter1"

  it should "SingleHttpGetshould work " in {
    assert(PrintableObj.format(123) == "123-" )
  }
}

trait Printable[A] {
  def format(value :A): String
}

object PrintableObj {
  def format[A](toFormat: A)(implicit printable: Printable[A]): String = printable.format(toFormat)
}

object  PrintableInstances {
  implicit val  PrintableInt: Printable[Int] = new Printable[Int] {
    override def format(value: Int) = value+"-"
  }

  implicit val  PrintableString: Printable[String] = new Printable[String] {
    override  def format(value: String): String = value+"-"
  }
}