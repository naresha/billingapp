package app.tax

import app.model.ProductCategory
import app.model.StockKeepingUnit
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by naresha on 13/02/17.
 */
class SalesTaxSpec extends Specification {

    @Shared
    SalesTax salesTax = new SalesTax()

    @Unroll("For #product.category sales tax should be #expectedSalesTax %")
    def "sales tax is exempted for books, food, and medicines"() {

        when:
        def applicableTaxPercent = salesTax.calculateTaxPercentage(product)

        then:
        applicableTaxPercent == expectedSalesTax

        where:
        product                                                                   | expectedSalesTax
        new StockKeepingUnit(category: ProductCategory.BOOK, unitPrice: 12.49)    | 0.00
        new StockKeepingUnit(category: ProductCategory.FOOD, unitPrice: 0.85)     | 0.00
        new StockKeepingUnit(category: ProductCategory.MEDICINE, unitPrice: 9.75) | 0.00
        new StockKeepingUnit(category: ProductCategory.OTHER, unitPrice: 18.99)   | 10.00
    }
}
