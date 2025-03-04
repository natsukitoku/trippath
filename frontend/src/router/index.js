import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/HomePage.vue';
import AboutPage from '../pages/AboutPage.vue';
import TripPage from '../pages/trips/TripPage.vue';
import DetailPage from '../pages/trips/DetailPage.vue';

const routes = [
  { path: '/', component: HomePage },
  { path: '/about', component: AboutPage },
  { path: '/trips', component: TripPage },
  { path: '/trips/detail', component: DetailPage}
];

const router = createRouter({
  history: createWebHistory(),
  routes,
});

export default router;
