<template>
    <div class="login_container">
        <!-- 登录盒子  -->
        <div class="login_box">
          <div class="text-center">
            <div class="btn-group">
              <el-button class="btn" :type="islogin ?'primary':'info'" plain @click="transferlogin" :disabled="islogin">登录</el-button>
              <el-button class="btn" :type="islogin ?'info':'primary'" plain @click="transferRegist" :disabled="!islogin">注册</el-button>
            </div>
          </div>
          <div>
            <router-view></router-view>
          </div>
          <div class="fool">
            欢迎光临写作助手
          </div>
        </div>
    </div>
</template>

<script>
export default {
  data() {
    return {
      islogin: true
    }
  },
  methods: {
    transferRegist() {
      this.islogin = false
      this.$router.push({ path: '/register' })
    },
    transferlogin() {
      this.islogin = true
      this.$router.push({ path: '/login' })
    }
  }
}
</script>

<style lang="less" scoped>
.login_container {
  background-color: #2b5b6b;
  height: 100%;
}
.login_box {
  width: 400px;
  min-height: 400px;
  margin: 0 auto;
  background: #fff;
  border-radius: 15px;
  position: absolute;
  left: 50%;
  top: 47%;
  box-shadow: 0 .5rem 1rem rgba(0,0,0,.15)!important;
  transform: translate(-50%, -50%);
  padding: 2.25rem!important;
  .text-center {
    text-align: center!important;
    .btn-group{
        position: relative;
        display: -webkit-inline-box;
        display: -ms-inline-flexbox;
        display: inline-flex;
        vertical-align: middle;
        .btn{
          margin-left: 0px;
          border-radius: 1px;
          padding: 12px 30px;
        }
    }
  }
  .fool{
    padding-top: .75rem!important;
    margin-top: 1.2rem!important;
    border-top: 1px solid #dee2e6!important;
    font-size: 0.9rem;
    font-family: Nunito, sans-serif;
    font-size: .9rem;
    font-weight: 400;
    line-height: 1.5;
    color: #6c757d;
    text-align: left;
    background-color: #fafbfe;
  }
}
</style>
