package CompressSequence.Process

trait Empty[T] {
  def emptyValue: T
}

object Empty {
  def apply[T](value: T): Empty[T] = new Empty[T] {
    def emptyValue: T = value
  }
  def isEmpty[T](value: T)(implicit empty: Empty[T]): Boolean = empty.emptyValue == value
}

object EmptyInstances {
  implicit val emptyString: Empty[String] = Empty("")
}