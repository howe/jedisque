# Jedisque

Jedisque is a minimal java client for [Disque](http://github.com/antirez/disque "Disque").

Jedisque uses [Jedis](http://github.com/xetorthio/jedis "Jedis") as a redis client.

## How do I use it?

To use it just:

```xml
<repositories>
		<repository>
			<id>nutzcn-snapshots</id>
			<url>https://jfrog.nutz.cn/artifactory/snapshots</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
	</repositories>
	<dependencies>
		<dependency>
            <groupId>com.github.xetorthio</groupId>
            <artifactId>jedisque</artifactId>
            <version>0.0.5-SNAPSHOT</version>
        </dependency>
    </dependencies>
```

jedisque依赖jedis2.7.2, 2.7.3以上版本不向下兼容, 日了狗了, 只能把jedis2.7.2改名打入jedisque里, 只支持快照版
    
```java
Jedisque q = new Jedisque(
			new URI("disque://192.168.0.1:7711"),
			new URI("disque://192.168.0.4:8822")
		);
String jobId = q.addJob("foo", "bar", 10000);
```

```java
Jedisque q = new Jedisque(
			new URI("disque://192.168.0.1:7711"),
			new URI("disque://192.168.0.4:8822")
		);
List<Job> jobs = q.getJob("foo", "foo2");
```

For more usage examples check the [tests](https://github.com/xetorthio/jedisque/blob/master/src/test/java/com/github/xetorthio/jedisque/JedisqueTest.java).

And you are done!
