import org.scalatest.FlatSpec

class Chapter4dot6dot5 extends FlatSpec{
  it should "fold right as the usual implementation" in {
    assert(110 == List(1,2,3,4).foldRight(100)(_+_))
  }

}
