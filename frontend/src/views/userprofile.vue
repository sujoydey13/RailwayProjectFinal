<template>
    <div>
    <center>
    <div class='container-user'>
        <h3>User Details</h3>
        <img class='beautify-user-img' src='https://cdn2.vectorstock.com/i/1000x1000/20/76/man-avatar-profile-vector-21372076.jpg'>
        <table class='table-css' cellpadding="10px">
            <tr>
                <td>Name: </td>
                <td>{{response.fname}} {{response.mname}} {{response.lname}}</td>
            </tr>
            <tr>
                <td>Username: </td>
                <td>{{response.userName}}</td>
            </tr>
            <tr>
                <td>Age: </td>
                <td>{{response.age}}</td>
            </tr>
            <tr>
                <td>Email: </td>
                <td>{{response.email}}</td>
            </tr>
            <tr>
                <td>Phone Number: </td>
                <td>{{response.phoneNumber}}</td>
            </tr>
        </table>
    </div>
    </center>
    </div>
</template>

<script>
import axios from 'axios'
export default {
  name: 'userprofile',
  data () {
    return {
      response: ''
    }
  },
  mounted () {
    const obj = {
      sessionId: localStorage.getItem('sessionID')
    }
    axios.post('http://10.177.68.4:8100/loginLogout/userDetails', obj).then((res) => {
      this.response = res.data
    })
  },
  created () {
    if (localStorage.getItem('sessionID') === null) {
      this.$router.push('/login')
    }
    if (localStorage.getItem('isAdmin') === 'true') {
      this.$router.push('login')
    }
  }
}
</script>

<style scoped>
  .table-css{
    width: 400px;
    margin-top: 10px;
    margin-bottom: 30px;
    text-align: center;
  }

  td{
    -moz-box-shadow: 0 0 10px 1px gray;
    -webkit-box-shadow: 0 0 10px 1px gray;
    box-shadow: 0 0 10px 1px gray;
  }

  .beautify-user-img{
    border-radius: 50%;
    height: 150px;
    width: 150px;
    box-shadow: 0 0 10px 1px gray;
  }

  .container-user{
    width: 500px;
    margin-top: 100px;
    border: 1px solid white;
    -moz-box-shadow: 0 0 10px 1px gray;
    -webkit-box-shadow: 0 0 10px 1px gray;
    box-shadow: 0 0 10px 1px gray;
  }
</style>
