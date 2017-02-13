package app.tax

import app.model.StockKeepingUnit
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by naresha on 13/02/17.
 */
class ImportDutySpec extends Specification {

    @Shared
    ImportDuty importDuty = new ImportDuty()

    @Unroll("For imported = #product.imported,  import duty should be #expectedTaxPercent %")
    def "Import duty is applicable only for imported items"() {

        when:
        def importDutyPercent = importDuty.calculateTaxPercentage(product)

        then:
        importDutyPercent == expectedTaxPercent

        where:
        product                               | expectedTaxPercent
        new StockKeepingUnit(imported: false) | 0.00
        new StockKeepingUnit(imported: true)  | 5.00

    }
}
