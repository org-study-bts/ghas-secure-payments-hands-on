package fictional.training;

/**
 * CONTROLLED, FICTIONAL TRAINING FIXTURE. It compiles but is not used by the app.
 * Phase 2 removes this file (or replaces it with a safe API) to demonstrate CodeQL.
 */
final class UnsafeCodeqlDemo {
    private UnsafeCodeqlDemo() {}

    static Process intentionallyUnsafe(String userInput) throws Exception {
        // Deliberately unsafe and obviously non-production: CodeQL should report command injection.
        return Runtime.getRuntime().exec("echo fictional-training-only " + userInput);
    }
}
