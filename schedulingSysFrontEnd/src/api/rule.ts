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
