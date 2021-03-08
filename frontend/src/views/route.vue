<template>
  <div class="route-container">
    <center>
    <table>
      <tr>
        <td><input type="text" class="input-css" v-model="start" placeholder="Start Location"></td>
        <td><input type="text" class="input-css" v-model="startDist" placeholder="Distance"></td>
      </tr>
      <tr v-for="(c, k) in stopsCount" :key="k">
        <td><input type="text" class="input-css" v-model="stops[k]" placeholder="Location"></td>
        <td><input type="text" class="input-css" v-model="stopsDist[k]" placeholder="Distance"></td>
      </tr>
      <tr>
        <td><button class="btn" @click="update">Add Stop</button></td>
        <td><button class="btn" @click="demote">Remove Stop</button></td>
      </tr>
      <tr>
        <td><input type="text" class="input-css" v-model="end" placeholder="End Location"></td>
        <td><input type="text" class="input-css" v-model="endDist" placeholder="Distance"></td>
      </tr>
      <tr>
        <td colspan="2"><button class="btn" @click="onsubmit">Add To DB</button></td>
      </tr>
    </table>
    </center>
  </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'route',
  data () {
    return {
      stopsCount: 0,
      start: '',
      startDist: '0',
      stops: [],
      stopsDist: [],
      end: '',
      endDist: ''
    }
  },
  methods: {
    update () {
      this.stopsCount++
    },
    demote () {
      this.stopsCount--
    },
    onsubmit () {
      const arr = []
      arr.push({ name: this.start, distance: this.startDist })
      var stops = this.stops
      var stopsDist = this.stopsDist
      stops.forEach(function (value, index) {
        arr.push({ name: value, distance: stopsDist[index] })
      })
      arr.push({ name: this.end, distance: this.endDist })
      const obj = {
        routes: arr
      }
      console.log(arr)
      var url = 'http://10.177.68.4:8100/route'
      axios.post(url, obj).then((res) => {
        console.log(res)
        this.response = res.data
      })
    }
  }
}
</script>

<style>
  .route-container{
    margin-top: 100px
  }
</style>>
