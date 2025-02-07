import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { Quasar } from 'quasar'
import quasarUserOptions from './quasar-user-options'

createApp(App)
  .use(router) // router を登録
  .use(Quasar, quasarUserOptions) // Quasar を登録
  .mount('#app')
