package no.mesan.fag.patterns.timesheet.facade;

import no.mesan.fag.patterns.timesheet.format.StyleFactory.StyleName;
import org.apache.poi.ss.usermodel.Cell;

/** Celle som inneholder en formel. */
public class FormulaCell extends SheetCell {

    Cell slettMeg; /// HINT ta bort denne, er her bare for å ha import på riktig Cell...

    /** Formelen som skal inn i cellen. */
    private final String formula;

    public FormulaCell(final String formula, final StyleName style) {
        super(style);
        this.formula = formula;
    }

    /** Opprett en SUM-celle. */
    public static FormulaCell formulaSUM(final int fromCol, final int fromRow, final int toCol, final int toRow,
                                         final StyleName style) {
        return new FormulaCell(String.format("SUM(%s)", rangeRef(fromCol, fromRow, toCol, toRow)), style);
    }

    /// HINT @Override protected Cell fillCell(final Cell cell)
}
