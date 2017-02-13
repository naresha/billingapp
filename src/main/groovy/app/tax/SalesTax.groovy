package app.tax

import app.model.ProductCategory
import app.model.StockKeepingUnit

/**
 * Created by naresha on 13/02/17.
 */
class SalesTax {

    private static final List<ProductCategory> EXEMPTED_CATEGORIES = [
            ProductCategory.BOOK,
            ProductCategory.FOOD,
            ProductCategory.MEDICINE
    ]
    public static final BigDecimal NO_TAX = 0.00
    public static final BigDecimal DEFAULT_TAX_PERCENT = 10.00

    def calculateTaxPercentage(StockKeepingUnit sku) {
        sku.category in EXEMPTED_CATEGORIES ? NO_TAX : DEFAULT_TAX_PERCENT
    }
}
