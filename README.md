# Running

This project demonstrates that ajc weaves all classes when doing compile-time weaving, regardless of scope created by the aop.xml configuration.

To run it, build both projects e.g. using `cd aspect/ && mvn clean package && cd ../woven-project && mvn clean package` and afterwards run

To see the load-time weaving behaviour, call 
`java -cp target/test-0.1-SNAPSHOT.jar -javaagent:../aspect/target/aspectjtest-0.1-SNAPSHOT.jar de.test.MainClass`
(or alternatively `java -cp target/test-0.1-SNAPSHOT.jar:../aspect/target/aspectjtest-0.1-SNAPSHOT.jar -javaagent:/home/$USER/.m2/repository/org/aspectj/aspectjweaver/1.9.20.1/aspectjweaver-1.9.20.1.jar de.test.MainClass`)

You'll see the outputs prefixed by "=== Call1:", i.e., just `ExampleAspect` is woven.

To see the compile-time weaving behaviour, call

```
ajc -aspectpath ../aspect/target/aspectjtest-0.1-SNAPSHOT.jar -xmlConfigured src/main/resources/META-INF/aop.xml -inpath target/test-0.1-SNAPSHOT.jar -outjar test-instrumented.jar
java -cp test-instrumented.jar:../aspect/target/aspectjtest-0.1-SNAPSHOT.jar de.test.MainClass
```

You'll see the outputs prefixed by "=== Call1:" also for `ShouldNotBeInstrumented`, but it should only include the methods of the package `de.test`.
