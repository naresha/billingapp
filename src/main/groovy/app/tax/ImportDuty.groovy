package app.tax

import app.model.StockKeepingUnit

/**
 * Created by naresha on 13/02/17.
 */
class ImportDuty {


    public static final BigDecimal NO_IMPORT_DUTY = 0.00
    public static final BigDecimal DEFAULT_IMPORT_DUTY = 5.00

    def calculateTaxPercentage(StockKeepingUnit sku) {
        sku.imported ? DEFAULT_IMPORT_DUTY : NO_IMPORT_DUTY
    }
}
