package CompressSequence.Process

object Compressor {

  /** Возвращает Iterator[T] сжатый по нулевому значению, определенному инстансом Empty[T]
   *  Любое колличество префиксных и постфиксных нулей будут отброшены
   *  Подряд идущие нулевые значения будут заменены на одно вхождение нулевого значения
   *  @tparam T тип значений, генерируемых итератором
   *  @param it Исходный итератор
   *  @return  итератор, содержащий результат преобразований над исходным итератором
   *  @note Требует инстанс Empty[T]
   */
  def compress[T : Empty](it: Iterator[T]): Iterator[T] = {
    val enrichedSeq = it.map(SlidingWindow.lift[T]) ++ Iterator(SlidingWindow.unit[T])
    //Не использовал обычный слайд, т.к. буффер в scanLeft позволяет имитировать модификацию значения
    enrichedSeq.scanLeft(SlidingWindow.unit[T])(_ slide _)
      .filter(value => (value.current, value.previous) match {
        case (_, None) => false
        case (Some(v1), Some(v2)) if Empty.isEmpty(v1) && Empty.isEmpty(v2) => false
        case (None, Some(v)) if Empty.isEmpty(v) => false
        case _ => true
      })
      .map(_.previous.get) //Не может выкинуть NoSuchElementException из-за фильтра case (_, None) => false
  }

}
