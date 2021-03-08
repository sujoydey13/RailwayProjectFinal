<template>
  <div>
      <div class="g-signin2" data-onsuccess="onSignIn"></div>
  </div>
</template>

<script src="https://apis.google.com/js/platform.js" async defer></script>
<script>
import axios from 'axios'
export default {
  name: 'auth',
  methods: {
    onSignIn (googleUser) {
      const idToken = googleUser.getAuthResponse().id_token
      console.log('ID: ' + profile.getId());
      console.log('Name: ' + profile.getName());
      console.log('Image URL: ' + profile.getImageUrl());
      console.log('Email: ' + profile.getEmail());
      const obj = {
        tokenId: idToken
      }
      axios.post('http://10.177.68.60:8080/auth', obj).then((res) => {
        console.log(res)
        this.$router.push('/search')
      })
    }
  },
  created () {
    this.$router.push('/search')
  }
}
</script>

<style>

</style>
