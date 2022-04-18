import Images from '@assets/images'
import { useNavigation } from '@react-navigation/native'
import React from 'react'
import { View, StyleSheet, ImageBackground, Text, Image, Pressable } from 'react-native'

export const Logo = () => {
  return (
    <View style={styles.logo}>
      <Image source={Images.Logo} style={styles.logoImg} />
      <Text style={styles.logoText}>memoravel</Text>
    </View>
  )
}
const Front = () => {
  const navigation = useNavigation()
  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        <View style={styles.slogan}>
          <Text style={styles.sloganText}>기억에 남는 여행,{'\n'}추억이 되는 시간</Text>
          {Logo()}
        </View>
        <View style={styles.buttons}>
          <Pressable style={styles.button} onPress={() => navigation.navigate('Login')}>
            <Text style={styles.buttonText}>LOGIN</Text>
          </Pressable>
          <Pressable style={styles.button} onPress={() => navigation.navigate('Login')}>
            <Text style={styles.buttonText}>SIGNUP</Text>
          </Pressable>
        </View>
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
    justifyContent: 'center',
    alignItems: 'center',
  },
  sloganText: {
    color: 'white',
    fontFamily: 'GmarketSansTTFMedium',
    fontSize: 15,
    marginTop: '50%',
    marginBottom: 22,
    textAlign: 'center',
  },
  logo: {
    justifyContent: 'center',
    alignItems: 'center',
  },
  logoImg: {
    width: 90,
    height: 85,
  },
  logoText: {
    fontFamily: 'GmarketSansTTFMedium',
    fontWeight: '500',
    fontSize: 18,
    textAlign: 'center',
    lineHeight: 21,
    marginTop: 5,
    color: 'white',
  },
  buttons: {
    flex: 1,
    alignItems: 'center',
  },
  button: {
    width: 255,
    height: 50,
    backgroundColor: 'white',
    borderRadius: 150,
    justifyContent: 'center',
    marginBottom: 17,
    shadowOffset: { width: 1, height: 3 },
    shadowColor: 'black',
    shadowOpacity: 0.2,
  },
  buttonText: {
    textAlign: 'center',
    fontFamily: 'GmarketSansTTFMedium',
    fontWeight: '500',
    fontSize: 13,
    lineHeight: 15,
  },
})

export default Front
