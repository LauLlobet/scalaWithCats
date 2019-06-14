import cats.Id

class Chapter4dot3dot1 {


  def pure[A](value: A): Id[A] = value

  def flatMap[A, B](value: Id[A])(func: A => Id[B]): Id[B] = func(value)

 // WHY? def map[A, B](value: Id[A])(func: A => B): Id[B] = flatMap(value)(x => pure(func(x)))

  def map[A, B](value: Id[A])(func: A => B): Id[B] =  pure(func(value))

}
