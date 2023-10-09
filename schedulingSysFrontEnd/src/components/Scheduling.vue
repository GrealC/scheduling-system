<template>
  <div class="scheduling">
    <div class="block" style="margin-top: 3.125rem">
      <el-date-picker
        v-model="value2"
        type="date"
        placeholder="选择日期"
        format="YYYY/MM/DD"
        value-format="YYYY-MM-DD"
        style="margin-left: 100px"
      />
      <el-button
        type="primary"
        @click="selectDate"
        style="width: 5.625rem; margin-left: 10px"
        >查询</el-button
      >
      <el-button
        type="primary"
        style="max-width: 8.125rem; margin-left: 3.125rem"
        @click="planDialogVisible = true"
        >申请排班</el-button
      >
      <el-button
        type="primary"
        style="max-width: 8.125rem; margin-left: 3.125rem"
        @click="openModal"
        >申请加班 | 申请请假</el-button
      >
    </div>
    <div class="schedule-container">
      <el-calendar>
        <template #date-cell="{ date, data }">
          <div
            :class="{
              'is-selected': date === selectedDate,
              'is-red': date === selectedDate && selectedDate != null,
            }"
            @click="calItem(data.day)"
            :style="{
              backgroundColor: date === selectedDate ? '#E6F7FF' : '',
            }"
          >
            <p>
              {{ data.day.split("-").slice(1).join("-") }}
              <br />
              <span :class="getGradeClass(data.day)">
                {{ getGradeContent(data.day) }}
              </span>
            </p>
          </div>
        </template>
      </el-calendar>

      <el-dialog
        :title="editForm.day"
        v-model="planDialogVisible"
        width="30%"
        :before-close="handleClose"
      >
        <el-form @submit.native.prevent :ref="editForm" :model="editForm">
          <el-form-item label="排班" prop="content">
            <el-input v-model="editForm.content"></el-input>
          </el-form-item>
          <el-form-item label="性质" prop="grade">
            <el-radio-group v-model="editForm.grade">
              <el-radio label="一般日程"></el-radio>
              <el-radio label="紧急日程"></el-radio>
              <el-radio label="重要日程"></el-radio>
            </el-radio-group>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
          <el-button @click="planDialogVisible = false">取 消</el-button>
          <el-button type="primary" @click="addAndCloseDialog">确 定</el-button>
        </span>
      </el-dialog>
    </div>
    <el-dialog
      title="提交加班申请|请假申请"
      v-model="applyDialogVisible"
      width="30%"
      :before-close="handleClose"
    >
      <Vacate />
      <!-- 在此处引入你的组件 -->
      <span slot="footer" class="dialog-footer">
        <el-button
          @click="applyDialogVisible = false"
          style="margin-top: 2.5rem"
          >取消</el-button
        >
        <el-button
          type="primary"
          style="margin-top: 2.5rem; margin-left: 2.375rem"
          @click="submitLeaveApplication"
          >确认</el-button
        >
      </span>
    </el-dialog>
  </div>
</template>

<script lang="ts">
import moment from "moment";
import Vacate from "./Vacate.vue"; // 引入你的组件

export default {
  components: {
    Vacate,
  },
  data() {
    return {
      resDate: [{ date: "", content: "", grade: "" }],
      planDialogVisible: false,
      applyDialogVisible: false,
      rcdata: {},
      editForm: {
        content: "",
        day: moment().format("YYYY-MM-DD"),
        grade: "一般日程",
      },
      value2: null,
      selectedDate: "",
    };
  },
  methods: {
    calItem(d) {
      this.editForm.day = d;
      this.rcdata = this.dealMyDate(d);
      this.editForm.content = this.rcdata.content;
      this.editForm.grade = this.rcdata.grade;
      this.applyDialogVisible = true;
    },
    dealMyDate(v) {
      let len = this.resDate.length;
      let res = {};
      for (let i = 0; i < len; i++) {
        if (this.resDate[i].date == v) {
          res.content = this.resDate[i].content;
          res.grade = this.resDate[i].grade;
          res.index = i;
          break;
        }
      }
      return res;
    },
    getGradeClass(day) {
      const grade = this.dealMyDate(day).grade;
      return {
        "is-success": grade === "紧急日程",
        "is-common": grade === "一般日程",
        "is-danger": grade === "重要日程",
      };
    },
    getGradeContent(day) {
      return this.dealMyDate(day).content;
    },
    handleClose(done) {
      done();
    },
    addAndCloseDialog() {
      this.add();
      this.planDialogVisible = false;
    },
    add() {
      const newEvent = {
        date: this.editForm.day,
        content: this.editForm.content,
        grade: this.editForm.grade,
      };

      if (this.rcdata.grade) {
        this.$set(this.resDate, this.rcdata.index, newEvent);
      } else {
        this.resDate.push(newEvent);
      }
      console.log(newEvent);
    },
    selectDate() {
      this.selectedDate = moment(this.value2).format("YYYY-MM-DD");
    },
    openModal() {
      this.applyDialogVisible = true;
    },
    submitLeaveApplication() {
      this.applyDialogVisible = false;
    },
  },
};
</script>

<style>
.scheduling {
  width: 100%;
  height: 100%;
}
.schedule-container {
  max-width: 300rem;
  margin-top: 1.25rem;
  margin-left: 6.25rem;
  padding: 10px 0 0 10px;
  margin-bottom: 10px;
  margin-right: 6.25rem;
  background-color: var(--el-bg-color-overlay);
  border: 1px solid var(--el-border-color-light);
  border-radius: 4px;
  box-shadow: var(--el-box-shadow-light);
  display: flex;
}
.calendar-day {
  text-align: center;
  color: #202535;
  font-size: 12px;
}
.is-selected {
  color: #f8a535;
  font-weight: bold;
  margin-top: 5px;
}
.is-success {
  color: #67c23a;
}
.is-danger {
  color: #f56c6c;
}
.is-common {
  background-color: rgb(242, 243, 245);
}
#calendar
  .el-button-group
  > .el-button:not(:first-child):not(:last-child):after {
  content: "当月";
}
.el-calendar__header {
  background-color: rgb(242, 243, 245);
  margin-right: 10px;
  border-radius: 25px;
}
.demo-datetime-picker {
  display: flex;
  width: 100%;
  padding: 0;
  flex-wrap: wrap;
}
.demo-datetime-picker .block {
  padding: 30px 0;
  text-align: center;
  border-right: solid 1px var(--el-border-color);
  flex: 1;
}
.demo-datetime-picker .block:last-child {
  border-right: none;
}
.demo-datetime-picker .demonstration {
  display: block;
  color: var(--el-text-color-secondary);
  font-size: 14px;
  margin-bottom: 20px;
}
.is-red {
  background-color: rgb(255, 0, 153);
}
.el-button--small {
  background-color: rgb(242, 243, 245);
  border: 1px solid #909399;
  font-size: 0.9375rem;
  font-weight: solid;
}
</style>
