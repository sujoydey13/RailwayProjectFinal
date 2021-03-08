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
                <h3>Admin Login</h3>
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
  name: 'admin',
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
      console.log('In submit')
      const obj = {
        userName: this.userName,
        password: this.password
      }
      if (this.validate()) {
        axios.post('http://10.177.68.4:8100/adminPage/admin', obj).then((res) => {
          this.$store.dispatch('setLoginAction', res.data)
          localStorage.setItem('sessionID', res.data.sessionID)
          localStorage.setItem('isAdmin', res.data.isAdmin)
          console.log(res.data)
          this.$router.push('/train')
        })
      }
    }
  },
  components: {
  }
}
</script>

<style>
</style>
