# mybaits 代码生成

## 步骤

* 修改src/main/resources/config.properties中的package.name属性，改为指定的包名。
* 修改src/main/resources/generatorConfig.xml，在末尾添加表名和实体类名的映射关系。
* 在项目根目录执行命令 mvn mybatis-generator:generate。elipse或idea都可以预先配置好，直接点击即可生成。
* 注意重新生成时要删除原来的代码，因为实体类和mapper接口可以完全覆盖，但是xml不会覆盖，只会追加。
* 生成的代码在src/main/java中，选择自己需要的代码复制到自己的工作目录下。
* 该项目只用来生成代码，生成的代码不需要提交。

## 规范
* 实体类名为驼峰

## Intellij IDEA 配置
* 在窗口上方选择 Run -> Edit Configurations。
* 点击左上角的“+”按钮，选择Maven。
* 配置Command Line 为 mybatis-generator:generate，Name 为 mybatis-generator。
* 选择OK，配置完成。
* 在Maven Project窗口点开Run Configurations，双击mybatis-generator即可。

##  mybatis-generator官方地址
https://github.com/abel533/Mapper

如果需要分页操作 ，参考如下地址
https://github.com/abel533/Mybatis-Spring