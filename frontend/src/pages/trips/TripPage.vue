<template>
  <div>
    <h4>旅一覧</h4>
    <button @click="fetchTrips">Fetch trips</button>
    <div v-if="trips">
      <label v-for="trip in trips" :key="trip.id">
        <p>{{ trip.creatorId }}</p>
        <p>{{ trip.title }}</p>
        <p>{{ trip.startDate }}</p>
        <p>{{ trip.endDate }}</p>
      </label>
    </div>
  </div>
  <q-btn label="新しい旅行先" color="primary" @click="fixed = true" />
  <q-dialog v-model="fixed">
      <q-card>
        <q-card-section>
          <div class="text-h6">新しい旅行登録</div>
        </q-card-section>

        <q-separator />

        <q-card-section style="max-height: 50vh" class="scroll">
          <q-form
            @submit="onSubmit"
            @reset="onReset"
            class="q-gutter-md"
          >
            <q-input
              filled
              v-model="tripName"
              label="旅行名 *"
              hint="Name and surname"
              lazy-rules
              :rules="[ val => val && val.length > 0 || 'Please type something']"
            />

            <q-input
              filled
              type="number"
              v-model="出発日"
              label="出発日 *"
              lazy-rules
              :rules="[
                val => val !== null && val !== '' || 'Please type your age',
                val => val > 0 && val < 100 || 'Please type a real age'
              ]"
            />
            <q-input
              filled
              type="date"
              v-model="終了日"
              label="終了日 *"
              lazy-rules
              :rules="[
                val => val !== null && val !== '' || 'Please type your age',
                val => val > 0 && val < 100 || 'Please type a real age'
              ]"
            />
          </q-form>
        </q-card-section>

        <q-separator />

        <q-card-actions align="right">
          <q-btn flat label="Submit" type="submit" v-close-popup />
          <q-btn flat label="Reset" type="reset" color="primary" v-close-popup />
        </q-card-actions>
      </q-card>
    </q-dialog>
  </template>
  
  <script>
  import axios from 'axios';
  export default {
    name: 'TripPage',
    data() {
      return {
        trips: null,
        fixed: false,
        name: '',
        age:''
      };
    },
    methods: {
      fetchTrips() {
        axios
            .get("http://localhost:8080/trip/index")
            .then((response) => {
              this.trips = response.data;
            })
            .catch((error) => {
              console.error("There was an error:", error);
            });
      },
      onSubmit() {
        console.log
      }
    },
  };
  </script>