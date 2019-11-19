# Swagger是什么

Swagger是一款RESTFUL风格的接口文档在线自动生成+功能测试中间软件，用于生成、描述、调用和可视化RESTFUL风格的Web服务。
目标是使客户端和文件系统作为服务器以同样的速度来更新文件的方法,参数和模型紧密集成到服务器。

# 为什么要用Swagger

## 后端角度

1. 不用手写接口文档 避免手写接口文档发生的错误
2. 采用全注解方式 代码侵入性低 开发简单
3. 参数修改可以自动维护 不用手动添加

## 前端角度

1. 接口文档自动生成 功能参数一目了然
2. 实时检查参数及返回值 联调方便

## 测试角度
  
在前端还没完成开发时 可以直接测试接口 操作简便
  
#  如何搭建Swagger

1. 导入Jar包
  
    ```
    <!-- swagger -->
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger-ui</artifactId>
        <version>2.9.2</version>
    </dependency>
    
    <dependency>
        <groupId>io.springfox</groupId>
        <artifactId>springfox-swagger2</artifactId>
        <version>2.9.2</version>
    </dependency>
    ```
  
2. 配置Config
  
    ![SwaggerConfig配置](https://github.com/GengRui01/Picture/blob/master/MySwaggerDemo/swaggerConfig.png)
