import Vue from 'vue'
import VueRouter from 'vue-router'
import register from '@/views/register.vue'
import login from '@/views/login.vue'
import search from '@/views/search.vue'
import train from '@/views/train.vue'
import auth from '@/views/auth.vue'
import book from '@/views/book.vue'
import confirm from '@/views/confirm.vue'
import route from '@/views/route.vue'
import admin from '@/views/admin.vue'
import userprofile from '@/views/userprofile.vue'
import historypane from '@/views/historypane.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/register',
    name: 'Register',
    component: register
  },
  {
    path: '/login',
    name: 'Login',
    component: login
  },
  {
    path: '/search',
    name: 'Search',
    component: search
  },
  {
    path: '/train',
    name: 'Train',
    component: train
  },
  {
    path: '/book',
    name: 'Book',
    component: book
  },
  {
    path: '/admin',
    name: 'Admin',
    component: admin
  },
  {
    path: '/historypane',
    name: 'Historypane',
    component: historypane
  },
  {
    path: '/userprofile',
    name: 'Userprofile',
    component: userprofile
  },
  {
    path: '/confirm',
    name: 'Confirm',
    component: confirm
  },
  {
    path: '/route',
    name: 'Route',
    component: route
  },
  {
    path: '/',
    name: 'Auth',
    component: auth
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
