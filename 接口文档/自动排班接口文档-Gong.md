# 智能排班系统接口文档

## 排班模块

### 自动排班

1.基本信息

> 请求路径：/scheduling
>
> 请求方式：POST
>
> 接口描述：用于指定店铺与日期的排班

2.请求参数

- `application/json`

- 参数说明

  | 参数名    | 类型     | 是否必须 | 备注                                                         |
  | --------- | -------- | -------- | ------------------------------------------------------------ |
  | `storeId` | String   | 是       | 店铺id。格式应当如下：1                                      |
  | `date`    | String[] | 是       | 格式：`yyyy-MM-dd`(建议一次输入排班规则内的要求的一周所有的可排天数) |

3.响应参数

- 参数格式：`application/json`

- 参数说明：

  | 参数名 | 类型   | 是否必须 | 备注                           |
  | ------ | ------ | -------- | ------------------------------ |
  | `code` | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | `msg`  | string | 非必须   | 提示信息                       |
  | `data` | object | 非必须   | 返回的数据                     |

- 响应数据类型样例：

  ```javascript
  {
      "code": 1,
      "msg": "success",
      "data": [
          {
              "workPeriod_id": 0,
              "user_id": "1-1",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 1,
              "user_id": "2-1",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 2,
              "user_id": "3-1",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 3,
              "user_id": "4-1",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 4,
              "user_id": "5-1",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 0,
              "user_id": "1-2",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 1,
              "user_id": "2-2",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 2,
              "user_id": "3-2",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 3,
              "user_id": "4-2",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 4,
              "user_id": "5-2",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 5,
              "user_id": "11-2",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 6,
              "user_id": "22-2",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 7,
              "user_id": "12-2",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 0,
              "user_id": "1-3",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 1,
              "user_id": "2-3",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 2,
              "user_id": "3-3",
              "start_time": "2023-11-13T16:00:00.000+00:00",
              "end_time": "2023-11-13T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 0,
              "user_id": "4-1",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 1,
              "user_id": "5-1",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 2,
              "user_id": "11-1",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 0,
              "user_id": "4-2",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 1,
              "user_id": "5-2",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 2,
              "user_id": "11-2",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 3,
              "user_id": "22-2",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 4,
              "user_id": "12-2",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 0,
              "user_id": "4-3",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 1,
              "user_id": "5-3",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          },
          {
              "workPeriod_id": 2,
              "user_id": "11-3",
              "start_time": "2023-11-14T16:00:00.000+00:00",
              "end_time": "2023-11-14T16:00:00.000+00:00"
          }
      ]
  }
  ```

PS: user_id说明 --> 例如`11-3`，其中11代表员工id，3代表第3班

### 读取员工信息

1.基本信息

> 请求路径：`/userInfo`
>
> 请求方式：POST
>
> 接口描述：用于指定店铺与日期的排班

2.请求参数

- `application/json`

- 参数说明

  | 参数名 | 类型   | 是否必须 | 备注                    |
  | ------ | ------ | -------- | ----------------------- |
  | `uid`  | String | 是       | 员工id。格式应当如下：1 |

3.响应参数

- 参数格式：`application/json`

- 参数说明：

  | 参数名 | 类型   | 是否必须 | 备注                           |
  | ------ | ------ | -------- | ------------------------------ |
  | `code` | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | `msg`  | string | 非必须   | 提示信息                       |
  | `data` | object | 非必须   | 返回的数据                     |

- 响应数据类型样例：

  ```javascript
  {
      "code": 1,
      "msg": "success",
      "data": {
          "user_id": "1",
          "username": "user1",
          "password": "password1",
          "email": "user1@example.com",
          "phone": "1234567890",
          "speciality": "Programming",
          "age": 25,
          "gender": "男",
          "role": "店长",
          "salary": 0.00
      }
  }
  ```

  

### 读取排班规则

1.基本信息

> 请求路径：`/getRule`
>
> 请求方式：POST
>
> 接口描述：用于指定店铺与日期的排班

2.请求参数

- `application/json`

- 参数说明

  | 参数名    | 类型   | 是否必须 | 备注                    |
  | --------- | ------ | -------- | ----------------------- |
  | `storeId` | String | 是       | 店铺id。格式应当如下：1 |

3.响应参数

- 参数格式：`application/json`

- 参数说明：

  | 参数名 | 类型   | 是否必须 | 备注                           |
  | ------ | ------ | -------- | ------------------------------ |
  | `code` | number | 必须     | 响应码，1 代表成功，0 代表失败 |
  | `msg`  | string | 非必须   | 提示信息                       |
  | `data` | object | 非必须   | 返回的数据                     |

- 响应数据类型样例：

  ```javascript
  {
      "code": 1,
      "msg": "success",
      "data": [
          {
              "rule_id": "1",
              "store_id": "1",
              "work_days_per_week": 5,
              "work_hours_per_day": 3,
              "days_work_period": "11-14",
              "max_work_hours_per_week": 40,
              "max_work_hours_per_month": 160
          },
          {
              "rule_id": "2",
              "store_id": "1",
              "work_days_per_week": 5,
              "work_hours_per_day": 2,
              "days_work_period": "15-19",
              "max_work_hours_per_week": 40,
              "max_work_hours_per_month": 160
          },
          {
              "rule_id": "3",
              "store_id": "1",
              "work_days_per_week": 5,
              "work_hours_per_day": 3,
              "days_work_period": "20-23",
              "max_work_hours_per_week": 40,
              "max_work_hours_per_month": 160
          }
      ]
  }
  ```

PS: 其中`days_work_period`表示的是每天对应时段的工作起止时间，如：

```javascript
{
            "rule_id": "3", //时间段为第三班
            "store_id": "1",
            "work_days_per_week": 5,
            "work_hours_per_day": 3,
            "days_work_period": "20-23",
           //工作时间为20：00-23：00
            "max_work_hours_per_week": 40,
            "max_work_hours_per_month": 160
        }
```

