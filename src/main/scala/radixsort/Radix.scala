package radixsort

import scala.annotation.tailrec


object Radix {
  def sortRadix(listRaw: List[String]): List[String] = {

    // get max
    val wMax = listRaw.map(_.length).max

    @tailrec
    def accLSD(listAdj: List[String], chIndx: Int): List[String] = {
      val listParts = listAdj.partition(l => l.length < chIndx + 1)

      chIndx match {
        case -1 => listAdj
        case _ => accLSD(listParts._1 ::: listParts._2.map(str => str(chIndx)).distinct.sorted.flatMap(ch => listParts._2.filter(fstr => fstr(chIndx) == ch)), chIndx - 1)
      }
    }

    accLSD(listRaw, wMax - 1)
  }
}

object Timing {

  def timingSort(listRaw: List[String], f: List[String] => List[String]):Long = {
    val start = System.currentTimeMillis()
    f(listRaw)
    val end = System.currentTimeMillis()
    end - start
  }
}
