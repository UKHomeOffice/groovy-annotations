package uk.gov.homeoffice.groovyannotations.data

import uk.gov.homeoffice.groovyannotations.model.Cappuccino

class IngestedDataProvider {

    static Map<String, Cappuccino> cappucinos = new HashMap<>()

    static{
        cappucinos.put("tasty", new Cappuccino("tasty"))
        cappucinos.put("bitter", new Cappuccino("bitter"))
    }

    public static void getData(String key, List input) {
        println("Looking up objects for key "+ key)
        input.add(cappucinos.get(key))
    }
}
