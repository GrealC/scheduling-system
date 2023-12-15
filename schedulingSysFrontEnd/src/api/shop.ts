import { request } from "../utils/request.ts";
//添加店铺
export function addStore(params: object) {
  return request({
    method: "post",
    url: "/store/addStore",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}
//删除店铺
export function deleteStore(params: object) {
  return request({
    method: "delete",
    url: "/store/storeById",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}
//查询所有店铺
export function getAllStores() {
    return request({
      method: "get",
      url: "/store/selectAll",
      headers: {
        token: window.localStorage.token,
      },
    });
  }