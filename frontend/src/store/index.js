import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    isLogin: true,
    searchResult: [],
    bookingResult: {},
    bookingHistory: []
  },
  getters: {
    login (state) {
      return state.isLogin
    },
    getSearchResult (state) {
      return state.searchResult
    },
    getBookingResult (state) {
      return state.bookingResult
    },
    getBookingHistory (state) {
      return state.bookingHistory
    }
  },
  mutations: {
    setLogin (state, value) {
      state.isLogin = value
    },
    setSearchResult (state, value) {
      state.searchResult = value
    },
    setBookingResult (state, value) {
      state.bookingResult = value
    },
    setBookingHistory (state, value) {
      state.bookingHistory = value
    }
  },
  actions: {
    setLoginAction ({ commit }, value) {
      commit('setLogin', value)
    },
    setSearchResultAction ({ commit }, value) {
      commit('setSearchResult', value)
    },
    setBookingResultAction ({ commit }, value) {
      commit('setBookingResult', value)
    },
    setBookingHistoryAction ({ commit }, value) {
      commit('setBookingHistory', value)
    }
  }
})
