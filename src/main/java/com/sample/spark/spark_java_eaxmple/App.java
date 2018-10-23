package com.sample.spark.spark_java_eaxmple;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;
import org.apache.spark.sql.SparkSession;

public class App 
{
    public static void main( String[] args ){
    	
    	Logger.getLogger("org").setLevel(Level.ERROR);
		SparkSession session = SparkSession
    						   .builder()
    						   .appName("SparkJavaExample")
    						   .master("local[3]")
    						   .getOrCreate();
		
		try(JavaSparkContext context = new JavaSparkContext(session.sparkContext())) {
			List<Integer> list = Arrays.asList(1,2,3,4,5);
			JavaRDD<Integer> javaRDD = context.parallelize(list,3);
			javaRDD.foreach((VoidFunction<Integer>) integer -> System.out.println(integer));
		}
    }
}
