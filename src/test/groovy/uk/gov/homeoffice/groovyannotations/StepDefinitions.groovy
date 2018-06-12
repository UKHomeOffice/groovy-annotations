package uk.gov.homeoffice.groovyannotations

import cucumber.api.java.en.Given
import cucumber.api.java.en.Then
import cucumber.api.java.en.When
import uk.gov.homeoffice.groovyannotations.model.Cappuccino
import uk.gov.homeoffice.groovyannotations.data.IngestedDataProvider

class StepDefinitions {

    @Given("I am thirsty")
    void i_am_thirsty() {
        println("I am thirsty")
    }

    @When("I order a cappuccino")
    void i_order_a_cappuccino() {
        println("I order coffee")
    }

    @Then("I should receive a cappuccino")
    void i_should_receive_a_cappuccino() {
        queryAndCheck(new ArrayList<Cappuccino>())
        queryWithAdditionalArguments(new ArrayList<Cappuccino>(), " cold")
    }

    @ExpectedData(expression = "bitter", maxCount = 1)
    void queryAndCheck(List<Cappuccino> list){
        Cappuccino ingested = list.get(0)
        println("I receive a " + ingested)
        //comparing input with output
        assert ingested.equals(queryActual(ingested))
    }

    @ExpectedData(expression = "tasty", maxCount = 1)
    void queryWithAdditionalArguments(List<Cappuccino> caps, String param){
        Cappuccino ingested = caps.get(0)
        ingested.desc = ingested.desc+ param
        println("I receive a " + ingested)
        //comparing input with output
        assert ingested.equals(queryActual(ingested))
    }

    Cappuccino queryActual(Cappuccino ingested){
        //query actual system for data
        return new Cappuccino(ingested.desc)
    }

}
