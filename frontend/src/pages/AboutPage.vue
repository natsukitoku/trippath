<template>
  <div>
    <h4>Vue + Spring Boot</h4>
    <button @click="fetchTrips">Fetch trips</button>
    <div v-if="trips">
      <label v-for="trip in trips" :key="trip.id"><p>{{ trip }}</p></label>
    </div>
  </div>

  </template>
  
  <script>
  import axios from 'axios';
  export default {
    name: 'AboutPage',
    data() {
      return {
        trips: null
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
    },
  };
  </script>
  