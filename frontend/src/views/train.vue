<template>
    <div>
      <center>
      <div class="container">
          <div class="inner-container">
          <div class="heading">
            <h3>Add Train</h3>
          </div>
          <div class="content">
            <input type="text" v-model="id" placeholder="Train Id" name="id" class="input-css">
            <input type="text" v-model="name" placeholder="Train Name" name="name" class="input-css">
            <input type="text" v-model="startLocation" placeholder="Start Location" name="endlocation" class="input-css">
            <input type="text" v-model="endLocation" placeholder="End Location" name="startlocation" class="input-css">
            <input type="time" v-model="departureTime" placeholder="Departure Time" name="departuretime" class="input-css">
            <input type="number" v-model="bogie" placeholder="Num Of Bogies" min=1 name="bogie" class="input-css">
            <button class="btn" @click="onsubmit">Add</button>
          </div>
          <div class="footer">
            <router-link to="/search" class="login-register-router">Home</router-link>
          </div>
          </div>
        </div>
      </center>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'train',
  data () {
    return {
      id: '',
      name: '',
      startLocation: '',
      endLocation: '',
      departureTime: '',
      bogie: ''
    }
  },
  methods: {
    convertTime () {
      var time12h = this.departureTime
      const [time, modifier] = time12h.split(' ')
      let [hours, minutes] = time.split(':')
      if (hours === '12') {
        hours = '00'
      }
      if (modifier === 'PM') {
        hours = parseInt(hours, 10) + 12
      }
      return hours + ':' + minutes
    },
    onsubmit () {
      this.departureTime = this.convertTime()
      const obj = {
        trainId: this.id.toLowerCase,
        name: this.name.toLowerCase,
        startLocation: this.startLocation.toLowerCase,
        endLocation: this.endLocation.toLowerCase,
        departureTime: this.departureTime.toLowerCase,
        bogie: this.bogie
      }
      axios.post('http://10.177.68.4:8100/adminPage/add', obj).then((res) => {
      })
    }
  },
  created () {
    if (localStorage.getItem('isAdmin') !== 'true') {
      this.$router.push('/admin')
    }
  }
}
</script>

<style>

</style>
