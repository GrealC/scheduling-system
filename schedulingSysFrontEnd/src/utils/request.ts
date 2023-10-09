import axios from "axios";

export function request(config) {
  // 创建axios的实例
  const instance = axios.create({
    baseURL: "http://localhost:9090",
    timeout: 10000,
  });
  // axios.interceptors  全局拦截
  //请求拦截
  instance.interceptors.request.use(
    (config) => {
      //拦截请求
      return config; //若拦截到需要原封不动的返回
    },
    (err) => {
      console.log(err);
    }
  );
  //响应拦截
  instance.interceptors.response.use(
    (res) => {
      return res.data;
    },
    (err) => {
      console.log(err);
    }
  );
  // 3.发送真正的网络请求
  return instance(config);
}
