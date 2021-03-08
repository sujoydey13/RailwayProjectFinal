<template>
    <footer class="footerbar">
        <!--<marquee direction="right"><img src="@/assets/train.png" class="animate-me"> </marquee>-->
        <marquee direction="left"><h4>IMPORTANT ANNOUNCEMENT: </h4></marquee>
    </footer>
</template>

<script>
export default {
  name: 'footer'
}
</script>

<style>
  .footerbar{
      z-index: 1;
      height: 60px;
      bottom: 0px;
      position: fixed;
      width: 100%;
      background: #f34f4f;
  }
</style>
