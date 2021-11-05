<template>
        <!-- 登录盒子  -->
        <div style="position: sticky">
          <h2 style="text-align: center;margin-top: 2.25rem;color: #6c757d;">创建一个账户</h2>
            <!-- 登录表单 -->
            <el-form :model="loginForm" ref="LoginFormRef" :rules="loginFormRules" label-width="0px" class="login_form">
                <!-- 用户名 -->
                <el-form-item prop="username">
                    用户名:
                    <el-input v-model="loginForm.username" prefix-icon="iconfont icon-user" ></el-input>
                </el-form-item>
                <!-- 密码 -->
                <el-form-item prop="password">
                    密码:
                    <el-input type="password" v-model="loginForm.password" prefix-icon="iconfont icon-3702mima"></el-input>
                </el-form-item>
                <el-form-item >
                    确定密码:
                    <el-input type="password" v-model="loginForm.password" prefix-icon="iconfont icon-3702mima"></el-input>
                </el-form-item>
                <!-- 按钮 -->
                <el-form-item class="center">
                    <el-button type="primary" @click="login" class="primary-btn">注册</el-button>
                </el-form-item>
            </el-form>
        </div>
</template>

<script>
export default {
  data () {
    return {
      // 数据绑定
      loginForm: {
        username: '',
        password: ''
      },
      // 表单验证规则
      loginFormRules: {
        username: [
          {
            required: true,
            message: '请输入登录名',
            trigger: 'blur'
          },
          {
            min: 3,
            max: 10,
            message: '登录名长度在 3 到 10 个字符',
            trigger: 'blur'
          }
        ],
        password: [
          {
            required: true,
            message: '请输入密码',
            trigger: 'blur'
          },
          {
            min: 6,
            max: 15,
            message: '密码长度在 6 到 15 个字符',
            trigger: 'blur'
          }
        ]
      }
    }
  },

  // 添加行为，
  methods: {
    // 添加表单重置方法
    resetLoginForm () {
      // this=>当前组件对象，其中的属性$refs包含了设置的表单ref
      //   console.log(this)
      this.$refs.LoginFormRef.resetFields()
    },
    login () {
      // 点击登录的时候先调用validate方法验证表单内容是否有误
      this.$refs.LoginFormRef.validate(async valid => {
        console.log(this.loginFormRules)
        // 如果valid参数为true则验证通过
        if (!valid) {
          return
        }

        // 发送请求进行登录
        const { data: res } = await this.$http.post('login', this.loginForm)
        console.info(res)
        // if (res.status !== 200) {
        //   this.resetLoginForm()
        //   return this.$message.error('登录失败:' + res.msg) // console.log("登录失败:"+res.meta.msg)
        // }

        // this.$message.success('登录成功')
        // console.log(res)
        // // 保存token
        // window.sessionStorage.setItem('token', res.data.token)
        // // 导航至/home
        // this.$router.push('/home')
      })
    }
  }
}
</script>

<style lang="less" scoped>
  .login_form{
        margin: 0;
        font-family: Nunito, sans-serif;
        font-size: .9rem;
        font-weight: 400;
        line-height: 1.4;
        color: #6c757d;
        text-align: left;
        background-color: #fafbfe;
      bottom: 0;
      width: 99%;
      padding: 20px;
      box-sizing: border-box;
      padding-bottom: 5px;
      a {
        color: #4169e1;
        text-decoration: none;
        background-color: transparent;
      }
      .center{
        display: flex;
        align-items: center;
        justify-content: center;
        .primary-btn{
          box-shadow: 0 2px 6px 0 rgb(114 124 245 / 50%);
          margin-top: 1.0rem!important;
          width: 70%;
          background-color: #4169e1;
          border-color: #4169e1;
          font-weight: 400;
          padding: 14px 20px;
          text-align: center!important;
          width: 180px;
          }
      }
  }

</style>
