package info.pumpk;

import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;

/**
 * @author Gleb Galkin
 * @since 12/1/11
 */
public class PumpkTestRunner extends Runner {

    Runner runner;

    public PumpkTestRunner(Class<?> clazz) throws InitializationError {
        runner = new BlockJUnit4ClassRunner(clazz);
    }

    @Override
    public Description getDescription() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void run(RunNotifier runNotifier) {
        runner.run(runNotifier);
    }
}
