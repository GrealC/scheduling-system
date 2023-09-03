# 智能排班系统接口文档


**简介**:智能排班系统接口文档

**HOST**:localhost:8080


[TOC]






# LeaveController


## addLeave


**接口地址**:`/leave/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "endTime": "",
  "leaveId": "",
  "reason": "",
  "startTime": "",
  "status": "",
  "type": "",
  "userId": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|leave|leave|body|true|请假实体|请假实体|
|&emsp;&emsp;endTime|endTime||false|string(date-time)||
|&emsp;&emsp;leaveId|leaveId||false|string||
|&emsp;&emsp;reason|reason||false|string||
|&emsp;&emsp;startTime|startTime||false|string(date-time)||
|&emsp;&emsp;status|status||false|string||
|&emsp;&emsp;type|type||false|string||
|&emsp;&emsp;userId|userId||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## queryLeaveByUserId


**接口地址**:`/leave/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|请假实体|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|endTime|endTime|string(date-time)|string(date-time)|
|leaveId|leaveId|string||
|reason|reason|string||
|startTime|startTime|string(date-time)|string(date-time)|
|status|status|string||
|type|type|string||
|userId|userId|string||


**响应示例**:
```javascript
[
	{
		"endTime": "",
		"leaveId": "",
		"reason": "",
		"startTime": "",
		"status": "",
		"type": "",
		"userId": ""
	}
]
```


# OvertimeController


## addOvertime


**接口地址**:`/overtime/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "endTime": "",
  "overtimeId": "",
  "reason": "",
  "startTime": "",
  "status": "",
  "type": "",
  "userId": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|overtime|overtime|body|true|加班实体|加班实体|
|&emsp;&emsp;endTime|endTime||false|string(date-time)||
|&emsp;&emsp;overtimeId|overtimeId||false|string||
|&emsp;&emsp;reason|reason||false|string||
|&emsp;&emsp;startTime|startTime||false|string(date-time)||
|&emsp;&emsp;status|status||false|string||
|&emsp;&emsp;type|type||false|string||
|&emsp;&emsp;userId|userId||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## queryOvertimeByUserId


**接口地址**:`/overtime/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|加班实体|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|endTime|endTime|string(date-time)|string(date-time)|
|overtimeId|overtimeId|string||
|reason|reason|string||
|startTime|startTime|string(date-time)|string(date-time)|
|status|status|string||
|type|type|string||
|userId|userId|string||


**响应示例**:
```javascript
[
	{
		"endTime": "",
		"overtimeId": "",
		"reason": "",
		"startTime": "",
		"status": "",
		"type": "",
		"userId": ""
	}
]
```


# ScheduleController


## addSchedule


**接口地址**:`/schedule/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "endTime": "",
  "reason": "",
  "scheduleId": "",
  "startTime": "",
  "status": "",
  "storeId": "",
  "type": "",
  "userId": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|schedule|schedule|body|true|排班实体|排班实体|
|&emsp;&emsp;endTime|endTime||false|string(date-time)||
|&emsp;&emsp;reason|reason||false|string||
|&emsp;&emsp;scheduleId|scheduleId||false|string||
|&emsp;&emsp;startTime|startTime||false|string(date-time)||
|&emsp;&emsp;status|status||false|string||
|&emsp;&emsp;storeId|storeId||false|string||
|&emsp;&emsp;type|type||false|string||
|&emsp;&emsp;userId|userId||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## queryScheduleByUserId


**接口地址**:`/schedule/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|排班实体|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|endTime|endTime|string(date-time)|string(date-time)|
|reason|reason|string||
|scheduleId|scheduleId|string||
|startTime|startTime|string(date-time)|string(date-time)|
|status|status|string||
|storeId|storeId|string||
|type|type|string||
|userId|userId|string||


**响应示例**:
```javascript
[
	{
		"endTime": "",
		"reason": "",
		"scheduleId": "",
		"startTime": "",
		"status": "",
		"storeId": "",
		"type": "",
		"userId": ""
	}
]
```


# VacationController


## addVacation


**接口地址**:`/vacation/add`


**请求方式**:`POST`


**请求数据类型**:`application/json`


**响应数据类型**:`*/*`


**接口描述**:


**请求示例**:


```javascript
{
  "calendarId": "",
  "date": "",
  "userId": ""
}
```


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|vacation|vacation|body|true|假期日历实体|假期日历实体|
|&emsp;&emsp;calendarId|calendarId||false|string||
|&emsp;&emsp;date|date||false|string(date-time)||
|&emsp;&emsp;userId|userId||false|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK||
|201|Created||
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


暂无


**响应示例**:
```javascript

```


## queryVacationByUserId


**接口地址**:`/vacation/{id}`


**请求方式**:`GET`


**请求数据类型**:`application/x-www-form-urlencoded`


**响应数据类型**:`*/*`


**接口描述**:


**请求参数**:


| 参数名称 | 参数说明 | 请求类型    | 是否必须 | 数据类型 | schema |
| -------- | -------- | ----- | -------- | -------- | ------ |
|id|id|path|true|string||


**响应状态**:


| 状态码 | 说明 | schema |
| -------- | -------- | ----- | 
|200|OK|假期日历实体|
|401|Unauthorized||
|403|Forbidden||
|404|Not Found||


**响应参数**:


| 参数名称 | 参数说明 | 类型 | schema |
| -------- | -------- | ----- |----- | 
|calendarId|calendarId|string||
|date|date|string(date-time)|string(date-time)|
|userId|userId|string||


**响应示例**:
```javascript
[
	{
		"calendarId": "",
		"date": "",
		"userId": ""
	}
]
```