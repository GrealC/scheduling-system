import { createRouter, createWebHashHistory } from "vue-router";

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: "/",
      redirect: {
        path: "/login",
      },
    },
    {
      path: "/login",
      name: "login",
      component: () => import("../views/Login.vue"),
    },
    {
      path: "/register",
      name: "register",
      component: () => import("../views/Register.vue"),
    },
    {
      path: "/forgetPwd",
      name: "forgetPwd",
      redirect: "/forgetPwd/forgetView",
      component: () => import("../views/ForgetPwd.vue"),
      children: [
        {
          path: "forgetView",
          name: "forgetView",
          component: () => import("../components/ForgetPwd.vue"),
        },
      ],
    },
    {
      path: "/staff",
      name: "staff",
      redirect: "/staff/schedule",
      component: () => import("../views/Staff.vue"),
      children: [
        {
          path: "schedule",
          name: "schedule",
          component: () => import("../components/Scheduling.vue"),
        },
        {
          path: "myInfo",
          name: "myInfo",
          component: () => import("../components/StaffInfo.vue"),
        },
        {
          path: "holiday",
          name: "holiday",
          component: () => import("../components/Holiday.vue"),
        },
      ],
    },
    {
      path: "/manage",
      name: "manage",
      redirect: {
        path: "/manage/shop",
      },
      component: () => import("../views/Manage.vue"),
      children: [
        {
          path: "shop",
          name: "shop",
          component: () => import("../components/Shop.vue"),
        },
        {
          path: "predict",
          name: "predict",
          component: () => import("../components/Predict.vue"),
        },
        {
          path: "staffs",
          name: "staffs",
          component: () => import("../components/StaffManage.vue"),
        },
        {
          path: "manageStaffInfo",
          name: "manageStaffInfo",
          component: () => import("../components/ManageStaffInfo.vue"),
        },
        {
          path: "staffChart",
          name: "staffChart",
          component: () => import("../components/StaffChart.vue"),
        },
        {
          path: "manageInfo",
          name: "manageInfo",
          component: () => import("../components/StaffInfo.vue"),
        },
        {
          path: "rule",
          name: "rule",
          component: () => import("../components/SchedulingRule.vue"),
        },
        {
          path: "smart",
          name: "smart",
          component: () => import("../components/SmartScheduling.vue"),
        },
        {
          path: "manageSchedule",
          name: "manageSchedule",
          component: () => import("../components/ManageSchedule.vue"),
        },
        {
          path: "manageApply",
          name: "manageApply",
          component: () => import("../components/ManageApply.vue"),
        },
      ],
    },
  ],
});

router.beforeEach((to, from, next) => {
  if (
    to.name !== "login" &&
    to.name !== "register" &&
    to.name !== "forgetView" &&
    to.name !== "changePwd" &&
    to.name !== "staff" &&
    !window.localStorage.token
  )
    next({ name: "login" });
  else next();
});

router.beforeEach((to, from, next) => {
  if (
    (to.name === "shop" ||
      to.name === "staffs" ||
      to.name === "staffChart" ||
      to.name === "manageInfo" ||
      to.name === "manageStaffInfo" ||
      to.name === "predict" ||
      to.name === "rule" ||
      to.name === "smart" ||
      to.name === "manageSchedule" ||
      to.name === "manageApply") &&
    window.localStorage.role !== "管理员"
  )
    next({ name: "staff" });
  else next();
});
export default router;
