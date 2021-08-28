# API 接口文档

## 1.1. API V1 接口说明

- 接口基准地址：
- 服务端已开启 CORS 跨域支持
- API V1 认证统一使用 Token 认证
- 需要授权的 API ，必须在请求头中使用 `Authorization` 字段提供 `token` 令牌
- 使用 HTTP Status Code 标识状态
- 数据返回格式统一使用 JSON

### 1.1.1. 支持的请求方法

- GET（SELECT）：从服务器取出资源（一项或多项）。
- POST（CREATE）：在服务器新建一个资源。
- PUT（UPDATE）：在服务器更新资源（客户端提供改变后的完整资源）。
- PATCH（UPDATE）：在服务器更新资源（客户端提供改变的属性）。
- DELETE（DELETE）：从服务器删除资源。
- HEAD：获取资源的元数据。
- OPTIONS：获取信息，关于资源的哪些属性是客户端可以改变的。

### 1.1.2. 通用返回状态说明

| *状态码* | *含义*                | *说明*                                              |
| -------- | --------------------- | --------------------------------------------------- |
| 200      | OK                    | 请求成功                                            |
| 201      | CREATED               | 创建成功                                            |
| 204      | DELETED               | 删除成功                                            |
| 400      | BAD REQUEST           | 请求的地址不存在或者包含不支持的参数                |
| 401      | UNAUTHORIZED          | 未授权                                              |
| 403      | FORBIDDEN             | 被禁止访问                                          |
| 404      | NOT FOUND             | 请求的资源不存在                                    |
| 422      | Unprocesable entity   | [POST/PUT/PATCH] 当创建一个对象时，发生一个验证错误 |
| 500      | INTERNAL SERVER ERROR | 内部错误                                            |
|          |                       |                                                     |

## 1.2. 登录

### 1.2.1. 登录验证接口

- 请求路径：login
- 请求方法：post
- 请求参数

| 参数名   | 参数说明 | 备注     |
| -------- | -------- | -------- |
| username | 用户名   | 不能为空 |
| password | 密码     | 不能为空 |

- 响应参数

| 参数名    | 参数说明 | 备注 |
| --------- | -------- | ---- |
| id        | 用户 ID  |      |
| username  | 用户名   |      |
| avatar    | 头像     | url  |
| book_name | 书名     |      |
| book_desc | 书本描述 |      |
| token     | 令牌     |      |

- 响应数据

```json
{
    "data": {
        "id": 500,
        "username": "admin",
        "bookName": "雪中悍刀行",
        "avatar": "XXXX/XXXX/XXXX.png",
        "bookDesc": "江湖是一张珠帘。大人物小人物，是珠子，大故事小故事，是串线。情义二字，则是那些珠子的精气神。"
        "token": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOjUwMCwicmlkIjowLCJpYXQiOjE1MTI1NDQyOTksImV4cCI6MTUxMjYzMDY5OX0.eGrsrvwHm-tPsO9r_pxHIQ5i5L1kX9RX444uwnRGaIM"
    },
    "meta": {
        "msg": "登录成功",
        "status": 200
    }
}
```

## 1.3. 文章管理

