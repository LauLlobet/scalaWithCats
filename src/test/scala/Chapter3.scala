import org.scalatest.FlatSpec



sealed trait Tree[+A]

final case class Branch[A](left: Tree[A], right: Tree[A])
  extends Tree[A]

final case class Leaf[A](value: A) extends Tree[A]

class Chapter3 extends FlatSpec{

  def functor[A](value: Tree[A],func: A => A): Tree[A] = value match {
    case Leaf(a) =>  Leaf(func(a))
    case Branch(t1 ,t2 ) => Branch(functor(t1,func),functor(t2,func))
  }

  def duplicate(tree : Tree[Int]) : Tree[Int] = functor(tree, (x :Int) => x*2)

  it should "transform tree " in {
    assert(Branch(Leaf(6),Branch(Leaf(12),Leaf(24))) == duplicate(Branch(Leaf(3),Branch(Leaf(6),Leaf(12)))))
  }

}
