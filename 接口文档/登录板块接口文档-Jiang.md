# 注册

1.基本信息

>请求路径：/user/register
>
>请求方式：POST
>
>接口描述：该接口用于注册用户

2.请求参数

- 参数格式：application/json

- 参数说明：

  | 参数名   | 类型   | 是否必须 | 备注   |
  | -------- | ------ | -------- | ------ |
  | username | String | 是       | 用户名 |
  | password | String | 是       | 密码   |
  | phone    | String | 是       | 手机号 |

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名  | 类型   | 是否必须 | 备注                           |
  | ------- | ------ | -------- | ------------------------------ |
  | code    | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message | string | 非必须   | 提示信息                       |
  | data    | object | 非必须   | 返回数据                       |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "msg": "success",
    "data": null
}
```



# 登录

1.基本信息

>请求路径：/user/login
>
>请求方式：POST
>
>接口描述：该接口用于登录

2.请求参数

- 参数格式：application/json

- 参数说明：

  | 参数名   | 类型   | 是否必须 | 备注   |
  | -------- | ------ | -------- | ------ |
  | username | String | 是       | 用户名 |
  | password | String | 是       | 密码   |

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名  | 类型   | 是否必须 | 备注                           |
  | ------- | ------ | -------- | ------------------------------ |
  | code    | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message | string | 非必须   | 提示信息                       |
  | data    | object | 非必须   | 返回数据                       |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "message": "success",
    "data": "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiIxIiwidXNlcm5hbWUiOiJ6aGFuZ3NhbiIsImV4cCI6MTY5MzEwMjEyNX0._hlqnnVmlNWHCLzlBSs7f9XaMCFBRByPRmhkjulKS6M"
}
```



# 邮箱找回密码

###   邮箱验证：

1.基本信息

>请求路径：/findCode/retrieveEmail
>
>请求方式：POST
>
>接口描述：该接口用于验证邮箱、以及发送验证码

2.请求参数

- 参数格式：Content-Type:application/x-www-form-urlencoded

- 参数说明：

  | 参数名 | 类型   | 是否必须 | 备注 |
  | ------ | ------ | -------- | ---- |
  | email  | String | 是       | 邮箱 |

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名  | 类型   | 是否必须 | 备注                           |
  | ------- | ------ | -------- | ------------------------------ |
  | code    | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message | string | 非必须   | 提示信息                       |
  | data    | object | 非必须   | 返回数据                       |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "message": "success",
    "data": null
}
```

#### 邮箱更改密码验证：

1.基本信息

>请求路径：/findCode/changepwdEmail
>
>请求方式：POST
>
>接口描述：该接口用于验证邮箱密码更改

2.请求参数

- 参数格式：application/x-www-form-urlencoded

- 参数说明：

  | 参数名     | 类型   | 是否必须 | 备注     |
  | ---------- | ------ | -------- | -------- |
  | email      | String | 是       | 用户名   |
  | password   | String | 是       | 密码     |
  | repassword | String | 是       | 确认密码 |
  | code       | String | 是       | 验证码   |

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名  | 类型   | 是否必须 | 备注                           |
  | ------- | ------ | -------- | ------------------------------ |
  | code    | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message | string | 非必须   | 提示信息                       |
  | data    | object | 非必须   | 返回数据                       |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "message": "success",
    "data": null
}
```



# 手机号找回密码

### 手机号验证：

1.基本信息

>请求路径：/findCode/retrieveMobile
>
>请求方式：POST
>
>接口描述：该接口用于验证手机号、发送手机验证码

2.请求参数

- 参数格式：application/x-www-form-urlencoded

- 参数说明：

  | 参数名 | 类型   | 是否必须 | 备注   |
  | ------ | ------ | -------- | ------ |
  | phone  | String | 是       | 用户号 |

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名  | 类型   | 是否必须 | 备注                           |
  | ------- | ------ | -------- | ------------------------------ |
  | code    | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message | string | 非必须   | 提示信息                       |
  | data    | object | 非必须   | 返回数据                       |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "message": "success",
    "data": null
}
```

####  手机号更改密码验证：

1.基本信息

>请求路径：/findCode/changepwdMobile
>
>请求方式：POST
>
>接口描述：该接口用于验证手机号密码更改

2.请求参数

- 参数格式：application/x-www-form-urlencoded

- 参数说明：

  | 参数名     | 类型   | 是否必须 | 备注     |
  | ---------- | ------ | -------- | -------- |
  | phone      | String | 是       | 手机号   |
  | password   | String | 是       | 密码     |
  | repassword | String | 是       | 确认密码 |
  | code       | String | 是       | 验证码   |

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名  | 类型   | 是否必须 | 备注                           |
  | ------- | ------ | -------- | ------------------------------ |
  | code    | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message | string | 非必须   | 提示信息                       |
  | data    | object | 非必须   | 返回数据                       |

- 响应数据类型样例：

```javascript
{
    "code": 0,
    "message": "两次密码不匹配",
    "data": null
}
```



# 注销账户

1.基本信息

>请求路径：/user/delete
>
>请求方式：DELETE
>
>接口描述：该接口用于注销当前账户

2.请求参数

无

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名  | 类型   | 是否必须 | 备注                           |
  | ------- | ------ | -------- | ------------------------------ |
  | code    | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message | string | 非必须   | 提示信息                       |
  | data    | object | 非必须   | 返回数据                       |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "message": "success",
    "data": null
}
```



