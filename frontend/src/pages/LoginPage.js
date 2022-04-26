import React, { useState } from 'react'
import { Text, View, ImageBackground, StyleSheet, Pressable } from 'react-native'
import Images from '@assets/images'
import styles from '@/styles'
import { useSelector } from 'react-redux'
import Back from '@/components/Back'
import InputEmail from '@/components/InputEmail'
import InputPassword from '@/components/InputPassword'

const Login = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const language = useSelector((state) => state.languageOption)

  const login = [
    {
      login: 'LOGIN',
      welcome: 'Welcome Back !',
      email: 'E-mail',
      password: 'Password',
      findId: 'Find ID',
      findPassword: 'Find Password',
    },
    {
      login: '로그인',
      welcome: '돌아오신 것을 환영해요 !',
      email: '이메일',
      password: '비밀번호',
      findId: '아이디 찾기',
      findPassword: '비밀번호 찾기',
    },
  ]

  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        {Back()}
        <View style={LoginStyles.loginText}>
          <Text style={[styles.loginTitle, , { marginTop: '60%' }]}>{login[language].login}</Text>
          <Text style={styles.welcome}>{login[language].welcome}</Text>
        </View>
        <View style={LoginStyles.input}>
          {InputEmail(email, setEmail, login[language].email)}
          {InputPassword(password, setPassword, login[language].password, true)}
          <View style={LoginStyles.find}>
            <Pressable>
              <Text style={LoginStyles.findText}>{login[language].findId}</Text>
            </Pressable>
            <Pressable>
              <Text style={LoginStyles.findText}>{login[language].findPassword}</Text>
            </Pressable>
          </View>
        </View>
        <View style={LoginStyles.loginBtn}>
          <Pressable style={email && password ? styles.button : styles.disabledButton}>
            <Text style={styles.buttonText}>{login[language].login}</Text>
          </Pressable>
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
