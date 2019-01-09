import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.VoidFunction;

public class HelloWorld {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("HelloWorld").setMaster("local").setSparkHome("/media/liuzhengri/document/software/spark-2.4.0-bin-hadoop2.7");
        // setMaster指定Master
        // setSparkHome指向安装spark的地址，视环境而定
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> data = sc.textFile("README.md");
        // 加载README.md文件并创建RDD
        data.foreach((VoidFunction<String>) s -> System.out.println(s));
    }
}
