<template>
  <div class="add-btn">
    <el-button
      color="#626aef"
      style="width: 120px; margin: 0.75rem 0 0 6.25rem"
      @click="handleAdd"
    >
      增加
    </el-button>
  </div>
  <div class="container">
    <el-table
      class="center-table"
      :data="tableData"
      style="width: 100%; text-align: center"
    >
      <el-table-column
        fixed
        prop="name"
        label="节日名称"
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
      <el-table-column fixed="right" label="操作" header-align="center">
        <template #default="{ row, $index }">
          <el-button link type="primary" @click="handleClick(row)"
            >修改</el-button
          >
          <el-button link type="primary" @click="handleDelete($index)"
            >删除</el-button
          >
        </template>
      </el-table-column>
    </el-table>
  </div>
  <!-- 修改的模态框 -->
  <el-dialog v-model="dialogVisible" title="修改节日信息" @close="resetForm">
    <el-form :model="editForm" label-width="80px">
      <el-form-item label="节日名称">
        <el-input v-model="editForm.name"></el-input>
      </el-form-item>
      <el-form-item label="开始日期">
        <el-input v-model="editForm.beginDate"></el-input>
      </el-form-item>
      <el-form-item label="截止日期">
        <el-input v-model="editForm.endDate"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="saveEdit(editForm)">保 存</el-button>
    </div>
  </el-dialog>
  <!-- 增加的模态框 -->
  <el-dialog v-model="Visible" title="增加节日信息" @close="resetForm2">
    <el-form :model="editForm2" label-width="80px">
      <el-form-item label="节日名称">
        <el-input v-model="editForm2.name"></el-input>
      </el-form-item>
      <el-form-item label="开始日期">
        <el-input v-model="editForm2.beginDate"></el-input>
      </el-form-item>
      <el-form-item label="截止日期">
        <el-input v-model="editForm2.endDate"></el-input>
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer">
      <el-button @click="Visible = false">取 消</el-button>
      <el-button type="primary" @click="saveAdd(editForm2)">保 存</el-button>
    </div>
  </el-dialog>
</template>

<script lang="ts" setup>
import { ref, onMounted } from "vue";
import { addVacation, selectVacation } from "../api/apply.ts";

const newTableData = ref([
  {
    id: "",
    name: "",
    beginDate: "",
    endDate: "",
  }
]);
const tableData = ref(newTableData);
const dialogVisible = ref(false);
const Visible = ref(false);
const editForm = ref({
  id: "",
  name: "",
  beginDate: "",
  endDate: "",
});
const editForm2 = ref({
  id: "",
  name: "",
  beginDate: "",
  endDate: "",
});

onMounted(() => {
  selectVacation({ id: window.localStorage.uid }).then((res) => {
    newTableData.value = res.data;
  });
});

const handleAdd = () => {
  Visible.value = true;
};

const handleClick = (row) => {
  editForm.value = { ...row }; // 使用对象解构复制对应行的数据到编辑表单
  dialogVisible.value = true; // 打开模态框
};

const saveEdit = (editForm) => {
  tableData.value = tableData.value.map((item) => {
    // console.log(editForm)
    if (editForm.id == item.id) {
      return { ...editForm };
    } else {
      return { ...item };
    }
  });
  console.log("点击了保存");
  dialogVisible.value = false;
};

const resetForm = () => {
  editForm.value = { name: "", beginDate: "", endDate: "" };
};
//删除功能
const handleDelete = (index) => {
  tableData.value.splice(index, 1); // 在数组中删除指定索引处的元素
};
// 增加功能函数
const saveAdd = (editForm2) => {
  // 校验表单数据是否为空
  if (!editForm2.name || !editForm2.bdata || !editForm2.ddata) {
    // 表单数据不完整，提示用户输入完整信息
    alert("请填写完整的节日信息");
    return;
  }

  // 生成唯一的id
  const newId = (tableData.value.length + 1).toString();

  const params = {
    calendarId: newId,
    date: new Date(),
    userId: window.localStorage.uid,
  };

  addVacation(params).then((res) => {
    // 构造新增的节日对象
    const newFestival = {
      id: newId,
      name: editForm2.name,
      beginDate: editForm2.beginDate,
      endDate: editForm2.endDate,
    };

    // 将新增的节日对象添加到tableData中
    tableData.value.push(newFestival);

    // 关闭模态框
    Visible.value = false;

    // 重置编辑表单
    resetForm2();
  });
};

const resetForm2 = () => {
  editForm2.value = { name: "", beginDate: "", endDate: "" }; // 重置编辑表单
};
</script>

<style scoped>
.container {
  height: 40rem;
  margin-left: 6.25rem;
  padding: 10px 0 0 10px;
  margin-bottom: 10px;
  margin-right: 6.25rem;
  margin-top: 20px;
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
