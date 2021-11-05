<template>
  <div class="container">
    <el-card class="researchSpace">
      <el-tabs type="border-card">
      <el-tab-pane label="资料卡">资料库</el-tab-pane>
      <el-tab-pane label="章节管理">章节管理</el-tab-pane>
      <el-tab-pane label="随机灵感">随机灵感</el-tab-pane>
      <el-tab-pane label="随记">随记</el-tab-pane>
</el-tabs>
    </el-card>
    <el-card class="WriteSpace">
      <editor></editor>
    </el-card>
  </div>
</template>

<script>
import Editor from './Editor/Editor.vue'

export default {
  components: { Editor }
}

</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 0.9fr 1.1fr 1fr;
  grid-template-rows: 1fr 1fr 1fr;
  gap: 5px 5px;
  grid-auto-flow: row;
  grid-template-areas:
    "researchSpace WriteSpace WriteSpace"
    "researchSpace WriteSpace WriteSpace"
    "researchSpace WriteSpace WriteSpace";
    height: 100%;
}

.WriteSpace { grid-area: WriteSpace; }

.researchSpace { grid-area: researchSpace; }

</style>
