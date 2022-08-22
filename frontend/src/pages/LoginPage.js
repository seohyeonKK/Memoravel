import React, { useEffect, useState } from 'react'
import { Alert, ImageBackground, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import Images from '@assets/images'
import styles from '@/styles'
import { useSelector } from 'react-redux'
import Back from '@/components/Back'
import InputEmail from '@/components/InputEmail'
import InputPassword from '@/components/InputPassword'
import { login } from '@/constants/language'
import asyncStorage from '@react-native-async-storage/async-storage/src/AsyncStorage'
import { postSignin, reAuthentication } from '@/api/api'
import { removeJWT, setJWT } from '@/util'
import { useNavigation } from '@react-navigation/native'

const Login = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const language = useSelector((state) => state.languageOption)
  const navigation = useNavigation()

  useEffect(() => {
    removeJWT()

    asyncStorage.getItem('JWT').then((value) => {
      newToken(value)
    })
  }, [])

  const newToken = (token) => {
    reAuthentication(token)
      .then((result) => {
        if (result.status === 200) removeJWT().then(setJWT(result.data).then(() => navigation.navigate('Mypage')))
      })
      .catch(() => {
        removeJWT()
      })
  }

  const signin = async () => {
    postSignin(email, password)
      .then((result) => {
        if (result.status === 200) setJWT(result.data).then(() => navigation.navigate('Mypage'))
        else Alert.alert('X')
      })
      .catch(() => {
        Alert.alert('X')
      })
  }

  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        {Back()}
        <View style={LoginStyles.loginText}>
          <Text style={[styles.loginTitle, , { marginTop: '60%' }]}>{login[language].login}</Text>
          <Text style={styles.welcome}>{login[language].welcome}</Text>
        </View>
        <View style={LoginStyles.input}>
          {InputEmail(email, setEmail, login[language].email, true)}
          {InputPassword(password, setPassword, login[language].password, false, false)}
          <View style={LoginStyles.find}>
            <TouchableOpacity>
              <Text style={LoginStyles.findText}>{login[language].findId}</Text>
            </TouchableOpacity>
            <TouchableOpacity>
              <Text style={LoginStyles.findText}>{login[language].findPassword}</Text>
            </TouchableOpacity>
          </View>
        </View>
        <View style={LoginStyles.loginBtn}>
          <TouchableOpacity
            style={email && password ? styles.button : styles.disabledButton}
            onPress={signin}
            disabled={!email || !password}>
            <Text style={styles.buttonText}>{login[language].login}</Text>
          </TouchableOpacity>
        </View>
      </ImageBackground>
    </View>
  )
}

const LoginStyles = StyleSheet.create({
  loginText: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },

  input: {
    flex: 0.6,
    alignItems: 'center',
    paddingTop: 5,
  },
  find: {
    flex: 0.5,
    flexDirection: 'row',
    marginTop: 8,
    justifyContent: 'center',
    alignItems: 'center',
  },
  findText: {
    fontFamily: 'GmarketSansTTFMedium',
    fontWeight: '500',
    fontSize: 12,
    lineHeight: 14,
    color: 'white',
    textDecorationLine: 'underline',
    margin: 5,
  },

  loginBtn: {
    flex: 1,
    alignItems: 'center',
  },
})

export default Login
