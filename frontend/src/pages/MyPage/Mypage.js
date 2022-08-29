import { StyleSheet, View } from 'react-native'
import React from 'react'
import Header from './Sections/Header'
import Profile from './Sections/Profile'
import Course from './Sections/Course'
import Review from './Sections/Review'

export default function Mypage() {
  return (
    <View style={instyle.MainView}>
      <View style={{ paddingLeft: 20 }}>
        <Header />
      </View>
      <Profile />
      <Course />
      <Review />
    </View>
  )
}

const instyle = StyleSheet.create({
  MainView: {
    flex: 1,
    backgroundColor: 'white',
    paddingTop: 60,
    height: '100%',
  },
})
