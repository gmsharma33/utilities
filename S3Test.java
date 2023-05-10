package com.journaldev.sparkdemo;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class S3Test {

    public static void main(String[] args) throws IOException {
        AWSCredentials awsCredentials = new BasicAWSCredentials("AKIA4TANUWPAQAUKQGSH", "VM3uvVvP1Inijm8o21RDEAPwQpm+7cwgLi3nEqjf");

        AmazonS3 amazonS3Client = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(awsCredentials)).withRegion(Regions.US_EAST_1).build();

        String bucketName = "mallikbucket1111";

        if(amazonS3Client.doesBucketExist(bucketName)) {
            System.out.println("bucket is available");
        }

        List<Bucket> buckets = amazonS3Client.listBuckets();
        buckets.forEach(item -> System.out.println(item.getName()));

        amazonS3Client.putObject(bucketName, "helo.txt", new File("D:\\projects\\JD-Spark-WordCount\\input.txt"));;

        S3Object s3Object = amazonS3Client.getObject(bucketName, "helo.txt");

        S3ObjectInputStream is = s3Object.getObjectContent();
        FileUtils.copyInputStreamToFile(is, new File("Test2.java"));
    }


}
