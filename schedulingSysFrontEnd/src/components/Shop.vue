<script setup lang="ts">
import { ref, onMounted } from "vue";
import { House } from "@element-plus/icons-vue";
import StoreChart from "./StoreChart.vue";
import { getBusiness } from "../api/chart.ts";
import { addStore, deleteStore } from "../api/shop";

const arr = ref([
  {
    name: "",
    id: "",
    num: "",
  },
]);
const showOvertimeDialog = ref(false);
const shopName = ref("");
const shopID = ref("");

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

const showDialog: Function = () => {
  showOvertimeDialog.value = true;
};
const onDialogClose: Function = () => {
  showOvertimeDialog.value = false;
};
const cancel: Function = () => {
  showOvertimeDialog.value = false;
};
const addShop: Function = () => {
  const params = {
    name: shopName.value,
    id: shopID.value,
  };
  addStore(params)
    .then((res) => {
      if (res.code === 1) {
        console.log(res.data);
      }
    })
    .catch((err) => {
      console.log(err);
    });
};

const deleteShop: Function = (sid: number) => {
  deleteStore({ id: sid })
    .then((res) => {})
    .catch((err) => {
      console.log(err);
    });
};
</script>

<template>
  <div class="shop-component">
    <ul>
      <li v-for="it in arr">
        <el-icon size="140px"><House /></el-icon>
        <h3>{{ it.name }}</h3>
        <h3>店铺ID:{{ it.id }}</h3>
        <h3>当日客流量:{{ it.num }}</h3>
        <el-button type="primary">编辑信息</el-button>
        <el-button type="primary" @click="deleteShop(it.id)"
          >删除店铺</el-button
        >
      </li>
    </ul>
    <div class="add">
      <el-button type="primary" @click="showDialog">增加店铺</el-button>
    </div>
    <el-dialog
      v-model="showOvertimeDialog"
      title="增加店铺"
      @close="onDialogClose"
    >
      <el-form>
        <el-form-item label="店铺:" style="margin-left: 30px">
          <el-input
            v-model="shopName"
            class="text-input"
            placeholder="请输入店铺名称"
          ></el-input>
        </el-form-item>
        <el-form-item label="店ID:" style="margin-left: 30px">
          <el-input
            v-model="shopID"
            class="text-input"
            placeholder="请输入SID"
          ></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancel">取消</el-button>
        <el-button type="primary" @click="addShop">提交</el-button>
      </span>
    </el-dialog>
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
    .el-button {
      margin-left: 25px;
      margin-top: 8px;
    }
    h3 {
      margin-top: 10%;
      text-align: center;
    }
  }
  .add {
    width: 200px;
    height: 50px;
    margin: 0 auto 20px;
  }
  .dialog-footer {
    margin-left: 250px;
  }
}
</style>
