package io.onecraft.spring;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;


/**
 * <p>
 * This class is used to run Cucumber tests in a Spring Boot application. Cucumber is a tool used for Behavior-Driven
 * Development (BDD), which allows you to write application behavior in plain meaningful English text.  The class is
 * annotated with @Suite, which is a JUnit 5 annotation used to specify that the class is a test suite. A test suite is
 * a collection of tests that are intended to be used to test a software program to show that it has some specified set
 * of behaviors.
 * <p>
 * The @IncludeEngines("cucumber") annotation is used to specify that the Cucumber test engine should be used to run the
 * tests. This means that the tests will be run using the Cucumber testing framework.
 * </p>
 * <p>
 * The @SelectClasspathResource("features") annotation is used to specify that the tests should be run using the
 * Cucumber feature files located in the "features" directory in the classpath. This means that the tests will be run
 * using the feature files located in the "features" directory in the classpath.
 * </p>
 * <p>
 * The @ConfigurationParameter annotation is used to specify the glue code that should be used to run the tests. The
 * glue code is the Java code that is used to implement the steps in the feature files. In this case, the glue code is
 * specified as "io.onecraft.spring.api", which means that the tests will be run using the glue code located in the
 * "io.onecraft.spring.api" package in the classpath.
 * </p>
 */
@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "io.onecraft.spring")
public class CucumberRunnerTest {

}