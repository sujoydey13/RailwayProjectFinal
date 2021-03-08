<template>
  <div>
    <navbar/>
        <div class="middle-container">
          <div class="home-container">
            <center>
              <input type="text" name="from" v-model="from" placeholder="Departure Station" class="input-css" @keyup="validate">
              <img src="@/assets/exchange.png" class="exchange-img" @click="exchangeFromTo">
              <input type="text" name="to" v-model="to" placeholder="Arrival Station" class="input-css" @keyup="validate">
              <label for="date" id="label-css-search" class="label-css">Date</label>
              <input type="date" v-model="date" name="date" @click="limitDate" class="home-label-input-css" @keyup="validate">
              <button class="btn" id="searchbtn" @click="onsubmit">Search</button>
            </center>
          </div>
        </div>
        <div v-if="response[0] == 'kwerty'" class="search-result">
          <h1>Search to see available trains</h1>
          <img src="@/assets/giphy.gif" class="beautify-image" width=80%>
        </div>
        <div v-else-if="response.length == 0" class="search-result">
          <h1>No trains available for this route</h1>
          <img src="@/assets/giphy.gif" class="beautify-image" width=80%>
        </div>
        <div v-else class="search-result">
          <div v-for="searchElement in response" :key="searchElement.id" class="card-view">
            <h3>{{searchElement.name}} ({{searchElement.trainId}})</h3>
            <table class="table-css" cellspacing="10px">
              <tr>
                <td class="left">From: {{searchElement.startLocation}}</td>
                <td class="right">To: {{searchElement.endLocation}}</td>
              </tr>
              <tr>
                <td class="left">Departure Time: {{searchElement.departureTime}}</td>
                <td class="right">Arrival Time: {{searchElement.departureTime}}</td>
              </tr>
              <tr>
                <td class="left">Date: {{searchElement.date}}</td>
                <td class="right">Seats Available: {{searchElement.totalSeats}}</td>
              </tr>
              <tr>
                <td colspan="2" class="right"><button class="btn" @click="onclick(searchElement.trainId, searchElement.startLocation, searchElement.endLocation, searchElement.date)">Book Ticket</button></td>
              </tr>
            </table>
          </div>
        </div>
        <div class="bottom-margin">
        </div>
      <footerbar></footerbar>
  </div>
</template>

<script>
import { mapActions, mapGetters } from 'vuex'
import axios from 'axios'
import navbar from '../components/navbar.vue'
import footerbar from '../components/footer.vue'
export default {
  name: 'home',
  data () {
    return {
      from: '',
      to: '',
      date: '',
      response: ['kwerty']
    }
  },
  methods: {
    ...mapActions(['setSearchResult']),
    validate () {
      if (this.from === '' || this.to === '' || this.date === '') {
        document.getElementById('searchbtn').disabled = true
      } else {
        document.getElementById('searchbtn').disabled = false
      }
    },
    exchangeFromTo () {
      var from = this.to
      var to = this.from
      this.to = to
      this.from = from
    },
    onsubmit () {
      const obj = {
        fromLocation: this.from,
        toLocation: this.to,
        date: this.date
      }
      var url = 'http://10.177.68.4:8100/bookSearch/search'
      axios.post(url, obj).then((res) => {
        document.getElementById('searchbtn').disabled = false
        this.$router.push('/search?q1=' + this.from + '&q2=' + this.to + '&q3=' + this.date)
        this.response = res.data
      })
    },
    onclick (id, start, end, date) {
      if (this.$store.getters.login) {
        localStorage.setItem('bookTicketId', id)
        localStorage.setItem('bookTicketStartLocation', start)
        localStorage.setItem('bookTicketEndLocation', end)
        localStorage.setItem('bookTicketDate', date)
        this.$router.push('/book')
      } else {
        this.$router.push({ path: 'login', query: { redirect: 'book' } })
      }
    },
    limitDate () {
      var today = new Date().toISOString().split('T')[0]
      document.getElementsByName('date')[0].setAttribute('min', today)
    }
  },
  components: {
    navbar: navbar,
    footerbar: footerbar
  },
  computed: {
    ...mapGetters(['getSearchResult'])
  },
  created () {
    const query = this.$route.query
    console.log(query)
    this.from = query.q1
    this.to = query.q2
    this.date = query.q3
    this.onsubmit()
  }
}
</script>

