<template>
  <div class="container">
    <el-table
      class="center-table"
      :data="tableData"
      style="width: 100%; text-align: center"
    >
      <el-table-column
        fixed
        prop="username"
        label="申请用户"
        width="250"
        header-align="center"
      />
      <el-table-column
        fixed
        prop="type"
        label="申请类型"
        width="250"
        header-align="center"
      />
      <el-table-column
        fixed
        prop="beginDate"
        label="开始日期"
        width="220"
        header-align="center"
      />
      <el-table-column
        fixed
        prop="endDate"
        label="截止日期"
        width="220"
        header-align="center"
      />
      <el-table-column
        fixed
        prop="reason"
        label="申请原因"
        width="220"
        header-align="center"
      />
      <el-table-column fixed="right" label="操作" header-align="center">
        <template #default="{ row, $index }">
          <el-button link type="primary" @click="handlePass(row, $index)"
            >通过</el-button
          >
          <el-button link type="primary" @click="handleDelete($index)"
            >驳回</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script lang="ts" setup>
import { ref, onMounted } from "vue";
import {
  addLeave,
  selectLeave,
  addOvertime,
  selectOvertime,
} from "../api/apply.ts";

const newTableData = ref([
  {
    username: "",
    id: "",
    type: "",
    beginDate: "",
    endDate: "",
    reason: "",
  },
]);
const tableData = ref(newTableData);

onMounted(() => {
  selectLeave({ id: window.localStorage.uid })
    .then((res) => {
      newTableData.value += res.data;
    })
    .catch((err) => {
      console.log(err);
    });
  selectOvertime({ id: window.localStorage.uid })
    .then((res) => {
      newTableData.value += res.data;
    })
    .catch((err) => {
      console.log(err);
    });
});

const handlePass = (row, index) => {
  if (row.type === "请假") {
    addLeave({ id: row.id })
      .then((res) => {
        if (res.data) {
          tableData.value.splice(index, 1);
        }
      })
      .catch((err) => {
        console.log(err);
      });
  } else {
    addOvertime({ id: row.id })
      .then((res) => {
        if (res.data) {
          tableData.value.splice(index, 1);
        }
      })
      .catch((err) => {
        console.log(err);
      });
  }
};

const handleDelete = (index) => {
  tableData.value.splice(index, 1);
};
</script>

<style scoped lang="less">
.container {
  height: 50rem;
  margin-left: 6.25rem;
  padding: 10px 0 0 10px;
  margin-bottom: 10px;
  margin-right: 6.25rem;
  margin-top: 40px;
  background-color: var(--el-bg-color-overlay);
  border: 1px solid var(--el-border-color-light);
  border-radius: 4px;
  box-shadow: var(--el-box-shadow-light);
  display: flex; /* 使用Flex布局 */
  .el-button {
    font-size: 18px;
  }
}
.add-btn {
  margin-top: 2rem;
  margin-left: 5rem;
}
.center-table {
  height: 38rem;
  font-size: 18px;
}
:deep(.center-table td),
:deep(.center-table th) {
  text-align: center !important;
}
</style>
