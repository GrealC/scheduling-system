<script setup lang="ts">
import * as echarts from "echarts";
import { ref, onMounted } from "vue";
import { predict } from "../api/predict";

const options = ref([]);
const chartX = ref([]);
const chartData = ref([]);
const selectValue = ref("");

const changeChart: Function = () => {
  const params = {
    storeId: selectValue.value,
    time: new Date(),
  };
  predict(params).then((res) => {
    if (res.code === 1) {
      chartX.value = res.data[0];
      chartData.value = res.data[1];
    }
  });
  const predictChart = echarts.init(document.getElementById("predict-chart"));
  const predictOption = {
    title: {
      text: "店铺未来一周客流量预测",
    },
    xAxis: {
      data: chartX.value,
    },
    yAxis: {},
    series: [
      {
        type: "line",
        data: chartData.value,
      },
    ],
  };
  // 绘制图表
  predictChart.setOption(predictOption);
};
//初始图表
onMounted(() => {
  const params = {
    storeId: options.value[0].sId,
    time: new Date(),
  };
  predict(params).then((res) => {
    if (res.code === 1) {
      chartX.value = res.data[0];
      chartData.value = res.data[1];
    }
  });
  const predictChart = echarts.init(document.getElementById("predict-chart"));
  const predictOption = {
    title: {
      text: "店铺未来一周客流量预测",
    },
    xAxis: {
      data: chartX.value,
    },
    yAxis: {},
    series: [
      {
        type: "line",
        data: chartData.value,
      },
    ],
  };
  // 绘制图表
  predictChart.setOption(predictOption);
});
</script>

<template>
  <div class="main">
    <div class="select-bg">
      <div class="select-store">
        <h3>请选择店铺</h3>
        <el-select
          v-model="selectValue"
          @change="changeChart()"
          class="m-2"
          placeholder="老麻抄手"
        >
          <el-option
            v-for="item in options"
            :key="item.sId"
            :value="item.value"
          />
        </el-select>
      </div>
    </div>
    <div id="predict-chart"></div>
  </div>
</template>

<style lang="less" scoped>
.main {
  width: 100%;
  height: 100%;
  background-color: #e1e1e1;
  overflow: hidden;
  .select-bg {
    width: 90%;
    height: 7%;
    margin: 10% auto 1%;
    background-color: #fff;
    box-shadow: 1px 1px 1px 1px rgba(197, 197, 197, 0.5);
    .select-store {
      width: 100px;
      margin: 0 auto;
      .el-select {
        font-size: 16px;
      }
    }
  }
  #predict-chart {
    width: 90%;
    height: 40%;
    margin: 5% auto;
    background-color: #fff;
  }
}
</style>
