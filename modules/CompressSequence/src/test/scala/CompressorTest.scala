import org.scalatest.flatspec.AnyFlatSpec
import org.scalatestplus.scalacheck.ScalaCheckPropertyChecks
import CompressSequence.Process.EmptyInstances._
import CompressSequence.Process.Compressor._

class CompressorTest extends AnyFlatSpec with ScalaCheckPropertyChecks {
  "Compress" should "remove any number of leading zero-element" in {
    forAll {(n: Int) =>
      whenever(n > 0) {
        val input = Iterator.fill(n)(emptyString.emptyValue)
        assert(compress(input ++ Iterator.single("A")).toList === List("A"))
      }
    }
  }
  it should "remove any number of trailing zero-element" in {
    forAll { (n: Int) =>
      whenever(n > 0) {
        val input = Iterator.fill(n)(emptyString.emptyValue)
        assert(compress(Iterator.single("A") ++ input).toList === List("A"))
      }
    }
  }
  it should "reduce any number of zero-element in-between to one" in {
    forAll { (n: Int) =>
      whenever(n > 0) {
        val input1 = Iterator.fill(n)(emptyString.emptyValue)
        val input2 = Iterator.fill(n)(emptyString.emptyValue)
        assert(
          compress(Iterator.single("A") ++ input1 ++ Iterator.single("A") ++ input2 ++ Iterator.single("A")).toList ===
            List("A", emptyString.emptyValue, "A", emptyString.emptyValue, "A")
        )
      }
    }
  }
  it should "works properly on example :)" in {
    val input = List("", "abc", "123", "", "x", "", "", "y", "", "").iterator
    assert(compress(input).toList === List("abc", "123", "", "x", "", "y"))
  }
}
