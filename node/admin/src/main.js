// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

Vue.config.productionTip = false

import 'font-awesome/css/font-awesome.min.css'

import ElementUI from 'element-ui'
import './assets/theme/element-#0b0a3e/index.css'
Vue.use(ElementUI)

//开发模式开启mock.js
if (process.env.NODE_ENV === 'development') {
  require('./mock')
}

import axios from 'axios'
Vue.prototype.$axios = axios

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: {
    App
  },
  template: '<App/>'
})
