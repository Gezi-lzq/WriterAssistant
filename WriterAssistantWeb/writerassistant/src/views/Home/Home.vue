<template>
  <el-container class="home-container">
    <!-- 头部区域 -->
    <el-header>
      <div>
        <!-- logo -->
        <!-- <img src="../assets/people.jpg" alt=""> -->
        <!-- 顶部标题 -->
        <span> WriterAssistant</span>
      </div>
      <el-button
        type="info"
        @click="logout"
      > 退出 </el-button>
    </el-header>
    <!-- 页面主体区域 -->
    <el-container>
      <!-- 侧边栏 -->
      <el-aside :width="isCollapse ? `64px`:'210px'">
        <!-- 伸缩侧边栏按钮 -->
        <div class="toggle-button" @click="toggleCollapse">|||</div>
        <!-- 侧边栏菜单 -->
        <!-- 侧边栏菜单，
        :collapse="isCollapse"（设置折叠菜单为绑定的 isCollapse 值），
        :collapse-transition="false"（关闭默认的折叠动画） -->
        <el-menu
          :collapse="isCollapse"
          :collapse-transition="false"
          background-color="#333744"
          text-color="#fff"
          active-text-color="#ffd04b"
          :router="true"
        >
          <el-menu-item
              :index="'/'+item.path"
              v-for="item in menuList"
              :key="item.id"
            >
              <template>
                <!-- 图标 -->
                <i :class="item.icon"></i>
                <!-- 文本 -->
                <span>{{item.authName}}</span>
              </template>
            </el-menu-item>
        </el-menu>
      </el-aside>
      <!-- 主体结构 -->
      <el-main>
        <!-- 路由占位符 -->
        <router-view></router-view>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
export default {
  data() {
    return {
      // 是否折叠
      isCollapse: false,
      menuList: [
        { id: 1, authName: '我的主页', icon: 'el-icon-user', path: 'user' },
        { id: 2, authName: '构思', icon: 'el-icon-s-opportunity', path: 'mind' },
        { id: 3, authName: '写作', icon: 'el-icon-s-management', path: 'write' }
      ]
    }
  },
  methods: {
    logout() {
      window.sessionStorage.clear()
      this.$router.push('/login')
    },
    toggleCollapse() {
      this.isCollapse = !this.isCollapse
    }
  }
}
</script>

<style lang="less" scoped>
.home-container {
  height: 100%;
}
.el-header {
  background-color: #333333;
  display: flex;
  justify-content: space-between;
  padding-left: 12px;
  align-items: center;
  color: #fff;
  font-size: 20px;
  > div {
    display: flex;
    align-items: center;
    span {
      margin-left: 15px;
    }
  }
}
.el-aside {
  background-color: #252526;
  .el-menu {
    border-right: none;
  }
}

.el-main {
  background-color: #eaedf1;
}

.iconfont {
  margin-right: 10px;
}

.toggle-button {
  background-color: #4a5064;
  font-size: 10px;
  line-height: 24px;
  color: #fff;
  text-align: center;
  letter-spacing: 0.2em;
  cursor: pointer;
}
</style>