# 查看个人基本信息

1.基本信息

>请求路径：/user/selectSelfInfo
>
>请求方式：GET
>
>接口描述：该接口用于查看当前用户的个人基本信息

2.请求参数

  无

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名        | 类型       | 是否必须 | 备注                           |
  | ------------- | ---------- | -------- | ------------------------------ |
  | code          | number     | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message       | string     | 非必须   | 提示信息                       |
  | data          | object     | 必须     | 返回数据                       |
  | \|-userId     | String     | 非必须   | 用户id                         |
  | \|-username   | String     | 非必须   | 用户名                         |
  | \|-password   | String     | 非必须   | 用户密码                       |
  | \|-email      | String     | 非必须   | 用户邮箱                       |
  | \|-phone      | String     | 非必须   | 手机号                         |
  | \|-speciality | String     | 非必须   | 特长                           |
  | \|-age        | Integer    | 非必须   | 用户年龄                       |
  | \|-gender     | String     | 非必须   | 性别                           |
  | \|-role       | String     | 非必须   | 用户的角色                     |
  | \|-salary     | BigDecimal | 非必须   | 薪资                           |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "message": "success",
    "data": {
        "userId": "55",
        "username": "ji",
        "password": "$2a$10$cP7MS.XHbgE37UwpZi4YHeFPBTsm8ryBQwyc95MBITOX3piSzax2i",
        "email": "2222222@qq.com",
        "phone": "18280012212",
        "speciality": "唱歌",
        "age": 44,
        "gender": "其他",
        "role": "服务员",
        "salary": 5555
    }
}
```



# 修改个人基本信息

1.基本信息

>请求路径：/user/updateSelfInfo
>
>请求方式：PUT
>
>接口描述：该接口用于修改当前用户的个人基本信息

2.请求参数

- 参数格式：application/json

- 参数说明：

  | 参数名     | 类型       | 是否必须 | 备注                             |
  | ---------- | ---------- | -------- | -------------------------------- |
  | userId     | String     | 否       | 用户id                           |
  | username   | String     | 否       | 用户名                           |
  | password   | String     | 否       | 密码                             |
  | email      | String     | 否       | 邮箱                             |
  | phone      | String     | 否       | 手机号                           |
  | speciality | String     | 否       | 特长                             |
  | age        | Integer    | 否       | 年龄                             |
  | gender     | String     | 否       | 性别(男\|女\|其他)               |
  | role       | String     | 否       | 角色(管理员\|店长\|服务员\|后勤) |
  | salary     | BigDecimal | 否       | 薪资                             |

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名  | 类型   | 是否必须 | 备注                           |
  | ------- | ------ | -------- | ------------------------------ |
  | code    | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message | string | 非必须   | 提示信息                       |
  | data    | object | 非必须   | 返回数据                       |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "message": "success",
    "data": null
}
```



# 修改密码

1.基本信息

>请求路径：/user/loginUpdatePassword
>
>请求方式：PUT
>
>接口描述：该接口用于修改当前用户登陆后修改密码

2.请求参数

- 参数格式：application/json