> 备注：
>
> 分为目录上的处理，和文章内容上的处理
>
> 首先获得一个文章列表
>
> 通过文字列表对应的章节id获得对应章节内容
>
> ![image-20210822183011643](https://gitee.com/gezilzq/image-host/raw/master/img/image-20210822183011643.png)



### 1.3.1.文章列表

- 请求路径：passage
- 请求方法：get
- 请求参数

| 参数名 | 参数说明 | 备注     |
| ------ | -------- | -------- |
| id     | 用户id   | 可以为空 |
|        |          |          |

- 响应参数

| 参数名   | 参数说明 | 备注          |
| -------- | -------- | ------------- |
| total    | 总章节数 |               |
| catalogs | 文章目录 | （目录列表 ） |
|          |          |               |

- 响应数据

```json
{
    "data": {
        "totalpage": 5,
        "catalogs": [
            {
                "id": 25,
                "passageName": "第一章 小二上酒",
                "articleLength": "2118",
                "state": "complete",
                "createTime": "2017-11-09T20:36:26.000Z",
                "modificationTime": "2017-11-09T20:36:26.000Z"
            },
            {
                "id": 26,
                "passageName": "第二章 小三上酒",
                "articleLength": "2118",
                "state": "incomplete",
                "createTime": "2017-11-09T20:36:26.000Z",
                "modificationTime": "2017-11-09T20:36:26.000Z",
            }
        ]
    },
    "meta": {
        "msg": "获取成功",
        "status": 200
    }
}
```

### 1.3.2. 添加文章章节

- 请求路径：passage
- 请求方法：post
- 请求参数

| 参数名      | 参数说明 | 备注 |
| ----------- | -------- | ---- |
| passageName | 章节名称 |      |
| id          | 章节ID   |      |

- 响应参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| id     | 章节 ID  |      |
|        |          |      |

- 响应数据

```json
{
    "data": {
        "id": 28,
    },
    "meta": {
        "msg": "章节创建成功",
        "status": 201
    }
}
```

### 1.3.3. 修改文章章节

- 请求路径：passage
- 请求方法：put
- 请求参数

| 参数名      | 参数说明      | 备注                                        |
| ----------- | ------------- | ------------------------------------------- |
| id          | 章节id        |                                             |
| passageName | (new)章节名称 |                                             |
| state       | (new)文章状态 | incomplete-未完成 complete-完成  draft-草稿 |

- 响应参数

| 参数名           | 参数说明 | 备注                                        |
| ---------------- | -------- | ------------------------------------------- |
| id               | 章节 ID  |                                             |
| passageName      | 章节名称 |                                             |
| articleLength    | 字数     |                                             |
| state            | 文章状态 | incomplete-未完成 complete-完成  draft-草稿 |
| createTime       | 创建时间 |                                             |
| modificationTime | 修改时间 | （文章内容的修改与目录的修改均为此值）      |

- 响应数据

```json
{
    "data": {
                "id": 26,
                "passageName": "第一章 小二不上酒",
                "articleLength": "2118",
        		"state": "complete",
                "createTime": "2017-11-09T20:36:26.000Z",
                "modificationTime": "2017-11-09T20:36:26.000Z",
            },
    "meta": {
        "msg": "章节修改成功",
        "status": 201
    }
}
```

### 1.3.4. 删除文章章节

- 请求路径：passage
- 请求方法：delect
- 请求参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
| id     | 章节id   |      |
|        |          |      |

- 响应参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
|        |          |      |
|        |          |      |

- 响应数据

```json
{
    "data": null,
    "meta": {
        "msg": "删除成功",
        "status": 204
    }
}
```



### 1.3.5 获得文章内容

> 该id即为目录上对应的id

- 请求路径：passage/:id
- 请求方法：get
- 请求参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
|        |          |      |
|        |          |      |

- 响应参数

| 参数名         | 参数说明 | 备注 |
| -------------- | -------- | ---- |
| passageContent | 文章内容 |      |
|                |          |      |

- 响应数据

```json
{
    "data": {
        "passageContent": "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX"
    }
    "meta": {
        "msg": "获取成功",
        "status": 201
    }
}
```

### 1.3.6 保存文章内容

> 该id即为目录上对应的id

- 请求路径：passage/:id
- 请求方法：post
- 请求参数

| 参数名         | 参数说明 | 备注 |
| -------------- | -------- | ---- |
| passageContent | 文章内容 |      |
|                |          |      |

- 响应参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
|        |          |      |
|        |          |      |

- 响应数据

```json
{
    "data": null
    "meta": {
        "msg": "保存成功",
        "status": 201
    }
}
```



## 1.4 小说构思图管理

### 1.4.1 保存构思图

- 请求路径：mind
- 请求方法：post
- 请求参数

| 参数名   | 参数说明 | 备注 |
| -------- | -------- | ---- |
| mind_map |          | json |

- 响应参数

| 参数名 | 参数说明 | 备注 |
| ------ | -------- | ---- |
|        |          |      |
|        |          |      |

- 响应数据

```json
{
    "data": null
    "meta": {
        "msg": "保存成功",
        "status": 201
    }
}
```



## 1.5 随记管理

需求不太确定

`note`的增删改（不一定有查）

类型只为文本

可以先写了，也可以后面加上















































