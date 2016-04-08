package a_la_orden

import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

    String authority

    Role(String authority) {
        this()
        this.authority = authority
    }

    static constraints = {
        authority blank: false, unique: true
    }

    static mapping = {
        cache true
    }
}
