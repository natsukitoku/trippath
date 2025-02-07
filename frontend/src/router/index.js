import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/HomePage.vue';
import AboutPage from '../pages/AboutPage.vue';
import TripPage from '../pages/trips/TripPage.vue';

const routes = [
  { path: '/', component: HomePage },
  { path: '/about', component: AboutPage },
  { path: '/trips', component: TripPage },
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
