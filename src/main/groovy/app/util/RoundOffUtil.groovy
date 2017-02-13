package app.util

import java.math.RoundingMode

/**
 * Created by naresha on 13/02/17.
 */
class RoundOffUtil {

    final BigDecimal roundOffBy
    final RoundingMode roundingMode

    public RoundOffUtil(BigDecimal roundOffBy, RoundingMode roundingMode) {
        this.roundOffBy = roundOffBy
        this.roundingMode = roundingMode
    }

    BigDecimal roundOffValue(BigDecimal value) {
        value.divide(roundOffBy, 0, roundingMode) * roundOffBy
    }
}
