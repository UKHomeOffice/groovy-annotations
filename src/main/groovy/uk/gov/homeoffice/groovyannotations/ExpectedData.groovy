package uk.gov.homeoffice.groovyannotations

import org.codehaus.groovy.transform.GroovyASTTransformationClass;

import java.lang.annotation.ElementType
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target([ElementType.METHOD])
@Retention(RetentionPolicy.SOURCE)
@GroovyASTTransformationClass("uk.gov.homeoffice.groovyannotations.ExpectedDataTransformation")
@interface ExpectedData {
    String expression()
    int maxCount() default 1
}
