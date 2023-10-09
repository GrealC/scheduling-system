<script setup lang="ts">
import { ref } from "vue";
import { Iphone, Message, Avatar, Lock } from "@element-plus/icons-vue";
import router from "../router";
import { sendPhoneCode, changePwdByCode } from "../api/phone.ts";
//手机号
const phone = ref("");
//验证码
const code = ref("");
//新密码
const newPwd = ref("");
//确认新密码
const rePwd = ref("");
//获取验证码提示信息
const codeInfo = ref("获取验证码");

//弹窗组件标题
const alertTitle = ref("");
//弹窗组件类型
const alertType = ref("success");
//是否显示弹窗
const alertIsShow = ref(false);
//按钮是否禁用
const isBtnDisable = ref(false);

const sendCode: Function = () => {
  isBtnDisable.value = true;
  let time = 0;
  let timer = setInterval(() => {
    time++;
    codeInfo.value = "再次发送:" + (60 - time) + "s";
    if (time === 60) {
      clearInterval(timer);
      isBtnDisable.value = false;
      codeInfo.value = "获取验证码";
    }
  }, 1000);
  sendPhoneCode({
    phone: phone.value,
  }).then((res) => {});
};

const sub = () => {
  const params = {
    phone: phone.value,
    password: newPwd.value,
    repassword: rePwd.value,
    code: code.value,
  };
  changePwdByCode(params).then((res) => {
    alertIsShow.value = true;
    if (res.code === 400) {
      alertType.value = "success";
      alertTitle.value = "登录成功!";
      setTimeout(() => {
        router.push("/login");
      }, 1000);
    } else {
      alertType.value = "error";
      alertTitle.value = res.msg;
    }
    setTimeout(() => {
      alertIsShow.value = false;
    }, 1000);
  });
};
</script>

<template>
  <el-alert
    v-show="alertIsShow"
    :title="alertTitle"
    :type="alertType"
    :closable="false"
    center
    show-icon
  />
  <div class="right-box">
    <div class="forget-pwd">
      <div class="profile-photo">
        <el-icon size="80px"><Avatar /></el-icon>
      </div>
      <ul>
        <li>
          <el-icon size="18px"><Iphone /></el-icon>
          <input
            type="text"
            class="form-control"
            id="phone"
            name="phone"
            placeholder="请输入手机号"
            v-model="phone"
          />
        </li>
        <li>
          <el-icon size="18px"><Message /></el-icon>
          <input
            type="text"
            class="form-control"
            id="code"
            name="code"
            placeholder="请输入验证码"
            v-model="code"
          />
          <el-button
            class="send-code"
            :disabled="isBtnDisable"
            @click="sendCode"
            type="info"
            plain
            >{{ codeInfo }}</el-button
          >
        </li>
        <li>
          <el-icon size="18px"><Lock /></el-icon>
          <input
            type="password"
            class="form-control"
            placeholder="请输入新密码"
            v-model="newPwd"
          />
        </li>
        <li>
          <el-icon size="18px"><Lock /></el-icon>
          <input
            type="password"
            class="form-control"
            placeholder="再次确认新密码"
            v-model="rePwd"
          />
        </li>
      </ul>
      <div class="sub-box">
        <el-button round class="sub-btn" @click="sub">提交</el-button><br />
      </div>
    </div>
  </div>
</template>

<style scoped lang="less">
.el-alert {
  position: fixed;
  width: 20%;
  top: 4%;
  left: 50%;
  transform: translate(-50%);
}
.right-box {
  float: right;
  width: 36%;
  height: 100%;
  background-color: #fff;
  border-top-right-radius: 25px;
  border-bottom-right-radius: 25px;
  .forget-pwd {
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
    ul > li:nth-child(-n + 3) {
      margin: 0 0 10% 0;
    }
    .send-code {
      width: 90%;
      height: 100%;
      border-radius: 0;
      overflow: hidden;
    }
    .sub-box {
      width: 100%;
      height: 8%;
      margin-top: 50%;
      display: flex;
      justify-content: center;
      .sub-btn {
        width: 90%;
        height: 100%;
        color: #fefefe;
        background: linear-gradient(to right, #88fae9, #8b8df5);
      }
    }
  }
}
</style>
