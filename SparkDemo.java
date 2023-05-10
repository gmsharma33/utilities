package com.journaldev.sparkdemo;

import org.apache.spark.sql.SparkSession;

public class SparkDemo {

    public static void main(String[] args) {
        var spark = SparkSession.builder().appName("test").master("local[*]").getOrCreate();

        spark.sparkContext().hadoopConfiguration().set("fs.s3a.access.key", "AKIA4TANUWPAQAUKQGSH");
        spark.sparkContext().hadoopConfiguration().set("fs.s3a.secret.key", "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");
        spark.sparkContext().hadoopConfiguration().set("fs.s3a.endpoint", "s3.amazonaws.com");

        var b = spark.read().csv("s3a://mallikbucket1111/test.csv");
        b.show();

    }

}
