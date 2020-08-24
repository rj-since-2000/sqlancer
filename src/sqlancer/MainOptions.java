package sqlancer;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;

import sqlancer.Randomly.StringGenerationStrategy;

@Parameters(separators = "=", commandDescription = "Options applicable to all DBMS")
public class MainOptions {

    @Parameter(names = { "--help", "-h" }, description = "Lists all supported options and commands", help = true)
    private boolean help; // NOPMD

    @Parameter(names = {
            "--num-threads" }, description = "How many threads should run concurrently to test separate databases")
    private int nrConcurrentThreads = 16; // NOPMD

    @Parameter(names = {
            "--random-seed" }, description = "A seed value != -1 that can be set to make the query and database generation deterministic")
    private long randomSeed = -1; // NOPMD

    @Parameter(names = { "--num-tries" }, description = "Specifies after how many found errors to stop testing")
    private int totalNumberTries = 100; // NOPMD

    @Parameter(names = { "--max-num-inserts" }, description = "Specifies how many INSERT statements should be issued")
    private int maxNumberInserts = 30; // NOPMD

    @Parameter(names = {
            "--max-expression-depth" }, description = "Specifies the maximum depth of randomly-generated expressions")
    private int maxExpressionDepth = 3; // NOPMD

    @Parameter(names = {
            "--num-queries" }, description = "Specifies the number of queries to be issued to a database before creating a new database")
    private int nrQueries = 100000; // NOPMD

    @Parameter(names = {
            "--num-statement-kind-retries" }, description = "Specifies the number of times a specific statement kind (e.g., INSERT) should be retried when the DBMS indicates that it failed")
    private int nrStatementRetryCount = 1000; // NOPMD

    @Parameter(names = "--log-each-select", description = "Logs every statement issued", arity = 1)
    private boolean logEachSelect = true; // NOPMD

    @Parameter(names = "--log-execution-time", description = "Logs the execution time of each statement (requires --log-each-select to be enabled)", arity = 1)
    private boolean logExecutionTime = true; // NOPMD

    @Parameter(names = "--username", description = "The user name used to log into the DBMS")
    private String userName = "sqlancer"; // NOPMD

    @Parameter(names = "--password", description = "The password used to log into the DBMS")
    private String password = "sqlancer"; // NOPMD

    @Parameter(names = "--print-progress-information", description = "Whether to print progress information such as the number of databases generated or queries issued", arity = 1)
    private boolean printProgressInformation = true; // NOPMD

    @Parameter(names = "--print-progress-summary", description = "Whether to print an execution summary when exiting SQLancer", arity = 1)
    private boolean printProgressSummary; // NOPMD

    @Parameter(names = "--timeout-seconds", description = "The timeout in seconds")
    private int timeoutSeconds = -1; // NOPMD

    @Parameter(names = "--max-generated-databases", description = "The maximum number of databases that are generated by each thread")
    private int maxGeneratedDatabases = -1; // NOPMD

    @Parameter(names = "--exit-code-error", description = "The exit code that should be returned when an error is encountered (or a bug is found)")
    private int errorExitCode = -1; // NOPMD

    @Parameter(names = "--print-statements", description = "Print all statements to stdout, before they are sent to the DBMS (not yet implemented for all oracles)", arity = 1)
    private boolean printStatements; // NOPMD

    @Parameter(names = "--print-succeeding-statements", description = "Print statements that are successfully processed by the DBMS to stdout (not yet implemented for all oracles)", arity = 1)
    private boolean printSucceedingStatements; // NOPMD

    @Parameter(names = "--test-only-nonempty-tables", description = "Test only databases each of whose tables contain at least a single row", arity = 1)
    private boolean testOnlyWithMoreThanZeroRows; // NOPMD

    @Parameter(names = "--pqs-test-aggregates", description = "Partially test aggregate functions when all tables contain only a single row.")
    private boolean testAggregateFunctions; // NOPMD

    @Parameter(names = "--random-string-generation", description = "Select the random-string eneration approach")
    private StringGenerationStrategy randomStringGenerationStrategy = StringGenerationStrategy.SOPHISTICATED; // NOPMD

    @Parameter(names = "--string-constant-max-length", description = "Specify the maximum-length of generated string constants")
    private int maxStringConstantLength = 10; // NOPMD

    @Parameter(names = "--use-constant-caching", description = "Specifies whether constants should be cached and re-used with a certain probability")
    private boolean useConstantCaching = true; // NOPMD

    @Parameter(names = "--constant-cache-size", description = "Specifies the size of the constant cache. This option only takes effect when constant caching is enabled")
    private int constantCacheSize = 100; // NOPMD

    public int getMaxExpressionDepth() {
        return maxExpressionDepth;
    }

    public int getTotalNumberTries() {
        return totalNumberTries;
    }

    public int getNumberConcurrentThreads() {
        return nrConcurrentThreads;
    }

    public boolean logEachSelect() {
        return logEachSelect;
    }

    public boolean printAllStatements() {
        if (printSucceedingStatements && printStatements) {
            throw new AssertionError();
        }
        return printStatements;
    }

    public boolean printSucceedingStatements() {
        if (printStatements && printSucceedingStatements) {
            throw new AssertionError();
        }
        return printSucceedingStatements;
    }

    public boolean logExecutionTime() {
        if (!logEachSelect) {
            throw new AssertionError();
        }
        return logExecutionTime;
    }

    public int getNrQueries() {
        return nrQueries;
    }

    public int getMaxNumberInserts() {
        return maxNumberInserts;
    }

    public int getNrStatementRetryCount() {
        return nrStatementRetryCount;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public boolean printProgressInformation() {
        return printProgressInformation;
    }

    public boolean printProgressSummary() {
        return printProgressSummary;
    }

    public int getTimeoutSeconds() {
        return timeoutSeconds;
    }

    public int getMaxGeneratedDatabases() {
        return maxGeneratedDatabases;
    }

    public int getErrorExitCode() {
        return errorExitCode;
    }

    public long getRandomSeed() {
        return randomSeed;
    }

    public boolean testAggregateFunctionsPQS() {
        return testAggregateFunctions;
    }

    public boolean testOnlyWithMoreThanZeroRows() {
        return testOnlyWithMoreThanZeroRows;
    }

    public StringGenerationStrategy getRandomStringGenerationStrategy() {
        return randomStringGenerationStrategy;
    }

    public int getMaxStringConstantLength() {
        return maxStringConstantLength;
    }

    public boolean useConstantCaching() {
        return useConstantCaching;
    }

    public int getConstantCacheSize() {
        return constantCacheSize;
    }

    public boolean isHelp() {
        return help;
    }

}
