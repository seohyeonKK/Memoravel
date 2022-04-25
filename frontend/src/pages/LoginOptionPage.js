import Images from '@assets/images'
import { useNavigation } from '@react-navigation/native'
import React from 'react'
import { View, StyleSheet, ImageBackground, Text, Pressable } from 'react-native'
import { Logo } from '@/pages/FrontPage'
import { useSelector } from 'react-redux'
import styles from '@/styles'
import Back from '@/components/Back'

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
        {Back()}
        <View style={LoginOptionStyles.slogan}>
          <Text style={LoginOptionStyles.sloganText}>
            {loginOption[language].sloganFirst}
            {'\n'}
            {loginOption[language].sloganSecond}
          </Text>
          {Logo()}
        </View>
        <View style={LoginOptionStyles.buttons}>
          <Pressable style={styles.whiteLongBox} onPress={() => navigation.navigate('Login')}>
            <Text style={styles.boxInnerText}>{loginOption[language].login}</Text>
          </Pressable>
          <Pressable style={styles.whiteLongBox} onPress={() => navigation.navigate('Login')}>
            <Text style={styles.boxInnerText}>{loginOption[language].signup}</Text>
          </Pressable>
        </View>
      </ImageBackground>
    </View>
  )
}

const LoginOptionStyles = StyleSheet.create({
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

  buttons: {
    flex: 1,
    alignItems: 'center',
  },
})

export default LoginOption
