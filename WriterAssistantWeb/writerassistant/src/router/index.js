import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login.vue'
import Register from '../components/Register.vue'
import Welcome from '../views/Welcome'
import Home from '../views/Home/Home.vue'
import User from '../components/User.vue'
import Mind from '../components/Mind.vue'
import Write from '../components/Write.vue'

Vue.use(Router)

const router = new Router({
  routes: [
    {
      path: '/',
      redirect: '/welcome'
    },
    {
      path: '/welcome',
      component: Welcome,
      redirect: '/login',
      children: [
        {
          path: '/register',
          component: Register
        },
        {
          path: '/login',
          component: Login,
          name: 'login'
        }
      ]
    },
    {
      path: '/home',
      component: Home,
      redirect: '/user',
      children: [
        { path: '/user', component: User },
        { path: '/mind', component: Mind },
        { path: '/write', component: Write }
      ]
    }
  ]
})

// 挂载路由导航守卫,to表示将要访问的路径，from表示从哪里来，next是下一个要做的操作
router.beforeEach((to, from, next) => {
  if (to.path === '/login' || to.path === '/register') {
    return next()
  }

  // 获取token
  const tokenStr = window.sessionStorage.getItem('token')
  // 此处验证较为儿戏
  if (!tokenStr) {
    return next('/login')
  }
  next()
})

export default router
