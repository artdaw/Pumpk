package info.pumpk;

import gherkin.GherkinParser;
import gherkin.formatter.Formatter;
import gherkin.formatter.model.*;
import gherkin.util.FixJava;
import info.pumpk.annotations.Feature;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

/**
 * @author Gleb Galkin
 * @since 12/1/11
 */
public class Pumpk extends Runner {
    private Runner runner;
    private Class<?> testClass;

    public Pumpk(Class<?> clazz) throws InitializationError, FileNotFoundException {
        this.testClass = clazz;

        String feature = this.getClass().getClassLoader().getResource(testClass.getAnnotation(Feature.class).path()).getFile();

        GherkinParser parser = new GherkinParser(new Formatter() {
            private Examples examples;
            @Override
            public void uri(String uri) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void feature(gherkin.formatter.model.Feature feature) {
                System.out.println(feature.toMap());
            }

            @Override
            public void background(Background background) {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void scenario(Scenario scenario) {
                System.out.println(scenario.toMap());
            }

            @Override
            public void scenarioOutline(ScenarioOutline scenarioOutline) {
                System.out.println(scenarioOutline.toMap());
            }

            @Override
            public void examples(Examples examples) {
                this.examples = examples;
                System.out.println(examples.toMap());
            }

            @Override
            public void step(Step step) {
                System.out.println(step.toMap());
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void eof() {
                //To change body of implemented methods use File | Settings | File Templates.
            }

            @Override
            public void syntaxError(String state, String event, List<String> legalEvents, String uri, int line) {
                //To change body of implemented methods use File | Settings | File Templates.
            }
        });


        parser.parse(FixJava.readReader(new FileReader(feature)), feature, 0);

    }

    @Override
    public Description getDescription() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void run(RunNotifier notifier) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
