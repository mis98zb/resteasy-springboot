# 简介
一个简单的服务框架，使用resteasy实现JAX-RS服务接口，使用swagger3提供服务规格，使用openfeign作为客户端。
主要的要点有：
* service is split to two parts: interface & implementation
* resteasy on springboot, running with undertow
* openfeign client on okhttp, without springcloud.

# 项目来由

之前在项目中使用spring cloud创建了一套微服务，部署在docker swarm集群上。感觉eureka的功能跟云原生的注册发现格格不入，另外spring mvc性能不高，遂产生了脱离spring cloud使用跟适合云原生机制的技术栈的想法。

然后某天晚上趁着失眠，撸下这个项目的初始代码。

# 各项目介绍

## interface
这是服务的接口部分，定义了服务的interface和vo。

并且使用JAX-RS的注解定义了访问相关的信息（URL、参数、返回类型），使用swagger的注释添加了相关说明。

## service
这是服务的实现部分。

## sample-client
这是客户端访问的例子。展示了怎么脱离springcloud使用openfeign。并且展示如何利用openfieng-jaxrs完全不写客户端访问服务的代码，直接使用`interface`项目里的接口访问服务端，从而达到类似RPC的效果。