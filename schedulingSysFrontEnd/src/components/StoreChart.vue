<script setup lang="ts">
import * as echarts from "echarts";
import { onMounted, defineProps } from "vue";

const props = defineProps(["shopArr"]);

onMounted(() => {
  const myChart = echarts.init(document.getElementById("chart"));
  const option = {
    title: {
      text: "各店铺业务量情况",
    },
    xAxis: {
      data: props.shopArr.map((it) => {
        return it.name;
      }),
    },
    yAxis: {},
    series: [
      {
        data: props.shopArr.map((it) => {
          return it.num;
        }),
        type: "bar",
        stack: "x",
      },
    ],
  };
  // 绘制图表
  myChart.setOption(option);
});
</script>

<template>
  <div id="chart"></div>
</template>

<style lang="less" scoped>
#chart {
  width: 90%;
  height: 40%;
  margin: 0 auto;
  background-color: #fff;
  overflow: hidden;
}
</style>
