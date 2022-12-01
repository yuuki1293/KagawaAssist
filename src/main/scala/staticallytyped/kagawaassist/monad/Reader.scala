package staticallytyped.kagawaassist.monad

object Reader {
  implicit class PartReader[A, B](val f: A => B) {
    def map[C](g: B => A => C): A => C = (w: A) => g(f(w))(w)

    def flatMap[C](g: B => A => C): A => C = map(g)

    def foreach(f: B => A => _): Unit = map(f)
  }
}