<script setup lang="ts">
import { ref } from "vue";
import { addLeave, addOvertime } from "../api/apply.ts";

const showLeaveDialog = ref(false);
const leaveName = ref("");
const leaveDate = ref("");
const leaveReason = ref("");

const showOvertimeDialog = ref(false);
const overtimeName = ref("");
const overtimeDate = ref("");

const cancelLeaveForm = () => {
  leaveName.value = "";
  leaveDate.value = "";
  leaveReason.value = "";
  showLeaveDialog.value = false;
};

const submitLeaveForm = () => {
  const params = {
    userID: window.localStorage.uid,
    reason: leaveReason.value,
    date: leaveDate.value,
  };
  addLeave(params).then((res) => {});
  cancelLeaveForm();
};

const cancelOvertimeForm = () => {
  overtimeName.value = "";
  overtimeDate.value = "";
  showOvertimeDialog.value = false;
};

const submitOvertimeForm = () => {
  const params = {
    userID: window.localStorage.uid,
    date: overtimeDate.value,
  };
  addOvertime(params).then((res) => {});
  cancelOvertimeForm();
  showOvertimeDialog.value = false;
};

const onLeaveDialogClose = () => {
  // 处理请假申请对话框关闭事件
  showLeaveDialog.value = false;
};

const onOvertimeDialogClose = () => {
  // 处理加班申请对话框关闭事件
  showOvertimeDialog.value = false;
};
</script>
<template>
  <div class="button-container">
    <div class="input-container">
      <el-button @click="showOvertimeDialog = true">加班申请</el-button>

      <el-dialog
        v-model="showOvertimeDialog"
        title="加班申请"
        @close="onOvertimeDialogClose"
      >
        <el-form>
          <el-form-item label="姓名:" style="margin-left: 30px">
            <el-input
              v-model="overtimeName"
              class="text-input"
              placeholder="请输入姓名"
            ></el-input>
          </el-form-item>
          <el-form-item label="加班日期:">
            <el-input
              v-model="overtimeDate"
              class="text-input"
              placeholder="请输入加班日期"
            ></el-input>
          </el-form-item>
        </el-form>

        <span slot="footer" class="dialog-footer">
          <el-button @click="cancelOvertimeForm">取消</el-button>
          <el-button type="primary" @click="submitOvertimeForm">提交</el-button>
        </span>
      </el-dialog>
    </div>
    <div class="input-container">
      <el-button @click="showLeaveDialog = true">请假申请</el-button>
      <el-dialog
        v-model="showLeaveDialog"
        title="请假申请"
        @close="onLeaveDialogClose"
      >
        <el-form>
          <el-form-item label="姓名:" style="margin-left: 30px">
            <el-input
              v-model="leaveName"
              class="text-input"
              placeholder="请输入姓名"
            ></el-input>
          </el-form-item>
          <el-form-item label="请假日期:">
            <el-input
              v-model="leaveDate"
              class="text-input"
              placeholder="请输入请假日期"
            ></el-input>
          </el-form-item>
          <el-form-item label="请假理由:">
            <el-input v-model="leaveReason" class="text-input"></el-input>
          </el-form-item>
        </el-form>

        <span slot="footer" class="dialog-footer">
          <el-button @click="cancelLeaveForm">取消</el-button>
          <el-button type="primary" @click="submitLeaveForm">提交</el-button>
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
