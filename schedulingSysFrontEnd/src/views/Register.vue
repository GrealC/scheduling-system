<script setup lang="ts">
import { ref, watch } from "vue";
import { Avatar, User, Lock, Iphone } from "@element-plus/icons-vue";
import { userRegister } from "../api/user.js";
import router from "../router";
//用户名
const account = ref("");
//密码
const password = ref("");
//手机号
const phone = ref("");
//弹窗组件标题
const alertTitle = ref("");
//弹窗组件类型
const alertType = ref("success");
//控制是否显示弹窗
const alertIsShow = ref(false);

//用户名/密码输入值变化隐藏弹窗
watch(account, () => {
  alertIsShow.value = false;
});
watch(password, () => {
  alertIsShow.value = false;
});

const register: Function = () => {
  alertIsShow.value = true;
  if (
    account.value.trim().length === 0 ||
    password.value.trim().length === 0 ||
    phone.value.trim().length === 0
  ) {
    alertType.value = "error";
    alertTitle.value = "账号或密码或手机号为空！";
    return;
  }

  let obj = {
    username: account.value,
    password: password.value,
    phone: phone.value,
  };
  userRegister(obj)
    .then((res) => {
      if (res?.code === 1) {
        alertType.value = "success";
        alertTitle.value = "注册成功,正在为您跳转至登录界面...";
        setTimeout(() => {
          router.push("/login");
        }, 1000);
      } else {
        alertType.value = "error";
        alertTitle.value = res?.msg;
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
  <div class="register-view">
    <el-alert
      v-show="alertIsShow"
      :title="alertTitle"
      :type="alertType"
      :closable="false"
      center
      show-icon
    />
    <div class="register-box">
      <div class="left-box">
        <div class="register">
          <div class="profile-photo">
            <el-icon size="80px"><Avatar /></el-icon>
          </div>
          <ul>
            <li>
              <el-icon size="18px"><User /></el-icon>
              <input
                type="text"
                class="form-control"
                placeholder="请输入账号"
                v-model="account"
              />
            </li>
            <li>
              <el-icon size="18px"><Lock /></el-icon>
              <input
                type="password"
                class="form-control"
                placeholder="请输入密码"
                v-model="password"
              />
            </li>
            <li>
              <el-icon size="18px"><Iphone /></el-icon>
              <input
                type="text"
                class="form-control"
                placeholder="请输入11位手机号"
                v-model="phone"
              />
            </li>
          </ul>
          <div class="register-btn-box">
            <el-button round class="register-btn" @click="register"
              >注册</el-button
            ><br />
          </div>
        </div>
      </div>
      <div class="right-box">
        <h1>没有账号？立即注册</h1>
        <h3>智能餐饮排班系统</h3>
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.register-view {
  width: 100vw;
  height: 100vh;
  margin-top: 0;
  background-size: 100% 100%;
  background-color: rgb(236, 240, 243);
  overflow: hidden;
  .el-alert {
    position: fixed;
    width: 20%;
    top: 4%;
    left: 50%;
    transform: translate(-50%);
  }
  .register-box {
    width: 50%;
    height: 60%;
    margin: 10% auto 0;
    .right-box {
      float: right;
      width: 64%;
      height: 100%;
      background-color: rgb(218, 224, 234);
      border-top-right-radius: 25px;
      border-bottom-right-radius: 25px;
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
    .left-box {
      float: left;
      width: 36%;
      height: 100%;
      background-color: #fff;
      border-top-left-radius: 25px;
      border-bottom-left-radius: 25px;
      .register {
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
        ul > li:nth-child(-n + 2) {
          margin: 0 0 10% 0;
        }
        .register-btn-box {
          width: 100%;
          height: 8%;
          margin-top: 5%;
          display: flex;
          justify-content: center;
          .register-btn {
            margin-top: 20%;
            width: 90%;
            height: 100%;
            color: #fefefe;
            background: linear-gradient(to right, #88fae9, #8b8df5);
          }
        }
      }
    }
  }
}
</style>
