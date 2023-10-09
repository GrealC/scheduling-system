import { request } from "../utils/request.ts";
//员工薪水
export function selectSalary() {
  return request({
    method: "get",
    url: "/admins/selectSalary",
    headers: {
      token: window.localStorage.token,
    },
  });
}

//员工工作时长
export function getWorkTime() {
  return request({
    method: "get",
    url: "/employees/workTime",
    headers: {
      token: window.localStorage.token,
    },
  });
}

//员工查看排班
export function getSelfSchedule() {
  return request({
    method: "get",
    url: "/employees/selfSchedule",
    headers: {
      token: window.localStorage.token,
    },
  });
}
