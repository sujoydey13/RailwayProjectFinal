<template>
  <div>
    <center>
      <div id="errors-login">
        <div>
          <img src="@/assets/cross-img.png" class="cross" @click="removeerrors">
          <center>
            <p class="error-content" id="show-errors-login"></p>
          </center>
        </div>
      </div>
      <div class="container">
          <div class="inner-container">
              <div class="heading">
                <h3>Login</h3>
              </div>
              <div class="content">
                <input type="text" v-model="userName" placeholder="Username" name="username" class="input-css">
                <input type="password" v-model="password" placeholder="Password" name="password" class="input-css">
                <button class="btn" @click="onsubmit">Login</button>
              </div>
              <div class="footer">
                <router-link to="/register" class="login-register-router register-router">New User? Register</router-link>
                <router-link to="/search" class="login-register-router">Home</router-link>
              </div>
          </div>
      </div>
    </center>
  </div>
</template>

<script>
import { mapActions } from 'vuex'
import axios from 'axios'
export default {
  name: 'login',
  data () {
    return {
      message: '',
      userName: '',
      password: ''
    }
  },
  methods: {
    ...mapActions(['setLoginAction']),
    removeerrors () {
      document.getElementById('errors-login').style.display = 'none'
    },
    validate () {
      var message = ''
      if (this.userName === '') {
        message += '- Invalid username <br>'
      }
      if (this.password === '') {
        message += '- Invalid password <br>'
      }
      this.message = message
      if (this.message !== '') {
        document.getElementById('errors-login').style.display = 'block'
        document.getElementById('show-errors-login').innerHTML = message
        return false
      } else {
        document.getElementById('errors-login').style.display = 'none'
        return true
      }
    },
    onsubmit () {
      const obj = {
        userName: this.userName,
        password: this.password
      }
      if (this.validate()) {
        axios.post('http://10.177.68.4:8100/loginLogout/login', obj).then((res) => {
          localStorage.setItem('sessionID', res.data.sessionID)
          this.$store.dispatch('setLoginAction', res.data.sessionID)
          if (res.data.sessionID === '') {
            alert('Invalid Login Credentials')
            localStorage.removeItem('sessionID')
            this.$router.push('/login')
          }
          if (this.$route.query.routeto === 'book') {
            this.$router.push('/book')
          } else {
            this.$router.push('/search')
          }
        })
      }
    }
  },
  created () {
    if (localStorage.getItem('sessionID') !== null) {
      this.$router.push('/search')
    }
  },
  components: {
  }
}
</script>

<style>
  .container{
      margin: 20px;
  }

  .inner-container{
      margin-top: 40px;
      width: 300px;
      border: 1px solid white;
      padding: 30px;
      border-radius: 10px;
      padding-top: 0px;
      -moz-box-shadow: 0 0 10px 1px #f34f4f;
      -webkit-box-shadow: 0 0 10px 1px #f34f4f;
      box-shadow: 0 0 10px 1px #f34f4f;
  }

  .input-css{
      display: block;
      padding: 10px;
      width: 250px;
      min-width: 250px;
      margin-bottom: 20px;
      outline: none;
      border-radius: 5px;
      border: 0px;
      border-bottom: 1px solid white;
      -moz-box-shadow: 0 0 10px 1px gray;
      -webkit-box-shadow: 0 0 10px 1px gray;
      box-shadow: 0 0 10px 1px gray;
  }
  .input-css:active{
      outline: none;
  }

  .btn{
      background-color: white;
      width: 100px;
      color: #f34f4f;
      padding: 10px;
      display: block;
      border: 1px solid white;
      cursor: pointer;
      margin-bottom: 20px;
      -moz-box-shadow: 0 0 10px 1px #f34f4f;
      -webkit-box-shadow: 0 0 10px 1px #f34f4f;
      box-shadow: 0 0 10px 1px #f34f4f;
      border-radius: 5px;
  }

  .btn:focus{
      outline: none;
  }

  .login-register-router{
      text-decoration: none;
      color: black;
      display: block;
      margin-top: 10px;
  }

  .register-router{
      margin-top: 10px;
  }

  .heading{
    border-bottom: 1px solid black
  }

  .content{
    margin-top: 20px;
  }

  .footer{
    border-top: 1px solid black
  }

  #errors-login{
    display: none;
    z-index: 3;
    margin-top: -20px;
    width: 100vw;
    height: 100vh;
    background: rgb(99, 99, 99, 0.5);
    position: fixed;
    border: 1px solid white;
  }

  #errors-login > div {
    padding: 20px;
    background: white;
  }
</style>
