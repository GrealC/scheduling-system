<script setup lang="ts">
import { ref, onMounted } from "vue";
import { Timer, User } from "@element-plus/icons-vue";
import { getSmartSchedule } from "../api/schedule.ts";

const date = ref("");
const sId = ref("");
const selectValue = ref('')
const monArr = ref([{ time: "", id: "", name: "" }]);
const tueArr = ref([{ time: "", id: "", name: "" }]);
const wedArr = ref([{ time: "", id: "", name: "" }]);
const thuArr = ref([{ time: "", id: "", name: "" }]);
const friArr = ref([{ time: "", id: "", name: "" }]);
const satArr = ref([{ time: "", id: "", name: "" }]);
const sunArr = ref([{ time: "", id: "", name: "" }]);
const options = ref([{storeName:'', id:''}])


onMounted(() => {
  const params = {
    storeId: sId.value,
    date: new Date(),
  };
  getSmartSchedule(params)
    .then((res) => {
      if (res.code === 1) {
        monArr.value = res.data[0];
        tueArr.value = res.data[1];
        wedArr.value = res.data[2];
        thuArr.value = res.data[3];
        friArr.value = res.data[4];
        satArr.value = res.data[5];
        sunArr.value = res.data[6];
      }
    })
    .catch((err) => {
      console.log(err);
    });
});

const disabledDate = (time: Date) => {
  return time.getDay() !== 1;
};
</script>

<template>
  <div class="smart-scheduling">
    <div class="header">
      <el-date-picker
        v-model="date"
        format="YYYY/MM/DD"
        value-format="YYYY-MM-DD"
        type="date"
        placeholder="选择周一查看该周智能排班"
        :disabled-date="disabledDate"
      />
      <div class="select-store">
          <el-select
            v-model="selectValue"
            class="m-2"
            placeholder="店铺名称"
          >
            <el-option
              v-for="item in options"
              :key="item.storeName"
              :value="item.storeName"
            />
          </el-select>
        </div>
    </div>
    <div class="main">
      <ul class="mon">
        <li>周一</li>
        <li v-for="it in monArr">
          <div>
            <el-icon :size="17" color="#75dbf8"><Timer /></el-icon>{{ it.time }}
          </div>
          <div>
            <el-icon :size="17" color="rgb(111, 236, 138)"><User /></el-icon
            >id:{{ it.id }} {{ it.name }}
          </div>
        </li>
      </ul>
      <ul class="tue">
        <li>周二</li>
        <li v-for="it in tueArr">
          <div>
            <el-icon :size="17" color="#75dbf8"><Timer /></el-icon>{{ it.time }}
          </div>
          <div>
            <el-icon :size="17" color="rgb(111, 236, 138)"><User /></el-icon
            >id:{{ it.id }} {{ it.name }}
          </div>
        </li>
      </ul>
      <ul class="wed">
        <li>周三</li>
        <li v-for="it in wedArr">
          <div>
            <el-icon :size="17" color="#75dbf8"><Timer /></el-icon>{{ it.time }}
          </div>
          <div>
            <el-icon :size="17" color="rgb(111, 236, 138)"><User /></el-icon
            >id:{{ it.id }} {{ it.name }}
          </div>
        </li>
      </ul>
      <ul class="thu">
        <li>周四</li>
        <li v-for="it in thuArr">
          <div>
            <el-icon :size="17" color="#75dbf8"><Timer /></el-icon>{{ it.time }}
          </div>
          <div>
            <el-icon :size="17" color="rgb(111, 236, 138)"><User /></el-icon
            >id:{{ it.id }} {{ it.name }}
          </div>
        </li>
      </ul>
      <ul class="fri">
        <li>周五</li>
        <li v-for="it in friArr">
          <div>
            <el-icon :size="17" color="#75dbf8"><Timer /></el-icon>{{ it.time }}
          </div>
          <div>
            <el-icon :size="17" color="rgb(111, 236, 138)"><User /></el-icon
            >id:{{ it.id }} {{ it.name }}
          </div>
        </li>
      </ul>
      <ul class="sat">
        <li>周六</li>
        <li v-for="it in satArr">
          <div>
            <el-icon :size="17" color="#75dbf8"><Timer /></el-icon>{{ it.time }}
          </div>
          <div>
            <el-icon :size="17" color="rgb(111, 236, 138)"><User /></el-icon
            >id:{{ it.id }} {{ it.name }}
          </div>
        </li>
      </ul>
      <ul class="sun">
        <li>周日</li>
        <li v-for="it in sunArr">
          <div>
            <el-icon :size="17" color="#75dbf8"><Timer /></el-icon>{{ it.time }}
          </div>
          <div>
            <el-icon :size="17" color="rgb(111, 236, 138)"><User /></el-icon
            >id:{{ it.id }} {{ it.name }}
          </div>
        </li>
      </ul>
    </div>
  </div>
</template>

<style lang="less" scoped>
.smart-scheduling {
  width: 100%;
  height: 100%;
  background-color: rgb(242, 242, 242);
  .header {
    width: 86%;
    height: 8%;
    margin: 0 auto;
    // background-color: rgb(236, 236, 236);
    border-radius: 10px;
    display: flex;
    justify-content: center;
    align-items: center;
    .select-store {
      margin-left: 30px;
    }
  }
  .main {
    width: 96%;
    height: 90%;
    margin: 0 auto;
    ul {
      float: left;
      width: 13%;
      height: 100%;
      margin-left: 1%;
      margin-top: 1%;

      li {
        width: 100%;
        height: 10%;
        margin-bottom: 10%;
        text-align: center;
        background-color: rgb(247, 250, 253);
        box-shadow: 1px 2px 3px 2px rgb(197, 197, 197);
        div {
          text-align: center;
          font-size: 15px;
          padding-top: 6%;

          .el-icon {
            position: relative;
            top: 2px;
          }
        }
      }

      li:nth-child(1) {
        height: 6%;
        padding-top: 3%;
        font-weight: 570;
      }
    }
  }
}
</style>
