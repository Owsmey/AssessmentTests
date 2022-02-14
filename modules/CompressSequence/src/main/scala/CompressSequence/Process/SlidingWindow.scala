package CompressSequence.Process

case class SlidingWindow[T: Empty](current: Option[T], previous: Option[T]) {
  def slide(other: SlidingWindow[T]): SlidingWindow[T] =
    (other.current, this.current) match {
      case (Some(value), None) if Empty.isEmpty(value) => SlidingWindow.unit
      case _ => SlidingWindow(other.current, this.current)
    }
}

object SlidingWindow {
  def lift[T: Empty](value: T): SlidingWindow[T] = SlidingWindow(Some(value), None)
  def unit[T: Empty]: SlidingWindow[T] = SlidingWindow(None, None)
}
