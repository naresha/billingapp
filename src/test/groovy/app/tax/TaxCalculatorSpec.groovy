package app.tax

import app.util.RoundOffUtil
import spock.lang.Specification
import spock.lang.Unroll

import java.math.RoundingMode

/**
 * Created by naresha on 13/02/17.
 */
class TaxCalculatorSpec extends Specification {

    RoundOffUtil roundOffUtil = new RoundOffUtil(0.05, RoundingMode.UP)
    TaxCalculator taxCalculator = new TaxCalculator(roundOffUtil)

    @Unroll
    def "#taxPercent % tax on #baseAmounnt should be #expectedTax"() {
        when:
        BigDecimal taxAmount = taxCalculator.calculateTax(baseAmount, taxPercent)

        then:
        taxAmount == expectedTax

        where:
        taxPercent | baseAmount | expectedTax
        10.00      | 100.00     | 10.00
        5.00       | 12.49      | 0.65
    }
}
