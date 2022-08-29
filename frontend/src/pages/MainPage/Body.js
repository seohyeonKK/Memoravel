import { View, StyleSheet } from 'react-native'
import React, { useState } from 'react'
import Mypage from '../MyPage/Mypage'
import Footer from './Footer.js'
import Home from '../Home/Home'
export default function Body() {
  const [Pages, setPages] = useState(0)
  return (
    <>
      {Pages === 0 && (
        <View style={{ height: '100%' }}>
          <Home />
        </View>
      )}
      {Pages === 4 && (
        <View style={{ height: '100%' }}>
          <Mypage />
        </View>
      )}
      <View style={styles.FooterStyle}>
        <Footer Pages={Pages} setPages={setPages} />
      </View>
    </>
  )
}
const styles = StyleSheet.create({
  FooterStyle: {
    height: 80,
    width: '100%',
    backgroundColor: 'white',
    justifyContent: 'center',
    borderTopWidth: 1,
    borderTopColor: 'rgb(212, 212, 212)',
    position: 'absolute',
    bottom: 0,
  },
})
