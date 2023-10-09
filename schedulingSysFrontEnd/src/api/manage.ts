import { request } from "../utils/request.ts";
//员工信息
export function getStaffInfoByID(params: object) {
  return request({
    method: "post",
    url: "/userInfo",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}
