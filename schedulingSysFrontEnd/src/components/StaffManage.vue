<script setup lang="ts">
import { ref, onMounted } from "vue";
import router from "../router";
import { selectSalary } from "../api/chart.ts";

onMounted(() => [
  selectSalary()
    .then((res) => {
      staffArr.value = res.data;
    })
    .catch((err) => {
      console.log(err);
    }),
]);

const manageStaffInfo = (uid: string) => {
  router.push({
    name: "manageStaffInfo",
    query: {
      uid: uid,
    },
  });
};

const staffArr = ref([
  {
    name: "",
    id: "",
    job: "",
    workTime: "",
    salary: 0,
  },
]);
</script>

<template>
  <div class="staff-manage">
    <ul>
      <li @click="manageStaffInfo(it.id)" v-for="it in staffArr">
        <div class="svg">
          <svg
            t="1695525153834"
            class="icon"
            viewBox="0 0 1024 1024"
            version="1.1"
            xmlns="http://www.w3.org/2000/svg"
            p-id="4081"
            width="130"
            height="130"
          >
            <path
              d="M512.3 106c-223.6 0-406.7 183-406.7 406.7s183 406.6 406.7 406.6 406.6-183 
                406.6-406.7C919 289 736 106 512.3 106z m10.2 122c155 0 155 116.9 155 183s-61 188.1-155 
                190.6c-91.5 0-155-122-155-190.6 0-66.1 0-183 155-183z m-10.2 
                668.4c-116.9 0-223.7-53.4-294.8-137.2 10.2-25.4 22.9-53.4 40.7-68.6 38.1-30.5 
                152.5-81.3 152.5-81.3l71.2 137.2 12.7-33-20.4-40.7 40.7-40.7 40.7 40.7-17.9 43.2 
                10.2 33.1 73.7-134.7s114.4 50.8 152.5 81.3c17.8 12.7 30.5 35.6 38.1 55.9-68.6 88.9-177.9 
                144.8-299.9 144.8z m0 0"
              p-id="4082"
              fill="#707070"
            ></path>
          </svg>
        </div>
        <h3>员工姓名：{{ it.name }}</h3>
        <h3>员工ID ：{{ it.id }}</h3>
        <h3>员工职务 ：{{ it.job }}</h3>
        <h3>工作时长：{{ it.workTime }}</h3>
        <h3>员工薪资：{{ it.salary }}</h3>
      </li>
    </ul>
  </div>
</template>

<style lang="less" scoped>
.staff-manage {
  width: 100%;
  height: 100%;
  background-color: rgb(242, 242, 242);
  ul {
    width: 100%;
    height: 100%;
    overflow-y: scroll;
  }
  ul li {
    display: inline-block;
    width: 15%;
    height: 41%;
    margin-top: 4%;
    margin-left: 4%;
    // margin-bottom: 3%;
    background-color: #fff;
    border-radius: 30px;
    box-shadow: 2px 2px 3px 2px rgb(197, 197, 197);
    .svg {
      width: 130px;
      margin: 0 auto;
    }
    h3 {
      margin-left: 40px;
      margin-top: 15px;
    }
  }
  ul li:hover {
    cursor: pointer;
  }
}
</style>
