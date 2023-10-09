<script setup lang="ts">
import { ref } from "vue";
import { updateSchedule } from "../api/schedule.ts";

const userId = ref("");
const scheduleDate = ref("");
const scheduleOrder = ref("");
const scheduleInfo = ref("");
const showOvertimeDialog = ref(false);
const overtimeName = ref("");
const overtimeDate = ref("");

const cancelOvertimeForm = () => {
  overtimeName.value = "";
  overtimeDate.value = "";
  showOvertimeDialog.value = false;
};

const submitOvertimeForm = () => {
  const params = {
    id: userId.value,
    date: scheduleDate.value,
    order: scheduleOrder.value,
    data: scheduleInfo.value,
  };
  updateSchedule(params)
    .then((res) => {})
    .catch((err) => {
      console.log(err);
    });
  cancelOvertimeForm();
};

const onOvertimeDialogClose = () => {
  // 处理加班申请对话框关闭事件
  showOvertimeDialog.value = false;
};
</script>
<template>
  <div class="button-container">
    <div class="input-container">
      <el-button @click="showOvertimeDialog = true">修改排班</el-button>

      <el-dialog
        v-model="showOvertimeDialog"
        title="修改排班"
        @close="onOvertimeDialogClose"
      >
        <el-form>
          <el-form-item label="用户信息:">
            <el-input
              v-model="userId"
              class="text-input"
              placeholder="请输入用户id"
            ></el-input>
          </el-form-item>
          <el-form-item label="排班日期:">
            <el-input
              v-model="scheduleDate"
              class="text-input"
              placeholder="请输入排班日期"
            ></el-input>
          </el-form-item>
          <el-form-item label="排班次序:">
            <el-input
              v-model="scheduleOrder"
              class="text-input"
              placeholder="请输入排班次序"
            ></el-input>
          </el-form-item>
          <el-form-item label="排班信息:">
            <el-input
              v-model="scheduleInfo"
              class="text-input"
              placeholder="请输入排班信息"
            ></el-input>
          </el-form-item>
        </el-form>

        <span slot="footer" class="dialog-footer">
          <el-button @click="cancelOvertimeForm">取消</el-button>
          <el-button type="primary" @click="submitOvertimeForm">提交</el-button>
        </span>
      </el-dialog>
    </div>
  </div>
</template>

<style scoped>
.dialog-footer {
  display: flex;
  justify-content: flex-end;
  margin-top: 20px;
}

.input-container {
  display: flex;
  justify-content: space-between;
}

.text-input {
  flex: 1;
  margin-left: 10px;
}
.button-container {
  display: flex;
}

.input-container {
  margin-right: 10px; /* 调整按钮之间的间距 */
}
</style>
