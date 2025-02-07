<template>
  <q-layout view="lHh Lpr lFf">
    <q-header elevated class="glossy">
      <q-toolbar>
        <q-btn
          flat
          dense
          round
          @click="leftDrawerOpen = !leftDrawerOpen"
          aria-label="Menu"
          icon="menu"
        />

        <q-toolbar-title>
          TripPath
        </q-toolbar-title>
        <q-btn flat label="Home" to="/" />
        <q-btn flat label="About" to="/about" />

      </q-toolbar>
    </q-header>

    <q-drawer
      v-model="leftDrawerOpen"
      show-if-above
      bordered
      class="bg-grey-2"
    >
      <q-list>
        <q-item-label header>Essential Links</q-item-label>
        <!-- tripsページへの遷移ボタン -->
      <q-item clickable to="/trips">
        <q-item-section>
          <q-btn flat label="旅一覧" />
        </q-item-section>
      </q-item>
      </q-list>
    </q-drawer>

    <q-page-container>
      <router-view />
    </q-page-container>
  </q-layout>
</template>

<script>
import { ref } from 'vue'

export default {
  name: 'LayoutDefault',

  setup () {
    return {
      leftDrawerOpen: ref(false)
    }
  }
}
</script>
