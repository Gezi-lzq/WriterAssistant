<template>
<div class="container">
  <el-card class="UserInfo">用户信息</el-card>
  <el-card class="Book">文章进度</el-card>
  <el-card class="TodoList">待办事项</el-card>
  <el-card class="statistics">统计</el-card>
</div>
</template>

<script>
export default {

}
</script>

<style scoped>
.container {
  display: grid;
  grid-template-columns: 1fr 0.4fr 1.6fr;
  grid-template-rows: 0.8fr 0.8fr 1.4fr;
  grid-auto-columns: 1fr;
  gap: 5px 5px;
  grid-auto-flow: row;
  grid-template-areas:
    "UserInfo UserInfo TodoList"
    "Book Book TodoList"
    "Book Book statistics";
    height: 100%;
}

.UserInfo { grid-area: UserInfo; }

.Book { grid-area: Book; }

.TodoList { grid-area: TodoList; }

.statistics { grid-area: statistics; }
</style>
