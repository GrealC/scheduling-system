<script setup lang="ts">
import * as echarts from "echarts";
import { ref, onMounted } from "vue";
import { selectSalary } from "../api/staff.ts";

const staffArr = ref([
  {
    name: "",
    id: "",
    job: "",
    workTime: "",
    salary: 0,
  },
]);

onMounted(() => {
  selectSalary()
    .then((res) => {
      staffArr.value = res.data;
    })
    .catch((err) => {
      console.log(err);
    });
  const timeChart = echarts.init(document.getElementById("time-chart"));
  const timeOption = {
    title: {
      text: "工作时长视图",
    },
    xAxis: {
      data: staffArr.map((it) => {
        return it.name;
      }),
    },
    yAxis: {},
    series: [
      {
        type: "bar",
        data: staffArr.map((it) => {
          return it.workTime;
        }),
      },
    ],
  };
  // 绘制图表
  timeChart.setOption(timeOption);

  const incomeChart = echarts.init(document.getElementById("income-chart"));
  const incomeOption = {
    title: {
      text: "员工薪资视图",
    },
    xAxis: {
      data: staffArr.map((it) => {
        return it.name;
      }),
    },
    yAxis: {},
    series: [
      {
        type: "bar",
        data: staffArr.map((it) => {
          return it.salary;
        }),
      },
    ],
  };
  // 绘制图表
  incomeChart.setOption(incomeOption);
});
</script>

<template>
  <div class="main">
    <div id="time-chart"></div>
    <div id="income-chart"></div>
  </div>
</template>

<style lang="less" scoped>
.main {
  width: 100%;
  height: 100%;
  background-color: #fff;
  #time-chart {
    width: 100%;
    height: 45%;
    margin-bottom: 5%;
  }
  #income-chart {
    width: 100%;
    height: 45%;
  }
}
</style>
