package lib.extensions;

import lib.annotaions.KnownIssue;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

public class KnownIssueExtension implements TestExecutionExceptionHandler {

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        if (context.getElement().isPresent()) {
            KnownIssue knownIssue = context.getElement().get().getAnnotation(KnownIssue.class);
            if (knownIssue != null) {
                Assumptions.assumeTrue(false, "Test skipped due to known issue: " + knownIssue.value());
            }
        }
        throw throwable;
    }
}
