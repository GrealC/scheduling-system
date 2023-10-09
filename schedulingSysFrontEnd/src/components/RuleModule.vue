<script setup lang="ts">
import { ref, defineProps } from "vue";

const { rule, rank } = defineProps({
  rule: Object,
  rank: String,
});

const workDaysPerWeek = ref(rule?.work_days_per_week);
const workHoursPerWeek = ref(rule?.work_hours_per_day);
const startTime = ref(rule?.days_work_period?.substr(0, 2));
const endTime = ref(rule?.days_work_period?.substr(2, 2));
const maxHoursPerWeek = ref(rule?.max_work_hours_per_week);
const maxHoursPeerMonth = ref(rule?.max_work_hours_per_month);
</script>

<template>
  <div class="rule-module">
    <el-card class="box-card" shadow="always">
      <template #header>
        <div class="card-header">
          <h3>{{ rank }}</h3>
        </div>
      </template>
      <div class="card-container"></div>
      <ul>
        <li>
          员工每周工作天数
          <el-input
            type="text"
            v-model="workDaysPerWeek"
            placeholder="请输入员工每周工作天数"
          />
        </li>
        <li>
          员工每天工作时长
          <el-input
            type="text"
            v-model="workHoursPerWeek"
            placeholder="请输入员工每天工作时长"
          />
        </li>
        <li>
          员工每天工作时段
          <div class="demo-time-range">
            &nbsp;
            <el-time-select
              v-model="startTime"
              :max-time="endTime"
              class="mr-4"
              placeholder="Start time"
              start="08:00"
              step="00:30"
              end="23:00"
            />
            &nbsp;&nbsp;至&nbsp;&nbsp;
            <el-time-select
              v-model="endTime"
              :min-time="startTime"
              placeholder="End time"
              start="08:00"
              step="00:30"
              end="23:00"
            />
          </div>
        </li>
        <li>
          员工每周最大工作时长
          <el-input
            type="text"
            v-model="maxHoursPerWeek"
            placeholder="请输入员工每周最大工作时长"
          />
        </li>
        <li>
          员工每月最大工作时长
          <el-input
            type="text"
            v-model="maxHoursPeerMonth"
            placeholder="请输入员工每月最大工作时长"
          />
        </li>
        <li></li>
      </ul>
    </el-card>
  </div>
</template>

<style lang="less" scoped>
.rule-module {
  width: 50%;
  height: 42%;
  margin: 0 auto 3%;

  ul {
    width: 90%;
    height: 18rem;
    margin: 0 auto;
  }
  ul > li {
    border-bottom: 1px solid rgb(228, 230, 235);
    padding: 1rem 0 1rem 1rem;
    font-size: 14px;
    text-indent: 1rem;
    .el-input {
      float: right;
      width: 60%;
      margin-right: 5em;
      margin-top: -0.3rem;
    }
  }
}
</style>
