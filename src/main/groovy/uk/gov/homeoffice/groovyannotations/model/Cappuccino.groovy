package uk.gov.homeoffice.groovyannotations.model

import groovy.transform.ToString

@ToString(includePackage =  false)
class Cappuccino {
    String desc

    public Cappuccino(){}

    public Cappuccino(String desc){
        this.desc = desc
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false
        Cappuccino that = (Cappuccino) o
        if (desc != that.desc) return false
        return true
    }

    int hashCode() {
        return desc.hashCode()
    }
}
