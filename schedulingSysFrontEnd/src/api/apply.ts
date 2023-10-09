import { request } from "../utils/request.ts";
//员工请假
export function addLeave(params: object) {
  return request({
    method: "post",
    url: "/leave/add",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

//请假查询
export function selectLeave(params: object) {
  return request({
    method: "get",
    url: "/leave",
    data: params,
    headers: {
      token: window.localStorage.token,
      "Content-Type": "application/x-www-form-urlencoded",
    },
  });
}

//添加加班
export function addOvertime(params: object) {
  return request({
    method: "post",
    url: "/overtime/add",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

//加班查询
export function selectOvertime(params: object) {
  return request({
    method: "get",
    url: "/overtime",
    data: params,
    headers: {
      token: window.localStorage.token,
      "Content-Type": "application/x-www-form-urlencoded",
    },
  });
}

//添加排班
export function addSchedule(params: object) {
  return request({
    method: "post",
    url: "/schedule/add",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

//排班查询
export function selectSchedule(params: object) {
  return request({
    method: "get",
    url: "/overtime",
    data: params,
    headers: {
      token: window.localStorage.token,
      "Content-Type": "application/x-www-form-urlencoded",
    },
  });
}

//添加假期
export function addVacation(params: object) {
  return request({
    method: "post",
    url: "/vacation/add",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

//假期查询
export function selectVacation(params: object) {
  return request({
    method: "get",
    url: "/vacation",
    data: params,
    headers: {
      token: window.localStorage.token,
      "Content-Type": "application/x-www-form-urlencoded",
    },
  });
}
