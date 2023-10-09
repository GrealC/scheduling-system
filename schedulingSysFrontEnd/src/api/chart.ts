import { request } from "../utils/request.ts";

//店铺业务量
export function getBusiness() {
  return request({
    method: "get",
    url: "/admins/getBusiness",
    headers: {
      token: window.localStorage.token,
    },
  });
}

//员工工作量和薪水
export function selectSalary() {
  return request({
    method: "get",
    url: "/admins/selectSalary",
    headers: {
      token: window.localStorage.token,
    },
  });
}
