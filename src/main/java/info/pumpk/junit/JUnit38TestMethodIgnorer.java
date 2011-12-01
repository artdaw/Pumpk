package info.pumpk.junit;

import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;

/**
 * The aim of this class is to just fire "test ignore" message
 * @author Gleb Galkin
 * @since 11/30/11
 */
public final class JUnit38TestMethodIgnorer extends JUnit38ClassRunner {
    private final Class<?> clazz;

    public JUnit38TestMethodIgnorer(Class<?> clazz) {
        super(clazz);
        this.clazz = clazz;
    }

    @Override
    public void run(RunNotifier notifier) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (isTestMethod(method)) {
                Description description = Description.createTestDescription(clazz, method.getName());
                notifier.fireTestIgnored(description);
            }
        }
    }

    private boolean isTestMethod(Method method) {
        return method.getParameterTypes().length == 0 &&
               method.getName().startsWith("test") &&
               method.getReturnType().equals(Void.TYPE);
    }
}
