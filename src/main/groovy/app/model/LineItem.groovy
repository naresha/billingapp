package app.model

/**
 * Created by naresha on 13/02/17.
 */
class LineItem {
    String description
    Integer quantity
    BigDecimal unitPrice
    BigDecimal applicableTaxes = 0.00


    BigDecimal getSellingPriceBeforeTax() {
        unitPrice * quantity
    }

    BigDecimal getSellingPriceWithTax() {
        sellingPriceBeforeTax + applicableTaxes
    }


}
