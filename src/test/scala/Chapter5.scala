import org.scalatest.FlatSpec
import cats.Monad
import cats.instances.option._ // for Monad
import cats.instances.list._   // for Monad

import scala.language.higherKinds

trait MonadManual[F[_]] {
  def pure[A](a: A): F[A]

  def flatMap[A, B](value: F[A])(func: A => F[B]): F[B]

  def map[A, B](value: F[A])(func: A => B): F[B] = flatMap(value)(x => pure(func(x)))
}


class Chapter5 extends FlatSpec{


}
