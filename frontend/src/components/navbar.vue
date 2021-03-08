<template>
  <div>
      <nav class="navbar">
          <span class="train-animate">
            <router-link to='/search'><img src="@/assets/train.png" class="animate-me"></router-link>
          </span>
          <span v-if="sessionId !== null">
            <button v-if="isAdmin !== 'true'" class="router"  v-on:click="logout">Logout</button>
            <button v-else class="router"  v-on:click="logoutAdmin">Logout Admin</button>
            <button class="router"  v-on:click="userProfile">User Profile</button>
            <button v-if="buttonValue === 'history' || buttonValue === null" class="router" id ="getHistoryBtn" @click="getBookingHistory">Booking History</button>
            <button v-else-if="buttonValue === 'back'" class="router" id ="goBackBtn" @click="goback">Go Back</button>
            </span>
          <span v-else>
            <router-link to='/login' class="router">Login</router-link>
            <router-link to='/register' class="router" >Register</router-link>
          </span>
      </nav>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import axios from 'axios'
export default {
  name: 'navbar',
  data () {
    return {
      sessionId: localStorage.getItem('sessionID'),
      buttonValue: localStorage.getItem('display'),
      isAdmin: localStorage.getItem('isAdmin')
    }
  },
  methods: {
    goback () {
      this.$router.go(-1)
    },
    ...mapActions(['setLoginAction']),
    logout () {
      const obj = {
        sessionId: this.sessionId
      }
      console.log(this.sessionId)
      axios.post('http://10.177.68.4:8100/loginLogout/logout', obj).then((res) => {
        localStorage.removeItem('sessionID')
        localStorage.removeItem('isAdmin')
        localStorage.setItem('bookTicketSeatCount', '')
        localStorage.setItem('bookTicketDate', '')
        localStorage.setItem('bookTicketId', '')
        localStorage.setItem('bookTicketSeatList', '')
        console.log(res)
        this.response = res.data
        window.location.href = 'http://localhost:8080/search'
      })
    },
    logoutAdmin () {
      const obj = {
        sessionId: this.sessionId
      }
      console.log(this.sessionId)
      axios.post('http://10.177.68.4:8100/adminPage/logout', obj).then((res) => {
        localStorage.removeItem('sessionID')
        localStorage.removeItem('isAdmin')
        window.location.href = 'http://localhost:8080/search'
      })
    },
    getBookingHistory () {
      this.$router.push('/historypane')
    },
    userProfile () {
      this.$router.push('/userprofile')
    }
  },
  created () {
    if (window.location.href === 'http://localhost:8080/historypane') {
      localStorage.setItem('display', 'back')
      this.buttonValue = localStorage.getItem('display')
    } else {
      localStorage.setItem('display', 'history')
      this.buttonValue = localStorage.getItem('display')
    }
  }
}
</script>

<style>
  .navbar{
      z-index: 1;
      top: 0px;
      height: 60px;
      position: fixed;
      width: 100%;
      background: #f34f4f;
  }

  .router{
      margin: 10px;
      padding: 10px;
      text-decoration: none;
      float: right;
      color: black;
      background-color: white;
  }

  .animate-me{
    margin-top: 25px;
    margin-left: 10px;
    width: 45px;
    height: 40px;
  }

  .train-animate{
    animation-duration: 5s;
    animation-name: slidein;
  }
  @keyframes slidein {
    to {
      margin-left: 60%;
      width: 100%;
    }
    from {
      margin-left: 0%;
      width: 100%;
    }
  }

  body{
      margin: 0px;
  }
  #getHisotryBtn{
    position: relative;
  }

  #goBackBtn{
    position: relative;
  }
</style>
