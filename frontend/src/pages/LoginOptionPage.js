import Images from '@assets/images'
import { useNavigation } from '@react-navigation/native'
import React from 'react'
import { View, StyleSheet, ImageBackground, Text, Pressable } from 'react-native'
import { Logo } from '@/pages/FrontPage'
import { useSelector } from 'react-redux'
import Icons from '../../Icons'

const LoginOption = () => {
  const navigation = useNavigation()
  const language = useSelector((state) => state.languageOption)

  const loginOption = [
    {
      sloganFirst: 'Travel that makes',
      sloganSecond: 'memorable times',
      login: 'LOGIN',
      signup: 'SIGNUP',
    },
    {
      sloganFirst: '기억에 남는 여행,',
      sloganSecond: '추억이 되는 시간',
      login: '로그인',
      signup: '회원가입',
    },
  ]

  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        <Icons.Ionicons
          name="chevron-back"
          size={30}
          color="white"
          style={styles.backButton}
          onPress={() => navigation.goBack()}
        />

        <View style={styles.slogan}>
          <Text style={styles.sloganText}>
            {loginOption[language].sloganFirst}
            {'\n'}
            {loginOption[language].sloganSecond}
          </Text>
          {Logo()}
        </View>
        <View style={styles.buttons}>
          <Pressable style={styles.button} onPress={() => navigation.navigate('Login')}>
            <Text style={styles.buttonText}>{loginOption[language].login}</Text>
          </Pressable>
          <Pressable style={styles.button} onPress={() => navigation.navigate('Login')}>
            <Text style={styles.buttonText}>{loginOption[language].signup}</Text>
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
    zIndex: 0,
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
  backButton: {
    position: 'absolute',
    top: 57,
    left: 27,
    zIndex: 1,
  },
})

export default LoginOption
