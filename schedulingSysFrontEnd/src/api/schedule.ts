import { request } from "../utils/request.ts";

//智能排班
export function getSmartSchedule(params: object) {
  return request({
    method: "post",
    url: "/scheduling",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

//创建排班
export function createSchedule(params: object) {
  return request({
    method: "post",
    url: "/schedule/create",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

//修改排班
export function updateSchedule(params: object) {
  return request({
    method: "post",
    url: "/schedule/update",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}
