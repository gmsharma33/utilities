package spark;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class InvokeSparkApplication {

    public static void main(String[] args1) throws IOException, InterruptedException {
        // Create a SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("InvokeSparkApplication")
                .master("local")
                .getOrCreate();

        // Submit a Spark job using the spark-submit command
        String jarPath = "/path/to/spark-examples.jar";
        String mainClass = "org.apache.spark.examples.SparkPi";
        String[] args = {"10"};
        String command = "spark-submit --master local[4] --class " + mainClass + " " + jarPath + " " + String.join(" ", args);
        System.out.println("Submitting Spark job: " + command);
        Process process = Runtime.getRuntime().exec(command);
        process.waitFor();

        // Check the status of the Spark job
        int exitCode = process.exitValue();
        if (exitCode == 0) {
            System.out.println("Spark job succeeded");
        } else {
            System.out.println("Spark job failed");
        }
    }
}
