# groovy-annotations

Demonstrates the use of annotations and expressions to inject test data into code

## Example

Check out the Main class and the SerenityRunner

```groovy

 @ExpectedData(expression = "bitter", maxCount = 1)
 void queryAndCheck(List<Cappuccino> list){
 }
 
```

The expression "bitter" is used to dynamically look up and inject test data into the method. 

This mechanism can be extended to query different datasources by mapping expressions to sql queries, elastic search indexes or any other custom datasource.

## Trace of run

```groovy

Created runtime cucumber.runtime.RuntimeOptions@7d8704efI am thirsty
I order coffee
Looking up objects for key bitter
I receive a Cappuccino(bitter)
Looking up objects for key tasty
I receive a Cappuccino(tasty cold)

1 Scenarios (1 passed)
3 Steps (3 passed)
0m0.772s

```
