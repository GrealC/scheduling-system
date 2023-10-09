import { request } from "../utils/request.ts";

//客流量预测
export function predict(params: object) {
  return request({
    method: "get",
    url: "/predict",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

//客流量记录
export function storageUsers(params: object) {
  return request({
    method: "post",
    url: "/storage",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}
