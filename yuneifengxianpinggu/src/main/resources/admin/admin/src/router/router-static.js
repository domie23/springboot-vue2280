import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
// 解决多次点击左侧菜单报错问题
const VueRouterPush = VueRouter.prototype.push
VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
}
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

import users from '@/views/modules/users/list'
import dictionary from '@/views/modules/dictionary/list'
import gonggao from '@/views/modules/gonggao/list'
import qiufan from '@/views/modules/qiufan/list'
import qiufanpinggu from '@/views/modules/qiufanpinggu/list'
import qiufanshiji from '@/views/modules/qiufanshiji/list'
import xuanchuan from '@/views/modules/xuanchuan/list'
import xuanchuanCollection from '@/views/modules/xuanchuanCollection/list'
import yonghu from '@/views/modules/yonghu/list'
import yujing from '@/views/modules/yujing/list'
import config from '@/views/modules/config/list'
import dictionaryBaoli from '@/views/modules/dictionaryBaoli/list'
import dictionaryBiangu from '@/views/modules/dictionaryBiangu/list'
import dictionaryCuozhe from '@/views/modules/dictionaryCuozhe/list'
import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
import dictionaryJieguo from '@/views/modules/dictionaryJieguo/list'
import dictionaryQiufanshiji from '@/views/modules/dictionaryQiufanshiji/list'
import dictionarySex from '@/views/modules/dictionarySex/list'
import dictionaryTaotuo from '@/views/modules/dictionaryTaotuo/list'
import dictionaryWeijin from '@/views/modules/dictionaryWeijin/list'
import dictionaryXuanchuan from '@/views/modules/dictionaryXuanchuan/list'
import dictionaryXuanchuanCollection from '@/views/modules/dictionaryXuanchuanCollection/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
        // 这里不设置值，是把main作为默认页面
        path: '/',
        name: '首页',
        component: Home,
        meta: {icon:'', title:'center'}
    }, {
        path: '/updatePassword',
        name: '修改密码',
        component: UpdatePassword,
        meta: {icon:'', title:'updatePassword'}
    }, {
        path: '/pay',
        name: '支付',
        component: pay,
        meta: {icon:'', title:'pay'}
    }, {
        path: '/center',
        name: '个人信息',
        component: center,
        meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
    }
        ,{
            path: '/dictionaryBaoli',
            name: '暴力倾向',
            component: dictionaryBaoli
        }
        ,{
            path: '/dictionaryBiangu',
            name: '重大变故',
            component: dictionaryBiangu
        }
        ,{
            path: '/dictionaryCuozhe',
            name: '改造中的重大挫折',
            component: dictionaryCuozhe
        }
        ,{
            path: '/dictionaryGonggao',
            name: '公告类型',
            component: dictionaryGonggao
        }
        ,{
            path: '/dictionaryJieguo',
            name: '评价结果',
            component: dictionaryJieguo
        }
        ,{
            path: '/dictionaryQiufanshiji',
            name: '囚犯事迹类型',
            component: dictionaryQiufanshiji
        }
        ,{
            path: '/dictionarySex',
            name: '性别类型',
            component: dictionarySex
        }
        ,{
            path: '/dictionaryTaotuo',
            name: '存在逃脱',
            component: dictionaryTaotuo
        }
        ,{
            path: '/dictionaryWeijin',
            name: '违禁物品',
            component: dictionaryWeijin
        }
        ,{
            path: '/dictionaryXuanchuan',
            name: '宣传类型',
            component: dictionaryXuanchuan
        }
        ,{
            path: '/dictionaryXuanchuanCollection',
            name: '收藏表类型',
            component: dictionaryXuanchuanCollection
        }
        ,{
            path: '/config',
            name: '轮播图',
            component: config
        }


        ,{
            path: '/dictionary',
            name: '字典',
            component: dictionary
        }
        ,{
            path: '/gonggao',
            name: '公告',
            component: gonggao
        }
        ,{
            path: '/qiufan',
            name: '囚犯',
            component: qiufan
        }
        ,{
            path: '/qiufanpinggu',
            name: '囚犯评估',
            component: qiufanpinggu
        }
        ,{
            path: '/qiufanshiji',
            name: '囚犯事迹',
            component: qiufanshiji
        }
        ,{
            path: '/xuanchuan',
            name: '宣传',
            component: xuanchuan
        }
        ,{
            path: '/xuanchuanCollection',
            name: '宣传收藏',
            component: xuanchuanCollection
        }
        ,{
            path: '/yonghu',
            name: '用户',
            component: yonghu
        }
        ,{
            path: '/yujing',
            name: '狱警',
            component: yujing
        }


    ]
},
    {
        path: '/login',
        name: 'login',
        component: Login,
        meta: {icon:'', title:'login'}
    },
    {
        path: '/register',
        name: 'register',
        component: register,
        meta: {icon:'', title:'register'}
    },
    {
        path: '/',
        name: '首页',
        redirect: '/index'
    }, /*默认跳转路由*/
    {
        path: '*',
        component: NotFound
    }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
    mode: 'hash',
    /*hash模式改为history*/
    routes // （缩写）相当于 routes: routes
})

export default router;
