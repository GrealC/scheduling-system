<script setup lang="ts">
import { ref } from "vue";
import { Avatar, User, Lock } from "@element-plus/icons-vue";
import { userLogin, selectSelfInfo } from "../api/user";
import { useUserStore } from "../store/user.ts";
import router from "../router";

const userStore = useUserStore();
const account = ref("");
const password = ref("");
const alertTitle = ref("");
const alertType = ref("");
const alertIsShow = ref(false);
const isLogin = ref(false);

if(window.localStorage.token){
  if(window.localStorage.role === '管理员'){
    router.push('/manage')
  } else {
    router.push('/staff')
  }
}

const loginBtn: Function = () => {
  alertIsShow.value = true;
  if (account.value.trim().length === 0 || password.value.trim().length === 0) {
    alertType.value = "error";
    alertTitle.value = "账号或密码为空！";
    return;
  }
  userLogin({
    username: account.value,
    password: password.value,
  })
    .then((res) => {
      if (res.code === 1) {
        userStore.setUsername(account.value);
        alertType.value = "success";
        alertTitle.value = "登录成功!";
        isLogin.value = true;
        window.localStorage.setItem("token", res.data);
        window.localStorage.setItem("uname", account.value);
        selectSelfInfo().then((res) => {
          userStore.setRole(res.data.role);
          window.localStorage.setItem("role", res.data.role);
          window.localStorage.setItem("uid", res.data.user_id);
          if (res.code === 1) {
            if (res.data.role === "管理员") {
              router.push("/manage");
            } else {
              router.push("/staff");
            }
          }
        });
      } else {
        alertType.value = "error";
        alertTitle.value = "登录失败!" + res.msg + "!";
      }
    })
    .catch((err) => {
      console.log(err);
    });
  setTimeout(() => {
    alertIsShow.value = false;
  }, 1000);
};
</script>

<template>
  <div class="login-view">
    <el-alert
      v-show="alertIsShow"
      :title="alertTitle"
      :type="alertType"
      :closable="false"
      center
      show-icon
    />
    <div class="login-box">
      <div class="left-box">
        <h1>欢迎回来，立即登录</h1>
        <h3>智能餐饮排班系统</h3>
      </div>
      <div class="right-box">
        <div class="login">
          <div class="profile-photo">
            <el-icon size="80px"><Avatar /></el-icon>
          </div>
          <ul>
            <li>
              <el-icon size="18px"><User /></el-icon>
              <input
                type="text"
                class="form-control"
                id="username"
                name="username"
                placeholder="请输入账号"
                v-model="account"
              />
            </li>
            <li>
              <el-icon size="18px"><Lock /></el-icon>
              <input
                type="password"
                class="form-control"
                id="password"
                name="password"
                placeholder="请输入密码"
                v-model="password"
              />
            </li>
          </ul>
          <div class="message">
            <p>没有账号? <router-link to="/register">立即注册</router-link></p>
          </div>
          <div class="login-btn-box">
            <el-button round class="login-btn" @click="loginBtn">登录</el-button
            ><br />
          </div>
          <div class="forget-pwd">
            <router-link to="/forgetPwd"><span>忘记密码?</span></router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.login-view {
  width: 100vw;
  height: 100vh;
  margin-top: 0;
  background-color: rgb(236, 240, 243);
  background-size: 100% 100%;
  overflow: hidden;
  .el-alert {
    position: fixed;
    width: 20%;
    top: 4%;
    left: 50%;
    transform: translate(-50%);
  }
  .login-box {
    width: 50%;
    height: 60%;
    margin: 10% auto 0;
    .left-box {
      float: left;
      width: 64%;
      height: 100%;
      background-color: rgb(218, 224, 234);
      border-top-left-radius: 25px;
      border-bottom-left-radius: 25px;
      h1 {
        margin-top: 35%;
        text-align: center;
        color: #181818;
      }
      h3 {
        margin-top: 10%;
        text-align: center;
        color: #a0a5a8;
      }
    }
    .right-box {
      float: right;
      width: 36%;
      height: 100%;
      background-color: #fff;
      border-top-right-radius: 25px;
      border-bottom-right-radius: 25px;
      .login {
        width: 80%;
        height: 90%;
        margin: 0 auto;
        padding: 20% 0 0 0;
        overflow: hidden;
        .profile-photo {
          width: 70px;
          height: 70px;
          margin: 0 auto;
        }
        ul {
          width: 100%;
          height: 25%;
          margin: 15% 0 0 2%;
        }
        ul > li {
          width: 94%;
          height: 30%;
          border: 1px solid rgb(193, 193, 193);
          display: flex;
          align-items: center;
          padding-left: 2%;
          input {
            width: 80%;
            height: 80%;
            font-size: 14px;
            -webkit-text-fill-color: rgb(144, 144, 144);
            padding: 0;
            margin-left: 2%;
          }
        }
        ul > li:nth-child(1) {
          margin: 0 0 10% 0;
        }
        .message {
          p {
            width: 50%;
            font-size: 13px;
            margin: 0 auto;
          }
        }
        .login-btn-box {
          width: 100%;
          height: 8%;
          margin-top: 5%;
          display: flex;
          justify-content: center;
          .login-btn {
            width: 90%;
            height: 100%;
            color: #fefefe;
            background: linear-gradient(to right, #88fae9, #8b8df5);
          }
        }
        .forget-pwd {
          width: 5em;
          margin: 10% auto;
          font-size: 13px;
          span:hover {
            text-decoration: underline;
            color: #b1b1b1;
            cursor: pointer;
          }
        }
      }
    }
  }
}
</style>
