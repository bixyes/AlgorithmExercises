import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
    {
        path: '/emp', //地址hash
        name: 'emp',
        component: () => import('../views/tlias/EmpView.vue') //对应的vue组件
    },
    {
        path: '/dept',
        name: 'dept',
        component: () => import('../views/tlias/DeptView.vue')
    },
    // {
    //     path: '/',
    //     redirect: '/emp' //表示重定向到/emp即可
    // }
]

const router = new VueRouter({
    routes
})

export default router