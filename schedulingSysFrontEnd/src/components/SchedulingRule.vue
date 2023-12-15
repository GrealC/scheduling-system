<script setup lang="ts">
import { ref, onMounted } from "vue";
import RuleModule from "./RuleModule.vue";
import { getRule, saveRule } from "../api/rule";
import { getAllStores } from "../api/shop"

const firstRule = ref({});
const midRule = ref({});
const lastRule = ref({});
const selectValue = ref("");
const options = ref([{ value: "" }]);

//初始化
onMounted(() => {
  getRule({ storeId: selectValue.value }).then((res) => {
    firstRule.value = res.data[0];
    midRule.value = res.data[1];
    lastRule.value = res.data[2];
  });
  getAllStores()
    .then((res) => {
      if (res.code === 1) {
        options.value = res.data;
      }
    })
    .catch((err) => {
      console.log(err);
    });
});
//切换店时改变Rule
const updateRule: Function = () => {
  getRule({ storeId: selectValue.value }).then((res) => {
    firstRule.value = res.data[0];
    midRule.value = res.data[1];
    lastRule.value = res.data[2];
  });
};
//保存设置
const save: Function = () => {
  const params = {
    firstRule: firstRule.value,
    midRule: midRule.value,
    lastRule: lastRule.value,
  }
  saveRule(params).then(res=>{
    if(res.code !==) {
      console.log(res.data);
    }
  }).catch(err=>{
    console.log(err);
  })
}
//取消设置
const handleCancel: Function = () =>{
  getRule({ storeId: selectValue.value }).then((res) => {
    firstRule.value = res.data[0];
    midRule.value = res.data[1];
    lastRule.value = res.data[2];
  });
}

</script>

<template>
  <div class="rule">
    <div class="rule-main">
      <div class="select-bg">
        <div class="select-store">
          <h3>请选择店铺</h3>
          <el-select
            v-model="selectValue"
            @change="updateRule"
            class="m-2"
            placeholder="店铺名称"
          >
            <el-option
              v-for="item in options"
              :key="item.value"
              :value="item.value"
            />
          </el-select>
        </div>
      </div>
      <RuleModule :rule="firstRule" rank="早班规则" />
      <RuleModule :rule="midRule" rank="中班规则" />
      <RuleModule :rule="lastRule" rank="晚班规则" />
      <div class="btn-box">
        <el-button
        type="primary"
        style="max-width: 8.125rem; margin-left: 3.125rem"
        @click="save"
        >保存设置</el-button>
        <el-button
        type="primary"
        style="max-width: 8.125rem; margin-left: 3.125rem"
        @click="handleCancel"
        >取消设置</el-button>
      </div>
    </div>
  </div>
</template>

<style lang="less" scoped>
.rule {
  width: 100%;
  height: 100%;
  .rule-main {
    width: 100%;
    height: 100%;
    .btn-box {
      width: 400px;
      height: 50px;
      margin: 0 auto;
      margin-bottom: 100px;
    }
  }
  .select-bg {
    width: 50%;
    height: 7%;
    margin: 2% auto 1%;
    background-color: #fff;
    box-shadow: 1px 1px 1px 1px rgba(197, 197, 197, 0.5);
    .select-store {
      width: 100px;
      margin: 0 auto;
      select {
        margin: 0 auto;
        font-size: 16px;
        margin-left: 0.3rem;
      }
    }
  }
}
</style>
