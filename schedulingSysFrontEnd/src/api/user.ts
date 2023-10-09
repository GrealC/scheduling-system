import { request } from "../utils/request.ts";

//用户登录
export function userLogin(params: object) {
  return request({
    method: "post",
    url: "/user/login",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

// 用户注册
export function userRegister(params: object) {
  return request({
    method: "post",
    url: "/user/register",
    data: params,
    headers: {},
  });
}

//找回密码
export function findPassword(params: object) {
  return request({
    method: "post",
    url: "/findCode/retrieveMobile",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

//注销账户
export function userDelete() {
  return request({
    method: "delete",
    url: "/user/delete",
    headers: {
      token: window.localStorage.token,
    },
  });
}

//查看个人信息
export function selectSelfInfo() {
  return request({
    method: "get",
    url: "/user/selectSelfInfo",
    headers: {
      token: window.localStorage.token,
    },
  });
}

//修改个人信息
export function updateSelfInfo(params: object) {
  return request({
    method: "put",
    url: "/user/updateSelfInfo",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}

//用户修改密码
export function updateUserPwd(params: object) {
  return request({
    method: "put",
    url: "/user/loginUpdatePassword",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}