- 参数说明：

  | 参数名      | 类型   | 是否必须 | 备注       |
  | ----------- | ------ | -------- | ---------- |
  | oldPassword | String | 是       | 用户旧密码 |
  | newPassword | String | 是       | 用户新密码 |

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名  | 类型   | 是否必须 | 备注                           |
  | ------- | ------ | -------- | ------------------------------ |
  | code    | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message | string | 非必须   | 提示信息                       |
  | data    | object | 非必须   | 返回数据                       |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "message": "success",
    "data": null
}
```



# 可视化业务量

1.基本信息

>请求路径：/admins/getBusiness
>
>请求方式：GET
>
>接口描述：该接口用于查看所有店铺的每日业务量

2.请求参数

无

3.响应参数

- - 参数格式：application/json

  - 参数说明：

    | 参数名       | 类型     | 是否必须 | 备注                           |
    | ------------ | -------- | -------- | ------------------------------ |
    | code         | number   | 必须     | 响应码，1 代表成功，0 代表失败 |
    | message      | string   | 非必须   | 提示信息                       |
    | data         | object[] | 必须     | 返回数据                       |
    | \|-storeName | String   | 非必须   | 店铺名                         |
    | \|-date      | date     | 非必须   | 日期                           |
    | \|-business  | Integer  | 非必须   | 当日客流量                     |

  - 响应数据类型样例：

  ```javascript
  {
      "code": 1,
      "message": "success",
      "data": [
          {
              "storeName": "b",
              "date": "2023-08-31",
              "business": 34
          },
          {
              "storeName": "a",
              "date": "2023-08-02",
              "business": 5
          },
          {
              "storeName": "a",
              "date": "2023-08-01",
              "business": 5
          }
      ]
  }
  ```



# 可视化员工工作量与薪资

1.基本信息

>请求路径：/admins/selectSalary
>
>请求方式：GET
>
>接口描述：该接口用于查看员工工作量与薪资

2.请求参数：

无

3.响应参数

- 参数格式：application/json

- 参数说明：

  | 参数名       | 类型       | 是否必须 | 备注                           |
  | ------------ | ---------- | -------- | ------------------------------ |
  | code         | number     | 必须     | 响应码，1 代表成功，0 代表失败 |
  | message      | string     | 非必须   | 提示信息                       |
  | data         | object[]   | 必须     | 返回数据                       |
  | \|-username  | string     | 非必须   | 用户名                         |
  | \|-role      | string     | 非必须   | 用户角色                       |
  | \|-totaltime | BigDecimal | 非必须   | 员工工作量(工作时长)           |
  | \|-salaty    | BigDecimal | 非必须   | 薪资                           |

- 响应数据类型样例：

```javascript
{
    "code": 1,
    "message": "success",
    "data": [
        {
            "username": "zhangsan",
            "role": "店长",
            "totalTime": 10,
            "salary": 200
        },
        {
            "username": "jiang",
            "role": "服务员",
            "totalTime": 4,
            "salary": 60
        },
        {
            "username": "ji",
            "role": "服务员",
            "totalTime": 8,
            "salary": 120
        },
        {
            "username": "jw",
            "role": "店长",
            "totalTime": 17,
            "salary": 340
        }
    ]
}
```



# 员工查看自己工作时长

1.基本信息

>请求路径：/employees/workTime
>
>请求方式：GET
>
>接口描述：该接口用于查看当前用户的工作时长

2.请求参数

无

- 3.响应参数

  - 参数格式：application/json

  - 参数说明：

    | 参数名         | 类型       | 是否必须 | 备注                           |
    | -------------- | ---------- | -------- | ------------------------------ |
    | code           | number     | 必须     | 响应码，1 代表成功，0 代表失败 |
    | message        | string     | 非必须   | 提示信息                       |
    | data           | object     | 必须     | 返回数据                       |
    | \|-workHoursId | String     | 非必须   | 店铺id                         |
    | \|-userId      | string     | 非必须   | 用户id                         |
    | \|-date        | date       | 非必须   | 日期                           |
    | \|-hoursWorked | BigDecimal | 非必须   | 每日工作时长                   |

  - 响应数据类型样例：

  ```javascript
  {
      "code": 1,
      "message": "success",
      "data": [
          {
              "workHoursId": "1",
              "userId": "1",
              "date": "2023-08-02",
              "hoursWorked": 6
          },
          {
              "workHoursId": "5",
              "userId": "1",
              "date": "2023-07-31",
              "hoursWorked": 4
          }
      ]
  }
  ```



# 员工查看排班

1.基本信息

>请求路径：/employees/selfSchedule
>
>请求方式：GET
>
>接口描述：该接口用于查看当前用户的排班

2.请求参数

- 参数格式：无

- 参数说明：

- 3.响应参数

  - 参数格式：application/json

  - 参数说明：

    | 参数名        | 类型     | 是否必须 | 备注                           |
    | ------------- | -------- | -------- | ------------------------------ |
    | code          | number   | 必须     | 响应码，1 代表成功，0 代表失败 |
    | message       | string   | 非必须   | 提示信息                       |
    | data          | object[] | 非必须   | 返回数据                       |
    | \|-scheduleId | string   | 非必须   | 排班id                         |
    | \|-userId     | string   | 非必须   | 用户id                         |
    | \|-storeId    | string   | 非必须   | 店铺id                         |
    | \|-date       | date     | 非必须   | 日期                           |
    | \|-startTime  | datetime | 非必须   | 排班开始时间                   |
    | \|-endTime    | datetime | 非必须   | 排班结束时间                   |

  - 响应数据类型样例：

  ```javascript
  {
      "code": 1,
      "message": "success",
      "data": [
          {
              "scheduleId": "3",
              "userId": "1",
              "storeId": "1",
              "date": "2023-08-10",
              "startTime": "2023-08-22 09:47:49",
              "endTime": "2023-08-22 19:47:52"
          },
          {
              "scheduleId": "2",
              "userId": "1",
              "storeId": "1",
              "date": "2023-08-15",
              "startTime": "2023-08-09 09:46:35",
              "endTime": "2023-08-24 20:46:39"
          }
      ]
  }
  ```