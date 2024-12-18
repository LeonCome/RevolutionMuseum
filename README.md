# RevolutionMuseum

## 目录
* [背景介绍](#背景介绍)
* [项目介绍](#项目介绍)
	* [数据库设计](#数据库设计)
* [使用说明](#使用说明)
	* [获取代码](#获取代码)
	* [项目环境](#项目环境)
	* [项目配置](#项目配置)
* [其他](#其他)

<a name="背景介绍"></a>
## 背景介绍

*RevolutionMuseum*，灵感来源于井冈山革命博物馆

<a name="项目介绍"></a>
## 项目介绍

*RevolutionMuseum* 的设计初衷是给大家提供一个可线上参观博物馆并且支持纪念品购物的网站。使用了javaweb技术（sevlet+mysql+mvc）。<br>在 *RevolutionMuseum* 中，用户可以浏览**数字博物馆**，从**纪念品购买**处购买纪念品，从**快讯速递**中获得资讯。<br>目前**纪念品购买**以及一些核心部分已经完成开发。只需要逐步完成其他非急需模块的开发即可。但由于个人时间和能力所限，**快讯速递**和**数字博物馆**的后台管理功能还未实现。

<a name="数据库设计"></a>
### 数据库设计

* `user` 表
保存用户信息

| 列名          | 数据类型         | 约束                                   |
| ----------- | ------------ | ------------------------------------ |
| id          | int          | NOT NULL AUTO_INCREMENT, PRIMARY KEY |
| username    | varchar(100) | NOT NULL, UNIQUE                     |
| avatar      | varchar(255) | DEFAULT NULL                         |
| password    | varchar(255) | NOT NULL                             |
| name        | varchar(100) | DEFAULT NULL                         |
| email       | varchar(100) | DEFAULT NULL                         |
| phone       | varchar(20)  | DEFAULT NULL                         |
| address     | varchar(255) | DEFAULT NULL                         |
| is_admin    | tinyint(1)   | DEFAULT '0'                          |
| is_validate | tinyint(1)   | DEFAULT '0'                          |

* `goods` 表
保存商品信息

|列名|数据类型|约束|
|---|---|---|
|id|int|NOT NULL AUTO_INCREMENT, PRIMARY KEY|
|name|varchar(100)|NOT NULL|
|price|decimal(10,2)|NOT NULL|
|stock|int|NOT NULL|
|image|varchar(255)|DEFAULT NULL|

* `cart_item` 表
保存购物车项信息

|列名|数据类型|约束|
|---|---|---|
|id|int|NOT NULL AUTO_INCREMENT, PRIMARY KEY|
|user_id|int|DEFAULT NULL|
|goods_id|int|DEFAULT NULL|
|count|int|NOT NULL|
|total_price|decimal(10,2)|NOT NULL|

* `order_item` 表
保存订单项信息

| 列名              | 数据类型          | 约束                                   |
| --------------- | ------------- | ------------------------------------ |
| id              | int           | NOT NULL AUTO_INCREMENT, PRIMARY KEY |
| user_id         | int           | NOT NULL                             |
| goods_id        | int           | NOT NULL                             |
| order_status_id | int           | NOT NULL                             |
| count           | int           | NOT NULL                             |
| total_price     | decimal(10,2) | NOT NULL                             |

* `order_status` 表
保存订单状态信息

| 列名          | 数据类型        | 约束                                   |
| ----------- | ----------- | ------------------------------------ |
| id          | int         | NOT NULL AUTO_INCREMENT, PRIMARY KEY |
| status_name | varchar(50) | NOT NULL                             |

<a name="使用说明"></a>
## 使用说明

<a name="获取代码"></a>
### 获取代码
* github项目主页 <https://github.com/LeonCome/RevolutionMuseum>

<a name="项目环境"></a>
### 项目环境
* Tomcat 10.1.34
* jdk21
* windows11
* chorme

<a name="项目配置"></a>
### 项目配置
* 还原数据库 ` mysql -u root -p [database_name] < museum.sql `
* 配置IDEA
	1. File-->Open--><你存放的路径>
	2. File-->Project Structure-->十-->Web-->OK
	3. File-->Project Structure-->Modules-->Paths-->Compile output path-->Output Path:<你存放的路径>\IdeaProjects\RevolutionMuseum\web\WEB-INF\classes
	4. File-->Project Structure-->Modules-->Paths-->Compile output path-->Test Output Path:<你存放的路径>\IdeaProjects\RevolutionMuseum\web\WEB-INF\classes
	5. Run-->Edit Configuration-->Application serve-->Configure-->Tomcat Home--><你的Tomcat存放路径>

<a name="其他"></a>
## 其他

时间仓促，功能简陋，望您包涵。
* Email: <linhongtao758@gmail.com>
* QQ:1175779914
