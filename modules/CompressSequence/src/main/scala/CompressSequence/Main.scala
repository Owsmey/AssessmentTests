package CompressSequence
import Process.Compressor._
import Process.EmptyInstances._

object Main extends App {
  val input = Iterator.continually(io.StdIn.readLine()).takeWhile(_ != null)
  compress(input).foreach(println)
}
