val testdata = sc.textFile("file:///tmp/kmeans_testdata.txt")
val parsedTestData = testdata.map(s => Vectors.dense(s.split(' ').map(_.toDouble))).cache()

val pr = clusters.predict(parsedTestData)


pr.collect.foreach(println)