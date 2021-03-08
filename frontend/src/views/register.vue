<template>
  <div>
      <center>
        <div id="errors">
          <div>
            <img src="@/assets/cross-img.png" class="cross" @click="removeerrors">
            <center>
              <p class="error-content" id="show-errors"></p>
            </center>
          </div>
        </div>
        <div class="container">
            <div class="inner-container">
              <div class="heading">
                <h3>Register</h3>
              </div>
              <div class="content">
                <input type="text" v-model="firstName" placeholder="First Name" name="firstname" class="input-css">
                <input type="text" v-model="middleName" placeholder="Middle Name" name="middlename" class="input-css">
                <input type="text" v-model="lastName" placeholder="Last Name" name="lastname" class="input-css">
                <label for="date" class="label-css">D.O.B.</label>
                <input type="date" v-model="dob" name="date" class="label-input-css">
                <input type="email" v-model="email" placeholder="Email" name="email" class="input-css">
                <input type="tel" v-model="phoneNumber" placeholder="Phone Number" name="phonenumber" class="input-css">
                <input type="text" v-model="userName" placeholder="Username" name="username" class="input-css">
                <input type="password" v-model="password" placeholder="Password" name="password" class="input-css">
                <input type="password" v-model="confirmPassword" @keyup="mismatch" placeholder="Confirm Password" name="confirmpassword" class="input-css">
                <p id="mismatch-error">Passwords don't match</p>
                <input type="submit" @click="onsubmit" class="btn" value="Register">
              </div>
              <div class="footer">
                <router-link to="/login" class="login-register-router register-router">Existing User? Login</router-link>
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
  name: 'register',
  data () {
    return {
      message: '',
      firstName: '',
      middleName: '',
      lastName: '',
      dob: '',
      age: '',
      email: '',
      phoneNumber: '',
      userName: '',
      password: '',
      confirmPassword: ''
    }
  },
  methods: {
    removeerrors () {
      document.getElementById('errors').style.display = 'none'
    },
    findage () {
      const dobirth = new Date(this.dob)
      const monthdiff = Date.now() - dobirth
      const agedt = new Date(monthdiff)
      const year = agedt.getUTCFullYear()
      const age = Math.abs(year - 1970)
      return age
    },
    mismatch () {
      if (this.confirmPassword !== this.password && this.confirmPassword !== '') {
        document.getElementById('mismatch-error').style.display = 'block'
      } else {
        document.getElementById('mismatch-error').style.display = 'none'
      }
    },
    validate () {
      var message = ''
      if (this.firstName === '') {
        message = message + '- First Name cann\'t be Empty <br>'
      }
      if (this.dob === '') {
        message = message + '- Date of Birth cann\'t be Empty <br>'
      }
      if (this.email === '') {
        message = message + '- Email cann\'t be Empty <br>'
      }
      if (isNaN(this.phoneNumber) || this.phoneNumber === '' || this.phoneNumber.length !== 10) {
        message += '- Invalid Phone number, must be 10 digits <br>'
      }
      if (this.userName === '') {
        message += '- Invalid username <br>'
      }
      if (this.password === '' || (this.password.length < 8 || this.password.length > 16)) {
        message += '- Invalid password, must be between than 8 to 16 characters <br>'
      }
      if (this.password !== this.confirmPassword) {
        message += '- Passwords don\'t match'
      }
      this.message = message
      if (this.message !== '') {
        document.getElementById('errors').style.display = 'block'
        document.getElementById('show-errors').innerHTML = message
        return false
      } else {
        document.getElementById('errors').style.display = 'none'
        return true
      }
    },
    onsubmit () {
      this.age = this.findage()
      const obj = {
        fname: this.firstName,
        mname: this.middleName,
        lname: this.lastName,
        age: this.age,
        email: this.email,
        phoneNumber: this.phoneNumber,
        userName: this.userName,
        password: this.password
      }
      if (this.validate()) {
        axios.post('http://10.177.68.4:8100/registration/register', obj).then((res) => {
          console.log(res)
          this.$router.push('/login')
        })
      }
    }
  },
  created () {
    if (localStorage.getItem('sessionID') !== null) {
      this.$router.push('/search')
    }
  }
}
</script>

<style>
  #mismatch-error{
      display: none;
      color: #f34f4f;
      margin-bottom: 20px;
  }

  .label-css{
      float: left;
      margin-left: 15px;
      font-size: 14px;
      margin-top: 15px;
  }

  .label-input-css{
      display: block;
      padding: 10px;
      width: 195px;
      min-width: 195px;
      margin-bottom: 20px;
      outline: none;
      border-radius: 5px;
      border: 0px;
      -moz-box-shadow: 0 0 10px 1px gray;
      -webkit-box-shadow: 0 0 10px 1px gray;
      box-shadow: 0 0 10px 1px gray;
  }

  #errors{
    display: none;
    z-index: 3;
    margin-top: -20px;
    width: 100vw;
    height: 100vh;
    background: rgb(99, 99, 99, 0.5);
    position: fixed;
    border: 1px solid white;
  }

  #errors > div {
    padding: 20px;
    background: white;
  }

  .cross{
    float: right;
    margin-top: 10px;
    margin-right: 10px;
    width: 15px;
    height: 15px;
    cursor: pointer;
  }

  .error-content{
    margin: 20px;
    margin-top: 50px;
    text-align: left;
    color: #f34f4f;
  }
</style>
