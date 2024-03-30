package taskone;

import taskone.methods.TestClassForAnnotation;
import taskone.testrunner.TestRunner;

/**
 * @author SDudin
 */
public class TaskOneMain {
    public static void main(String[] args) throws Exception {
        try {
            TestRunner.runTests(TestClassForAnnotation.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
