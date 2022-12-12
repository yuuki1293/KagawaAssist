package staticallytyped.kagawaassist.monad

object Reader {
  implicit class PartReader[A, B, C, D](val f: (A, B, C) => D) {
    def map[E](g: D => (A, B, C) => E): (A, B, C) => E = (a: A, b: B, c: C) => g(f(a, b, c))(a, b, c)

    def flatMap[E](g: D => (A, B, C) => E): (A, B, C) => E = map(g)

    def foreach(g: D => (A, B, C) => _): Unit = map(g)
  }
}