# my_app时晴

一个基于 Android 的本地用户认证应用，实现用户注册与登录功能，数据存储于本地 SQLite 数据库，无后端依赖

## 功能列表
- 用户注册（用户名 + 密码）
- 用户登录（验证用户名与密码）
- 本地 SQLite 数据库存储用户信息

## 技术栈
- Java 11
- Android SDK 36（compileSdk & targetSdk）
- Gradle 构建系统
- SQLite（通过 `UsersDao` 和 `UsersDatabaseHelper` 实现数据访问）

## 目录结构概要
```
repo-1/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml          # 应用配置，启动 Activity 为 RegisterActivity
│           ├── java/com/example/my_app/
│           │   ├── LoginActivity.java       # 登录界面逻辑
│           │   ├── RegisterActivity.java    # 注册界面逻辑
│           │   ├── User.java                # 用户实体类
│           │   ├── UsersDao.java            # 用户数据访问层（增查）
│           │   └── UsersDatabaseHelper.java # SQLite 数据库帮助类
│           └── res/
│               ├── layout/
│               │   ├── activity_login.xml   # 登录界面布局
│               │   └── activity_register.xml# 注册界面布局
│               └── ...                      # drawable, mipmap, values 等资源
├── settings.gradle.kts                     # 项目根名：my_app时晴
└── gradlew                                 # Gradle wrapper 启动脚本
```

## 构建与运行
```bash
# 构建 Debug APK
./gradlew assembleDebug

# 安装到设备（需连接设备并启用 USB 调试）
adb install app-debug.apk
```

> 💡 提示：该应用为纯本地客户端，所有用户数据仅保存在设备本地数据库中，不涉及网络请求或远程服务。