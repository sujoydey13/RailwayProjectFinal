<template>
  <div>
    <navbar></navbar>
  <div id="historypane">
    <center>
    <div class="container">
      <h1>Booking History</h1>
      <table id="historytable">
        <tr>
          <thead>
            <tr>
              <th>Booking ID</th>
              <th>Train ID</th>
              <th>Train Name</th>
              <th>Departure Time</th>
              <th>Date of Journey</th>
              <th>Seats Booked</th>
              <th>Seat List</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="item in response" :key = "item.id">
              <td>{{item.bookingId}}</td>
              <td>{{item.trainId}}</td>
              <td>{{item.trainName}}</td>
              <td>{{item.departureTime}}</td>
              <td>{{item.dateOfJourney}}</td>
              <td>{{item.seatCount}}</td>
              <td>{{item.seatList}}</td>
            </tr>
          </tbody>
        </tr>
    </table>
    </div>
    </center>
<footerbar></footerbar>
</div>
</div>

</template>
<script>
import axios from 'axios'
import navbar from '../components/navbar.vue'
import { mapActions, mapGetters } from 'vuex'
import footer from '../components/footer.vue'
export default {
  name: 'historypane',
  data () {
    return {
      sessionId: localStorage.getItem('sessionID'),
      response: ''
    }
  },
  mounted () {
    const obj = {
      sessionID: localStorage.getItem('sessionID')
    }
    axios.post('http://10.177.68.4:8100/bookSearch/bookingHistory', obj).then((res) => {
      this.response = res.data
    })
  },
  computed: {
    ...mapGetters(['getBookingHistory'])
  },
  methods: {
    ...mapActions(['setBookingHistory'])
  },
  components: {
    navbar: navbar,
    footerbar: footer
  },
  created () {
    if (localStorage.getItem('sessionID') === null) {
      this.$router.push('/login')
    }
  }
}
</script>

<style scoped>

.container{
  margin-top: 100px;
  max-width: 1000px;
  width: 900px;
  padding: 20px
}
#historytable{
  min-width: 800px;
  width: 800px;
  box-shadow: 0 0 10px 1px gray;
  margin-bottom: 100px;
}

#historypane {
  text-align: center;
  box-shadow: 0 0 10px 1px gray;
  margin-bottom: 100px;
}
th{
    padding: 40px;
}
td{
    padding: 10px;
    text-align: center;
    box-shadow: 0 0 10px 1px gray;
}

</style>
