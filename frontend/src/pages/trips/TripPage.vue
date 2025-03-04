<template>
  <div>
    <h4>旅一覧</h4>
    <div v-if="res">{{ res }}</div>
    <div v-if="trips.length > 0" class="row">
      <div v-for="trip in trips" :key="trip.id">
          <q-card class="my-card q-ma-sm col">
            <q-card-section>
              <div class="row items-center no-wrap">
                <a href="./trips/detail" class="col">
                  <div class="text-h7">{{ trip.title }}</div>
                  <!-- <div class="text-subtitle2">by John Doe</div> -->
                </a>
              </div>
            </q-card-section>

            <q-separator />

            <q-card-actions vertical>
              <div flat>出発日：{{ trip.startDate }}</div>
              <div flat>終了日：{{ trip.endDate }}</div>
            </q-card-actions>
          </q-card>
      </div>
    </div>  
  </div>
  <q-btn label="新しい旅行先" color="primary" @click="newTrip = true" />
  <q-dialog v-model="newTrip">
      <q-card>
        <q-card-section>
          <div class="text-h6">新しい旅行登録</div>
        </q-card-section>

        <q-separator />

        <q-card-section style="max-height: 50vh" class="scroll">
          <q-form class="q-gutter-md">
            <q-input
              filled
              v-model="title"
              label="旅行名 *"
              lazy-rules
              :rules="[ val => val && val.length > 0 || '旅行名を入力してください']"
            />

            <q-input
              filled
              type="date"
              v-model="startDate"
              label="出発日 *"
            />
            <q-input
              filled
              type="date"
              v-model="endDate"
              label="終了日 *"
            />
          </q-form>
        </q-card-section>

        <q-separator />

        <q-card-actions align="right">
          <q-btn flat label="Reset" type="reset" color="red" v-close-popup @click="onReset"/>
          <q-btn flat label="Submit" type="submit" color="primary" v-close-popup @click="regist"/>
        </q-card-actions>
      </q-card>
    </q-dialog>
  </template>
  
  <script>
  import { ref, onMounted } from 'vue';
  import axios from 'axios';
  export default {
    name: 'TripPage',
    setup() {
      const trips = ref([]);

      const fetchTrips = () => {
        axios
            .get("http://localhost:8080/trip/index")
            .then((response) => {
              trips.value = response.data;
            })
            .catch((error) => {
              console.error("There was an error:", error);
            });
      };
      const newTrip = ref(false)
      const title = ref('')
      const startDate = ref('')
      const endDate = ref('')
      let res = ('')
      
      const regist = () => {
        console.log('登録された旅行名:', title.value);
        console.log('出発日:', startDate.value);
        console.log('終了日:', endDate.value);
        axios
          .post("http://localhost:8080/trip/create", {
            title: title.value,
            startDate: startDate.value,
            endDate: endDate.value
          })
          .then((response) => {
            console.log('バックエンドからのレスポンス:', response);
             res = response.data;
             console.log('res:',  res);
             fetchTrips();
          })
          .catch((error) => {
            console.log('エラー:', error);
          });
      };

      const onReset = () => {
        title.value = ''
        startDate.value = ''
        endDate.value = ''
      };

      onMounted(() => {
        fetchTrips();
      });
 
      return {
        trips,
        newTrip,
        title,
        startDate,
        endDate,
        regist,
        onReset,
        res
      };
    }
  };
  </script>