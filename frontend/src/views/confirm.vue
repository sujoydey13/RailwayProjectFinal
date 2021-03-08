<template>
  <div>
    <navbar/>
    <div>
      <center>
        <div class="book-container">
          <div class="book-home-container">
            <center>
              <img src="@/assets/001-ticket.png" class="ticket-confirm">
            </center>
            <div id="myTicket">
            <center>
              <h3>Booking Confirmed</h3>
              <h3>Train Ticket</h3>
            </center>
            <table class="table-css" cellspacing="10px">
                <tr>
                    <td class="left">Train No.</td>
                    <td class="right">{{ trainDate }}</td>
                </tr>
                <tr>
                    <td class="left">{{ trainId }}</td>
                    <td class="right">₹ {{ trainFare }}</td>
                </tr>
                <tr>
                    <center>
                        <td colspan="2">{{ trainStart }} <img src="@/assets/train-tracks.png" class="ticket-confirm-track"> {{ trainEnd }}</td>
                    </center>
                </tr>
                <tr>
                    <center>
                        <td colspan="2">Passenger Details</td>
                    </center>
                </tr>
                <tr>
                    <td class="left">NAME</td>
                    <td class="right">SEAT NO.</td>
                </tr>
                <tr v-for="pass in trainSeatCount" :key="pass.id">
                    <td class="left">{{ trainPassengers[pass-1].name }}</td>
                    <td class="right">{{ trainSeatList[pass-1] }}</td>
                </tr>
            </table>
            </div>
          </div>
        </div>
      </center>
    </div>
    <div id="elementH">
    </div>
    <center>
      <button @click="convertHTMLTOPDF" class="up-margin btn">Download Ticket (PDF)</button>
    </center>
    <footerbar/>
  </div>
</template>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jspdf/1.0.272/jspdf.debug.js"></script>
<script>
import navbar from '../components/navbar.vue';
import footerbar from '../components/footer.vue';
export default {
  components: { navbar: navbar, footerbar: footerbar },
  name: 'confirm',
  data () {
    return {
      trainId: localStorage.getItem('bookTicketId'),
      trainDate: localStorage.getItem('bookTicketDate'),
      trainStart: localStorage.getItem('bookTicketStartLocation'),
      trainEnd: localStorage.getItem('bookTicketEndLocation'),
      trainSeatCount: parseInt(localStorage.getItem('bookTicketSeatCount')),
      trainPassengers: JSON.parse(localStorage.getItem('bookTicketPassengers')),
      trainSeatList: JSON.parse(localStorage.getItem('bookTicketSeatList')),
      trainFare: localStorage.getItem('bookTicketFare')
    }
  },
  methods: {
    convertHTMLTOPDF () {
      var doc = new jsPDF()
      var elementHTML = $('#myTicket').html()
      var specialElementHandlers = {
        '#elementH': function (element, renderer) {
          return true
        }
      }
      doc.fromHTML(elementHTML, 30, 30, {
        'width': 100,
        'elementHandlers': specialElementHandlers
      }, function(){doc.save('Ticket.pdf')})
    }
  },
  created () {
    if (localStorage.getItem('sessionID') === null) {
      this.$router.push('/login')
    }
  }
}
</script>

<style>
  .ticket-confirm{
      margin-top: -80px;
      width: 200px;
      height: 200px;
  }

  .ticket-confirm-track{
      width: 20px;
      height: 10px;
  }

  .book-home-container{
    margin-top: 120px;
    margin-left: 0px;
    margin-bottom: 100px;
    width: 300px;
    border: 1px solid white;
    padding: 10px;
    border-radius: 10px;
    padding-top: 30px;
    -moz-box-shadow: 0 0 10px 1px #f34f4f;
    -webkit-box-shadow: 0 0 10px 1px #f34f4f;
    box-shadow: 0 0 10px 1px #f34f4f;
    background-color: white;
  }

  .up-margin{
    margin-top: -80px;
    margin-bottom: 100px
  }
</style>
