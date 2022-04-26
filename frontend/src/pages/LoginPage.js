import React, { useState } from 'react'
import { Text, View, ImageBackground, StyleSheet, TextInput, Pressable } from 'react-native'
import Images from '@assets/images'
import Icons from '../../Icons'
import styles from '@/styles'
import { useSelector } from 'react-redux'
import Back from '@/components/Back'

const Login = () => {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [showPassword, setShowPassword] = useState(true)
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
          <Text style={LoginStyles.login}>{login[language].login}</Text>
          <Text style={LoginStyles.welcome}>{login[language].welcome}</Text>
        </View>
        <View style={LoginStyles.input}>
          <View style={styles.whiteLongBox}>
            <Icons.MaterialCommunityIcons
              name="email"
              size={16}
              style={LoginStyles.loginIcon}
              color="rgba(0,0,0,0.5)"
            />
            <TextInput
              style={{ flex: 1, paddingLeft: 12, paddingRight: 30 }}
              onChangeText={(text) => setEmail(text)}
              value={email}
              placeholder={login[language].email}
              keyboardType="default"
              placeholderTextColor="rgba(0, 0, 0, 0.6)"
            />
          </View>
          <View style={styles.whiteLongBox}>
            <Icons.MaterialCommunityIcons
              name="lock"
              size={18}
              style={LoginStyles.passwordIcon}
              color="rgba(0,0,0,0.5)"
            />
            <TextInput
              style={{ flex: 1, paddingLeft: 12, paddingRight: 10 }}
              onChangeText={(text) => setPassword(text)}
              value={password}
              placeholder={login[language].password}
              keyboardType="default"
              secureTextEntry={showPassword}
              textContentType={'password'}
              placeholderTextColor="rgba(0, 0, 0, 0.6)"
            />
            <Pressable onPress={() => setShowPassword((prev) => !prev)}>
              <Icons.MaterialCommunityIcons
                name="eye"
                size={18}
                style={LoginStyles.showPassword}
                color="rgba(0,0,0,0.5)"
              />
            </Pressable>
          </View>
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
  login: {
    fontFamily: 'GmarketSansTTFBold',
    marginTop: '60%',
    color: 'white',
    fontWeight: '800',
    fontSize: 25,
    lineHeight: 25,
  },
  welcome: {
    textAlign: 'center',
    fontFamily: 'GmarketSansTTFMedium',
    fontWeight: '400',
    fontSize: 13,
    lineHeight: 13,
    marginTop: 10,
    color: '#464646',
  },
  input: {
    flex: 0.6,
    alignItems: 'center',
    paddingTop: 5,
  },
  loginIcon: {
    justifyContent: 'center',
    marginLeft: 22,
  },
  passwordIcon: {
    justifyContent: 'center',
    marginLeft: 21,
  },
  showPassword: {
    marginRight: 20,
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
