<script setup lang="ts"></script>

<template>
  <div class="forget-pwd-view">
    <div class="forget-pwd-box">
      <div class="left-box">
        <h1>忘记密码？立即找回</h1>
        <h3>智能餐饮排班系统</h3>
      </div>
      <RouterView></RouterView>
    </div>
  </div>
</template>

<style scoped lang="less">
.forget-pwd-view {
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
  .forget-pwd-box {
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
  }
}
</style>
