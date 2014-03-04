package no.mesan.fag.patterns.scala.timesheet.format

import org.apache.poi.ss.usermodel.{IndexedColors, CellStyle}

//////// Alignment
sealed abstract class Alignment(alignment:Int)

sealed abstract class Horizontal(val alignment:Int) extends Alignment(alignment)
case object HorizontalGen extends Horizontal(CellStyle.ALIGN_GENERAL)
case object HorizontalLeft extends Horizontal(CellStyle.ALIGN_LEFT)
case object HorizontalCenter extends Horizontal(CellStyle.ALIGN_CENTER)
case object HorizontalRight extends Horizontal(CellStyle.ALIGN_RIGHT)

sealed abstract class Vertical(val alignment:Int) extends Alignment(alignment)
case object VerticalTop extends Vertical(CellStyle.VERTICAL_TOP)
case object VerticalMiddle extends Vertical(CellStyle.VERTICAL_CENTER)
case object VerticalBottom extends Vertical(CellStyle.VERTICAL_BOTTOM)

//////// Borders
sealed abstract class BorderEdge
case object BorderTop extends BorderEdge
case object BorderBottom extends BorderEdge
case object BorderLeft extends BorderEdge
case object BorderRight extends BorderEdge

sealed abstract class BorderLine(val color:ColorSpec, val thickness:Int)
case object BorderMedium extends BorderLine(ColorDataGrid, CellStyle.BORDER_MEDIUM)
case object BorderThin extends BorderLine(ColorDataGrid, CellStyle.BORDER_THIN)
case object BorderThick extends BorderLine(ColorDataGrid, CellStyle.BORDER_THICK)

sealed case class BorderSpec(borderLine:BorderLine, borderEdge:BorderEdge)

//////// Colors
sealed abstract class ColorSpec(val colorConst:IndexedColors) {
  def color: Short = colorConst.getIndex
}
case object ColorFg extends ColorSpec(IndexedColors.BLACK)
case object ColorBg extends ColorSpec(IndexedColors.WHITE)
case object ColorHighlight extends ColorSpec(IndexedColors.DARK_BLUE)
case object ColorShadeBg extends ColorSpec(IndexedColors.DARK_BLUE)
case object ColorShadeFg extends ColorSpec(IndexedColors.WHITE)
case object ColorDataGrid extends ColorSpec(IndexedColors.BLACK)