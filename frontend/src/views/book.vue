<template>
  <div>
    <div>
      <div>
        <navbar/>
      </div>
        <div class="book-container">
          <div class="book-container-child">
              <h3>Train Details</h3>
              <input type="text" name="trainid" placeholder="Train Id" v-model="trainId" class="input-css" disabled>
              <label for="date" id="label-css-book" class="label-css">Date</label>
              <input type="date" v-model="doj" name="date" class="home-label-input-css" disabled>
          </div>
          <div class="book-container-child">
            <h3>Enter Passenger Details</h3>
                <table class="details-table">
                  <tr v-for="(c, k) in seatCount" :key="k">
                  <td class="big-part"><input type="text" name="name" placeholder="Name" v-model="passengers[k]" class="input-css-book"></td>
                  <td><input type="number" name="age" placeholder="Age" v-model="age[k]" class="input-css-book"></td>
                  </tr>
                </table>
              <button class="btn-size btn" @click="update">Add Passenger (MAX 5)</button>
              <h3>Confirm Booking</h3>
            <button class="cnfrm-btn-size btn" @click="onsubmit">Book Ticket</button>
          </div>
        </div>
    </div>
    <footerbar/>
  </div>
</template>

<script>
import axios from 'axios'
import { mapActions, mapGetters } from 'vuex'
import navbar from '../components/navbar.vue'
import footerbar from '../components/footer.vue'
export default {
  name: 'book',
  data () {
    return {
      trainId: localStorage.getItem('bookTicketId'),
      doj: localStorage.getItem('bookTicketDate'),
      seatCount: 0,
      passengers: [],
      age: [],
      response: []
    }
  },
  methods: {
    ...mapActions(['setBookingResult']),
    update () {
      if (this.seatCount < 5) {
        this.seatCount++
      }
      console.log(this.age)
      console.log(this.passengers)
    },
    onsubmit () {
      const arr = []
      this.seatCount = this.passengers.length
      var passengerList = this.passengers
      var ageList = this.age
      passengerList.forEach(function (value, index) {
        arr.push({ name: value, age: ageList[index] })
      })
      const obj = {
        trainId: this.trainId,
        dateOfJourney: this.doj,
        seatCount: this.seatCount,
        passengers: arr,
        userID: localStorage.getItem('sessionID')
      }
      if (localStorage.getItem('sessionID') !== null) {
        var url = 'http://10.177.68.4:8100/bookSearch/book'
        axios.post(url, obj).then((res) => {
          console.log(res)
          this.response = res.data
          localStorage.setItem('bookTicketPassengers', JSON.stringify(res.data.passengers))
          localStorage.setItem('bookTicketSeatCount', res.data.seatCount)
          localStorage.setItem('bookTicketSeatList', JSON.stringify(res.data.seatList))
          localStorage.setItem('bookTicketFare', res.data.fare)
          this.$store.dispatch('setBookingResultAction', res.data)
          this.$router.push('/confirm')
        })
      } else {
        localStorage.setItem('bookTicketPassengers', JSON.stringify(obj.passengers))
        localStorage.setItem('bookTicketSeatCount', obj.seatCount)
        alert('Not Logged In, Login First')
        this.$router.push({ path: '/login', query: { routeto: 'book' } })
      }
    }
  },
  components: {
    navbar: navbar,
    footerbar: footerbar
  },
  computed: {
    ...mapGetters(['getBookingResult'])
  }
}
</script>

<style>

 .book-container{
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    background-color: white;
    min-width: 400px;
  }

  .book-container-child{
    padding: 10px;
    min-width: 300px;
    width: 300px;
    margin-top: 100px;
    margin-bottom: 50px
  }

  .btn-size{
    width: 275px;
  }

  .cnfrm-btn-size{
    width: 140px;
  }

  #label-css-book{
    margin-left: 0px;
    font-size: 26px;
    margin-right: 15px;
  }

  .details-table{
    width: 100%;
    margin-bottom: 10px;
  }

  .big-part{
    width: 60%;
  }

  .input-css-book{
    display: block;
    padding: 10px;
    width: 60%;
    outline: none;
    border-radius: 5px;
    border: 0px;
    border-bottom: 1px solid #ea2330;
    -moz-box-shadow: 0 0 10px 1px gray;
    -webkit-box-shadow: 0 0 10px 1px gray;
    box-shadow: 0 0 10px 1px gray;
  }

  @media only screen and (max-width: 650px) {
    .book-container-child{
      padding: 10px;
      min-width: 300px;
      width: 300px;
      margin-top: 70px;
    }
  }

</style>
