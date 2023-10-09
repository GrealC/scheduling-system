<script lang="ts" setup>
import { Calendar, Avatar, Setting } from "@element-plus/icons-vue";
import { useRoute } from "vue-router";
import { useUserStore } from "../store/user.ts";
import { userDelete } from "../api/user.ts";
import router from "../router";

const route = useRoute();
const userStore = useUserStore();

//退出登录
const loginOut: Function = () => {
  window.localStorage.removeItem("token");
  router.push("/home");
};
//注销账户
const deleteUser: Function = () => {
  userDelete()
    .then((res) => {
      if (res.code === 1) {
        window.localStorage.removeItem("token");
        alert("注销成功！");
        router.push("/home");
      } else {
        alert(res.data);
      }
    })
    .then((err) => {
      console.log(err);
    });
};
</script>
<template>
  <el-container class="layout-container-demo">
    <el-aside width="180px">
      <el-scrollbar>
        <div class="title">智能餐饮排班</div>
        <el-menu :default-active="route.path" :router="true">
          <el-sub-menu index="1">
            <template #title>
              <el-icon><Calendar /></el-icon>日历管理
            </template>
            <el-menu-item index="/staff/schedule">排班日历</el-menu-item>
            <el-menu-item index="/staff/holiday">假期日历</el-menu-item>
          </el-sub-menu>
          <el-sub-menu index="2">
            <template #title>
              <el-icon><Avatar /></el-icon>个人中心
            </template>
            <el-menu-item index="/staff/myInfo">个人信息</el-menu-item>
          </el-sub-menu>
        </el-menu>
      </el-scrollbar>
    </el-aside>

    <el-container>
      <el-header style="text-align: center; font-size: 16px">
        <div class="toolbar">
          <span>你好！{{ userStore.username }}</span>
          <el-dropdown>
            <el-icon size="16" style="margin-left: 8px; margin-top: 1px"
              ><Setting
            /></el-icon>
            <template #dropdown>
              <el-dropdown-menu>
                <el-dropdown-item @click="loginOut">退出登录</el-dropdown-item>
                <el-dropdown-item @click="deleteUser"
                  >注销账号</el-dropdown-item
                >
              </el-dropdown-menu>
            </template>
          </el-dropdown>
        </div>
      </el-header>

      <el-main :default-active="route">
        <RouterView></RouterView>
      </el-main>
    </el-container>
  </el-container>
</template>

<style scoped>
.layout-container-demo {
  width: 100vw;
  height: 100vh;
}
.layout-container-demo .el-header {
  position: relative;
  border-bottom: 1px solid #eee;
  color: var(--el-text-color-primary);
}
.layout-container-demo .el-aside {
  color: var(--el-text-color-primary);
  background-color: rgb(163, 187, 239);
}
.layout-container-demo .el-menu {
  border-right: none;
  background-color: rgb(168, 196, 252);
}
.layout-container-demo .el-main {
  padding: 0;
}
.layout-container-demo .toolbar {
  display: inline-flex;
  align-items: center;
  justify-content: center;
  height: 100%;
}

.el-menu-item {
  background-color: rgb(163, 187, 239);
}
.el-menu-item:hover {
  background-color: rgb(216, 227, 250);
}
.router-link {
  text-decoration: none;
}
.title {
  height: 40px;
  background-color: rgb(112, 136, 191);
  color: #fff;
  font-size: 20px;
  padding: 10px 20px 10px;
  font-weight: bold;
  text-align: center;
}
.el-main {
  background-color: rgb(242, 243, 245);
}
</style>