<style>
 .home-input{
   display: inline;
 }

 .exchange-img{
   width: 30px;
   height: 30px;
   display: block;
   margin-top: -15px;
   padding: 10px;
   margin-bottom: 5px;
   cursor: pointer;
   transform: rotate(90deg);
 }

 .left{
   float: left
 }

 .right{
   float: right
 }

 .home-container{
   margin-top: 120px;
   margin-left: 50px;
   margin-bottom: 100px;
   width: 300px;
   border: 1px solid #f34f4f;
   padding: 10px;
   border-radius: 10px;
   padding-top: 30px;
   -moz-box-shadow: 0 0 10px 1px #f34f4f;
   -webkit-box-shadow: 0 0 10px 1px #f34f4f;
   box-shadow: 0 0 10px 1px #f34f4f;
   background-color: white;
 }

 .home-label-input-css{
      display: block;
      padding: 10px;
      width: 186px;
      min-width: 186px;
      margin-bottom: 30px;
      margin-top: 30px;
      outline: none;
      border-radius: 5px;
      border: 0px;
      -moz-box-shadow: 0 0 10px 1px gray;
      -webkit-box-shadow: 0 0 10px 1px gray;
      box-shadow: 0 0 10px 1px gray;
  }

  .search-result{
    padding-top: 120px;
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    min-width: 300px;
    margin-left: 420px;
  }

  .middle-container{
    width: 420px;
    border-right: 1px solid #f34f4f;
    height: 100vh;
    float: left;
    box-shadow: 0 0 10px 1px #f34f4f;
  }

  .btn:hover{
    background-color: #f34f4f;
    color: white
  }

  .card-view{
    height: 215px;
    min-width: 300px;
    width: 600px;
    border-radius: 5px;
    padding: 10px;
    border: 1px solid white;
    margin-bottom: 20px;
    -moz-box-shadow: 0 0 10px 1px #f34f4f;
    -webkit-box-shadow: 0 0 10px 1px #f34f4f;
    box-shadow: 0 0 10px 1px #f34f4f;
  }

  #label-css-search{
    font-size: 26px;
  }

  .table-css{
    width: 100%
  }

  body{
    background: url('https://i.pinimg.com/originals/0e/f9/54/0ef95476980fed727ab981eef642d89a.jpg');
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;
  }

  @media only screen and (max-width: 1100px) {
    .card-view {
      margin-left: 30px;
      margin-right: 30px;
    }
  }

  .beautify-image{
    border: 1px solid white;
    -moz-box-shadow: 0 0 10px 1px #f34f4f;
    -webkit-box-shadow: 0 0 10px 1px #f34f4f;
    box-shadow: 0 0 10px 1px #f34f4f;
    border-radius: 10px;
  }

  .bottom-margin{
    margin-bottom: 100px;
  }

  @media only screen and (max-width: 900px) {
    .middle-container{
      background-color: ivory;
      width: 100vw;
      border-right: 0px solid #f34f4f;
      height: 550px;
      position: initial;
      display: flex;
      justify-content: center;
    }

    .home-container{
      margin-left: 0px;
    }

    .search-result{
      width: 100vw;
      height: 100vh;
      padding-top: 50px;
      margin-left: 0px;
    }

    .card-view{
      float: left;
    }

    .train-animate{
      animation-duration: 5s;
      animation-name: slidein;
    }
    @keyframes slidein {
      to {
        margin-left: 30%;
        width: 100%;
      }
      from {
        margin-left: 0%;
        width: 100%;
      }
    }
  }
</style>
