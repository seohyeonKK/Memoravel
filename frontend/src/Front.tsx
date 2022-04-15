import Images from '@assets/images'
import React from 'react'
import { View, StyleSheet, ImageBackground, Text } from 'react-native'

const Front = () => {
  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        <View style={styles.slogan}>
          <Text style={styles.sloganText}> Gmarket 기억에 남는 여행,{'\n'}추억이 되는 시간</Text>
        </View>
        <View style={styles.buttons}></View>
      </ImageBackground>
    </View>
  )
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  backgroundImg: {
    flex: 1,
    justifyContent: 'center',
  },
  slogan: {
    flex: 1,
    backgroundColor: 'yellow',
  },
  sloganText: {
    flex: 1,
    color: 'white',
    backgroundColor: 'red',
    fontFamily: 'GmarketSansTTFMedium',
    fontSize: 100,
  },
  buttons: {
    flex: 1,
  },
})

export default Front
