package CompressSequence
import Process.Compressor._
import Process.EmptyInstances._

object Main extends App {
  //val input = Iterator.continually(io.StdIn.readLine()).takeWhile(_ != null)
  val input = Iterator.single("A") ++ Iterator.fill(1)(emptyString.emptyValue) ++ Iterator.single("A")
  compress(input).foreach(println)
}
