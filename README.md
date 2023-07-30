# Read Me First

### running graylog app on docker container
```
cd graylog-docker
docker-compose up
```

### configure log4j
```
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE log4j:configuration SYSTEM "http://logging.apache.org/log4j/1.2/apidocs/org/apache/log4j/xml/doc-files/log4j.dtd">
<log4j:configuration>
    <appender name="stdout" class="org.apache.log4j.ConsoleAppender">
        <layout class="org.apache.log4j.PatternLayout">
            <param name="ConversionPattern" value="%d{yyyy-MM-dd HH:mm:ss.SSS} %5p ${PID:- } [%t] --- %-40.40logger{39} : %m%n"/>
        </layout>
    </appender>
    <appender name="graylog" class="org.graylog2.log.GelfAppender">
        <param name="graylogHost" value="127.0.0.1"/>
        <param name="originHost" value="localhost"/>
        <param name="graylogPort" value="12201"/>
        <param name="extractStacktrace" value="true"/>
        <param name="addExtendedInformation" value="true"/>
        <param name="facility" value="log4j"/>
        <param name="Threshold" value="DEBUG"/>
        <param name="additionalFields" value="{'environment': 'default', 'application': 'SpringBootGraylogIntegrationApplication'}"/>
    </appender>
    <root>
        <priority value="DEBUG"/>
        <appender-ref ref="stdout"/>
        <appender-ref ref="graylog"/>
    </root>
</log4j:configuration>
```
### test controller
```
@RestController
@RequestMapping("/api/graylog")
public class TestController {
    private static final Logger logger = LogManager.getLogger(TestController.class);

    @GetMapping("/logger")
    public void test() {
        logger.info("Hello from Spring Boot Graylog Integration Application!");
    }
}
```
### graylog application (http://localhost:9001/system/inputs)
```
Go to Graylog http://127.0.0.1:9000
Log in as admin (admin/admin)
Go to system -> inputs -> select GELF UDP -> Launch new input
```
![Screenshot](https://github.com/OzgurAkinci/spring-boot-graylog-integration/blob/master/git_resources/GelfInputGit.png?raw=true)
