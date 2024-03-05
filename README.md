# Running

This project demonstrates that ajc weaves all aspects when doing compile-time weaving, regardless of the aop.xml configuration.

To run it, build both projects e.g. using `cd aspect/ && mvn clean package && cd ../woven-project && mvn clean package` and afterwards run

To see the load-time weaving behaviour, call 
`java --add-opens java.base/java.lang=ALL-UNNAMED -cp target/test-0.1-SNAPSHOT.jar -javaagent:../aspect/target/aspectjtest-0.1-SNAPSHOT.jar de.test.MainClass`

You'll see the outputs prefixed by "=== Call1:", i.e., just `ExampleAspect` is woven.

To see the compile-time weaving behaviour, call

```
ajc -aspectpath ../aspect/target/aspectjtest-0.1-SNAPSHOT.jar -xmlConfigured src/main/resources/META-INF/aop.xml -inpath target/test-0.1-SNAPSHOT.jar -outjar test-instrumented.jar
java -cp test-instrumented.jar:../aspect/target/aspectjtest-0.1-SNAPSHOT.jar de.test.MainClass
```

You'll see the outputs prefixed by "=== Call1:" and "=== Call2:", i.e., both `ExampleAspect` and `SecondExampleAspect` are woven.