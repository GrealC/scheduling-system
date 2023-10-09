<script setup lang="ts">
import { ref } from "vue";
import { updateUserPwd, updateSelfInfo } from "../api/user.ts";
import { getStaffInfoByID } from "../api/manage.ts";
import { useRoute } from "vue-router";
const route = useRoute();

const user = ref("");
const oldPwd = ref("");
const newPwd = ref("");
const uid = ref(route.query.uid);
const gender = ref("");
const age = ref("");
const role = ref("");
const speciality = ref("");
const email = ref("");
const phone = ref("");
const salary = ref("");

//弹窗组件标题
const alertTitle = ref("");
//弹窗组件类型
const alertType = ref("success");
//控制是否显示弹窗
const alertIsShow = ref(false);

getStaffInfoByID({ uid: uid.value }).then((res) => {
  if (res?.code === 1) {
    user.value = res.data?.username;
    uid.value = res.data?.userId;
    gender.value = res.data?.gender;
    age.value = res.data?.age;
    role.value = res.data?.role;
    speciality.value = res.data?.speciality;
    email.value = res.data?.email;
    phone.value = res.data?.phone;
    salary.value = res.data?.salary + "元";
  }
});

const updateInfo: Function = () => {
  const params = {
    userId: uid.value,
    username: user.value,
    email: email.value,
    phone: phone.value,
    speciality: speciality.value,
    age: age.value,
    gender: gender.value,
    role: role.value,
    salary: salary.value,
  };
  updateSelfInfo(params).then((res) => {
    console.log(res);

    alertIsShow.value = true;
    if (res?.code === 1) {
      alertType.value = "success";
      alertTitle.value = "修改成功!";
    } else {
      alertType.value = "error";
      alertTitle.value = res?.msg;
    }
  });
  setTimeout(() => {
    alertIsShow.value = false;
  }, 1000);
};
const updatePwd: Function = () => {
  const params = {
    oldPassword: oldPwd.value,
    newPassword: newPwd.value,
  };
  updateUserPwd(params).then((res) => {
    console.log(res);

    alertIsShow.value = true;
    if (res?.code === 1) {
      alertType.value = "success";
      alertTitle.value = "修改成功!";
    } else {
      alertType.value = "error";
      alertTitle.value = res?.msg;
    }
  });
  setTimeout(() => {
    alertIsShow.value = false;
  }, 1000);
};
</script>

<template>
  <div class="staff-info">
    <el-alert
      v-show="alertIsShow"
      :title="alertTitle"
      :type="alertType"
      :closable="false"
      center
      show-icon
    />
    <h3>员工资料</h3>
    <ul>
      <li>
        用户名 <el-input v-model="user" placeholder="请填写员工的用户名" />
      </li>
      <li>UID <el-input v-model="uid" placeholder="请填写员工的UID" /></li>
      <li>性别 <el-input v-model="gender" placeholder="请填写员工的性别" /></li>
      <li>职位 <el-input v-model="role" placeholder="请填写员工的职位" /></li>
      <li>
        年龄
        <el-input v-model="age" maxlength="3" placeholder="请填写员工的年龄" />
      </li>
      <li>
        特长 <el-input v-model="speciality" placeholder="请填写员工的特长" />
      </li>
      <li>薪资 <el-input v-model="salary" placeholder="请填写员工的年龄" /></li>
      <li>邮箱 <el-input v-model="email" placeholder="请输入员工的邮箱" /></li>
      <li>
        手机号
        <el-input
          v-model="phone"
          maxlength="11"
          placeholder="请填写你的手机号"
        />
      </li>

      <el-button @click="updateInfo" type="primary" round plain
        >修改信息</el-button
      >
    </ul>
  </div>
  <div class="account-info">
    <h3>员工信息</h3>
    <ul>
      <li>
        旧的密码
        <el-input
          v-model="oldPwd"
          type="password"
          placeholder="请输入旧的密码"
        />
      </li>
      <li>
        新的密码
        <el-input
          v-model="newPwd"
          type="password"
          placeholder="请输入新的密码"
        />
      </li>
      <el-button @click="updatePwd" type="primary" round plain
        >修改密码</el-button
      >
    </ul>
  </div>
</template>

<style lang="less" scoped>
.el-alert {
  position: fixed;
  width: 20%;
  top: 6%;
  left: 50%;
  transform: translate(-50%);
}
.staff-info,
.account-info {
  width: 40rem;
  height: 37rem;
  background-color: #fff;
  margin: 1% auto 0;
  box-shadow: 2px 2px 2px 2px rgba(0, 0, 0, 0.05);
  h3 {
    padding: 1em 0 0 1em;
  }
  ul {
    width: 80%;
    height: 4rem;
    margin: 0 auto;
    padding-top: 1em;
  }
  ul > li {
    border-top: 1px solid rgb(228, 230, 235);
    padding: 1rem 0 1rem 1rem;
    font-size: 14px;
    text-indent: 1rem;
    .el-input {
      float: right;
      width: 70%;
      margin-right: 2em;
      margin-top: -0.3rem;
    }
  }
  ul > li:nth-child(9) {
    border-bottom: 1px solid rgb(228, 230, 235);
  }
}
.el-button {
  display: block;
  margin: 6px auto 0;
}
.account-info {
  height: 14rem;

  ul > li:nth-child(2) {
    border-bottom: 1px solid rgb(228, 230, 235);
  }
}
</style>
