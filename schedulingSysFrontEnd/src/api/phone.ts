import { request } from "../utils/request.ts";

//发送验证码
export function sendPhoneCode(params: object) {
  return request({
    method: "post",
    url: "/findCode/retrieveMobile",
    data: params,
    headers: {
      token: window.localStorage.token,
      ContentType: "application/x-www-form-urlencoded",
    },
  });
}

//手机验证码更改密码
export function changePwdByCode(params: object) {
  return request({
    method: "post",
    url: "/findCode/changepwdMobile",
    data: params,
    headers: {
      token: window.localStorage.token,
    },
  });
}
