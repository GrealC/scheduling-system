<script setup lang="ts">
import { ref, onMounted } from "vue";
import { House } from "@element-plus/icons-vue";
import StoreChart from "./StoreChart.vue";
import { getBusiness } from "../api/chart.ts";

const arr = ref([
  {
    name: "",
    id: "",
    num: "",
  },
]);

onMounted(() => {
  getBusiness()
    .then((res) => {
      if (res.code === 1) {
        arr.value = res.data;
      }
    })
    .catch((err) => {
      console.log(err);
    });
});
</script>

<template>
  <div class="shop-component">
    <ul>
      <li v-for="it in arr">
        <el-icon size="140px"><House /></el-icon>
        <h3>{{ it.name }}</h3>
        <h3>店铺ID：{{ it.id }}</h3>
        <h3>当日客流量：{{ it.num }}</h3>
      </li>
    </ul>
    <StoreChart :shop-arr="arr"></StoreChart>
  </div>
</template>

<style lang="less" scoped>
.shop-component {
  width: 100%;
  height: 100%;
  ul {
    width: 100%;
    height: 50%;
  }
  ul li {
    display: inline-block;
    width: 16%;
    height: 80%;
    background-color: #fff;
    margin-left: 3%;
    margin-top: 2%;
    border-radius: 25px;
    box-shadow: 1px 2px 3px 2px rgb(197, 197, 197);
    .el-icon {
      display: block;
      margin-top: 10%;
      margin: 0 auto;
    }
    h3 {
      margin-top: 10%;
      text-align: center;
    }
  }
}
</style>
