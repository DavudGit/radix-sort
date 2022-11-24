import org.scalatest.funsuite.AnyFunSuite
import org.scalatest.matchers.should.Matchers
import radixsort.Radix
import radixsort.Timing

class RadixTest extends AnyFunSuite with Matchers {

  test("Radix Sort Should Sort Properly List") {
    val listExpected = List("Zcz", "abc", "afa", "xea")
    val listActual = List("xea", "afa", "Zcz", "abc")
    val sorted = Radix.sortRadix(listActual)

    assert(sorted == listExpected)

  }

  test("Radix Sort Should Sort different size List") {
    val listExpected = List("ZZZZ","Zaa", "abc","abc ", "abd", "def" )
    val listActual = List("abd", "def", "Zaa", "abc","ZZZZ","abc ")
    val sorted = Radix.sortRadix(listActual)

    assert(sorted == listExpected)
  }

  test( " timing should run without error"){
    val listRaw = List("ZZZZ","Zaa", "abc","abc ", "abd", "def" )
    val time = Timing.timingSort(listRaw,Radix.sortRadix)
  }

}
