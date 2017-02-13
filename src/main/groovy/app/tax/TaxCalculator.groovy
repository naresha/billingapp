package app.tax

import app.util.RoundOffUtil

/**
 * Created by naresha on 13/02/17.
 */
class TaxCalculator {
    final RoundOffUtil roundOffUtil

    public TaxCalculator(RoundOffUtil roundOffUtil) {
        this.roundOffUtil = roundOffUtil
    }

    BigDecimal calculateTax(BigDecimal baseAmount, BigDecimal taxPercentage) {
        roundOffUtil.roundOffValue(baseAmount * taxPercentage / 100)
    }
}
