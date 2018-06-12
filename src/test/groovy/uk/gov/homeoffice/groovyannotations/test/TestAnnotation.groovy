package uk.gov.homeoffice.groovyannotations.test

import uk.gov.homeoffice.groovyannotations.ExpectedData
import uk.gov.homeoffice.groovyannotations.model.Cappuccino

class TestAnnotation {

    @ExpectedData(expression = "tasty", maxCount = 1)
    void expectation(List<Cappuccino> list) {
        println("Expectation " + list.size())
    }
}
