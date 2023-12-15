import { request } from "../utils/request.ts";

//排班规则
export function getRule(params: object) {
  return request({
    method: "post",
    url: "/getRule",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}
//保存排班规则设置
export function saveRule(params: object) {
  return request({
    method: "post",
    url: "/saveRule",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

