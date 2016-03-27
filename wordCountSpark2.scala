import org.apache.spark.SparkConf
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._

// Load the lines from our input data
val input = sc.textFile ("file:///usr/share/dse/demos/spark/README.txt")

// Split it up into words
val words = input.flatMap(line => line.split(" "))

// Transform the words into pairs 
val pairs= words.map(words => (words, 1))


// Group the pairs by keyc
val counts = pairs.reduceByKey{case (x,y) => x + y}

counts.collect().foreach(println)