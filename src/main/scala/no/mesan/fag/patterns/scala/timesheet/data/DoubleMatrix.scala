package no.mesan.fag.patterns.scala.timesheet.data

/**
 * A sort of sparse, associative, two-dimensional array for Doubles.
 *
 * @author lre
 */
class DoubleMatrix extends ValueMatrix[String, String, Double] {
  /**
   * Insert cell, or add to value if already present.
   * @param col Column
   * @param row Row
   * @param value Value to add/insert
   * @return this
   */
  def add(col: String, row: String, value: Double): DoubleMatrix = {
    val v: Double = get(col, row) getOrElse 0
    put(col, row, value + v)
    this
  }
}
