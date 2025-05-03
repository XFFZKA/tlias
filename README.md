# Tlias 企业管理系统

## 项目简介
基于 SpringBoot3 + Vue3 的前后端分离项目，实现员工管理、部门管理等功能。

## 环境准备
- JDK 17
- MySQL 5.7+
- Maven 3.6+
- Node.js 16+ (前端依赖)
- Nginx 1.22+ (前端部署)

---

## 快速启动

### 1. 数据库配置
1. **启动 MySQL 服务**  
   
   ```bash
   # Windows
   net start mysql
   # Linux/macOS
   sudo systemctl start mysqld
```
   
2. **修改数据库连接配置**  
   编辑 `tlias-main/src/main/resources/application.yml`：
   ```yaml
   spring:
     datasource:
       driver-class-name: com.mysql.cj.jdbc.Driver
       url: jdbc:mysql://localhost:3306/tlias  # 确保数据库名一致
       username: root                          # 你的MySQL用户名
       password: 173521                        # 你的MySQL密码
   ```

3. **导入数据库脚本**  
   执行项目中的 SQL 文件（`tlias.sql`）：
   
   ```sql
   -- 示例建表语句（实际以项目SQL文件为准）
   CREATE DATABASE IF NOT EXISTS tlias;
   USE tlias;
   CREATE TABLE dept (id INT PRIMARY KEY, name VARCHAR(50), ...);
   INSERT INTO dept VALUES (1, '研发部', ...);
   ```

---

### 2. 后端启动
1. **运行主程序**  
   启动 `tlias-main/src/main/java/com/itheima/TliasWebManagementApplication.java`：


---

### 3. 前端启动
1. **启动 Nginx**  
   双击运行 `tlias-main/nginx-1.22.0-tlias/nginx.exe`（Windows）  
   
2. **访问前端**  
   打开浏览器访问 `http://localhost:90`。

## 
---

## 项目结构
```
tlias-main/
├── src/                # 后端源码
│   ├── main/java       # SpringBoot 主程序
│   └── resources       # 配置文件
├── nginx-1.22.0-tlias/ # 前端编译后的静态文件
└── pom.xml             # Maven 依赖
```

按此文档操作即可完成项目部署。如有问题，请检查日志文件或提交 Issue。