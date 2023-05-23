package com.journaldev.sparkdemo;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.functions;

public class FilesCompare {

    public static void main(String[] args) {
        SparkSession spark = SparkSession.builder()
                .appName("File Comparison")
                .master("local[*]")
                .getOrCreate();

// Load the two files into Spark datasets
        Dataset<Row> df1 = spark.read().csv("D:\\spark\\file1.csv").toDF("col1", "col2","col3","col4");
        Dataset<Row> df2 = spark.read().csv("D:\\spark\\file2.csv").toDF("col1", "col2","col3","col4");

        var columns = df1.columns();
// Join the datasets on a common column
        Dataset<Row> joinedDF = df1.join(df2, df1.col("col1").equalTo(df2.col("col1")));

// Compare the values in the two files
        Dataset<Row> resultDF = joinedDF.withColumn("col-2",
                functions.when(df1.col("col2").equalTo(df2.col("col2")), "yes").otherwise("no")).
                withColumn("col-3",
                        functions.when(df1.col("col3").equalTo(df2.col("col3")), "yes").otherwise("no"))
                .withColumn("col-4", functions.when(df1.col("col4").equalTo(df2.col("col4")), "yes").otherwise("no"));

// Collect the results into a local dataset
//        Dataset<Row> resultDF_local = resultDF.select(df1.col("col1"), df1.col("col2"), df2.col("col1"), resultDF.col("value")).cache();

// Display the results
        resultDF.filter((resultDF.col("col-2").contains("no")).or(resultDF.col("col-2").contains("no")).or(resultDF.col("col-4").contains("no"))).show(100);
    }
}
