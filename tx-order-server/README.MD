## 说明

### 第一步：pom文件加入eureka
        <!--注册中心-->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
        </dependency>
        <!--spring boot-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

    
### 第二步：加入application.properties 配置文件
```
spring.application.name=tx-order
server.port=8081


eureka.client.serviceUrl.defaultZone=http://127.0.0.1:8761/eureka/

#默认是hostname 注册，改成IP 注册
eureka.instance.perferIpAddress=true
```

### 第三步：加入启动类 OrderApplication


### 第四步：引入mybatis自动生成类 
1.采用mybatis-generator 自动生成文件
2.pom文件，加入mybatis的依赖包
  <!--Mybatis-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
        </dependency>
        <!-- Mybatis Generator -->
        <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <scope>compile</scope>
            <optional>true</optional>
        </dependency>
        <!--分页插件-->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper</artifactId>
        </dependency>
        <!--通用Mapper-->
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper</artifactId>
        </dependency>
        <dependency>
            <groupId>tk.mybatis</groupId>
            <artifactId>mapper-spring-boot-starter</artifactId>
        </dependency>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>

3.配置文件，增加数据库配置信息
    mybatis.mapper-locations=classpath*:com/agan/transaction/order/mapper/xml/*.xml
    spring.datasource.driverClassName=com.mysql.jdbc.Driver
    spring.datasource.url=jdbc:mysql://192.168.0.138:3308/tx_order?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull
    spring.datasource.username=root
    spring.datasource.password=agan
    
4.启动类加入 mapper的包路径
@MapperScan("com.agan.transaction.order.mapper")
注意：tk.mybatis.spring.annotation.MapperScan


### 第五步：实现服务之间的feign通信
1.在pom文件中加入依赖的feign jar包
       <!--feign 客户端 -->
        <dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-starter-openfeign</artifactId>
        </dependency>
        <!--库存api-->
        <dependency>
            <artifactId>tx-inventory-api</artifactId>
            <groupId>com.agan.transaction</groupId>
            <version>0.0.1-SNAPSHOT</version>
        </dependency>
        
2.在启动类 加入feign的注解
    @EnableFeignClients(basePackages = {"com.agan.transaction.inventory.api"})
注意：如果不加的话，spring加载不了InventoryApi类。

### 第六步：映入hmily的分布式事务框架
1.pom加入分布式事务框架的依赖包
        <hmily.version>2.0.2-RELEASE</hmily.version>
        <!--hmily分布式事务框架-->
        <dependency>
            <groupId>org.dromara</groupId>
            <artifactId>hmily-springcloud</artifactId>
            <version>${hmily.version}</version>
            <exclusions>
                <exclusion>
                    <groupId>org.slf4j</groupId>
                    <artifactId>slf4j-log4j12</artifactId></exclusion>
                <exclusion>
                    <groupId>log4j</groupId>
                    <artifactId>log4j</artifactId>
                </exclusion>
            </exclusions>
        </dependency>
2.配置文件改动
  加入hmily的配置文件applicationContext.xml
3.启动类的改动
  引入 @ImportResource({"classpath:applicationContext.xml"})
  剔除 @SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
  