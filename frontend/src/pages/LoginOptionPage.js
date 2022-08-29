import Images from '@assets/images'
import { useNavigation } from '@react-navigation/native'
import React from 'react'
import { ImageBackground, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { Logo } from '@/pages/FrontPage'
import { useSelector } from 'react-redux'
import styles from '@/styles'
import Back from '@/components/Back'
import { loginOption } from '@/constants/language'
import { removeJWT, setJWT } from '@/util'
import asyncStorage from '@react-native-async-storage/async-storage/src/AsyncStorage'
import { reAuthentication } from '@/api/api'

const LoginOption = () => {
  const navigation = useNavigation()
  const language = useSelector((state) => state.languageOption)

  const newToken = (token) => {
    reAuthentication(token)
      .then((result) => {
        if (result.status === 200) removeJWT().then(setJWT(result.data).then(() => navigation.navigate('Body')))
      })
      .catch(() => {
        removeJWT()
        navigation.navigate('Login')
      })
  }

  const login = () => {
    asyncStorage
      .getItem('JWT')
      .then((value) => {
        newToken(value)
      })
      .catch(() => navigation.navigate('Login'))
  }

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
          <TouchableOpacity style={styles.longBox} onPress={login}>
            <Text style={styles.boxInnerText}>{loginOption[language].login}</Text>
          </TouchableOpacity>
          <TouchableOpacity style={styles.longBox} onPress={() => navigation.navigate('Signup')}>
            <Text style={styles.boxInnerText}>{loginOption[language].signup}</Text>
          </TouchableOpacity>
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
