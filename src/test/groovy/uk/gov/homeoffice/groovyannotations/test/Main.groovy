package uk.gov.homeoffice.groovyannotations.test
import uk.gov.homeoffice.groovyannotations.model.Cappuccino

class Main {

    static void main(String[] args) throws Exception {
        GroovyClassLoader gc = new GroovyClassLoader()
        def clazz = gc.parseClass(new File
                ("./src/test/groovy/uk/gov/homeoffice/groovyannotations/test/TestAnnotation.groovy"))
        def ta = clazz.newInstance()
        ta.expectation(new ArrayList<Cappuccino>())
    }

}
