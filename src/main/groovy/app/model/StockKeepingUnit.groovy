package app.model

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

/**
 * Created by naresha on 13/02/17.
 */
@EqualsAndHashCode(includes = 'description')
@ToString(includeNames = true)
class StockKeepingUnit {
    String description
    ProductCategory category
    BigDecimal unitPrice
    boolean imported

}
