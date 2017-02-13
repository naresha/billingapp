package app.util

import spock.lang.Specification
import spock.lang.Unroll

import java.math.RoundingMode

/**
 * Created by naresha on 13/02/17.
 */
class RoundOffUtilSpec extends Specification {
    RoundOffUtil roundOffUtil = new RoundOffUtil(0.05, RoundingMode.UP)

    @Unroll
    def "#value when rounded off should be #expectedResult"() {
        when:
        def roundedOffValue = roundOffUtil.roundOffValue(value)

        then:
        roundedOffValue == expectedResult

        where:
        value | expectedResult
        1.04  | 1.05
        1.00  | 1.00
        1.05  | 1.05
        1.051 | 1.10

    }

}
