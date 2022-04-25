import React, { useState } from 'react'
import { Text, View, ImageBackground, StyleSheet, TextInput, Pressable } from 'react-native'
import Images from '@assets/images'
import Icons from '../../Icons'
import styles from '@/styles'
import { useSelector } from 'react-redux'
import { useNavigation } from '@react-navigation/native'

const Login = () => {
  const [id, setId] = useState('')
  const [password, setPassword] = useState('')
  const [showPassword, setShowPassword] = useState(true)
  const language = useSelector((state) => state.languageOption)
  const navigation = useNavigation()

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
        <Icons.Ionicons
          name="chevron-back"
          size={30}
          color="white"
          style={styles.backButton}
          onPress={() => navigation.goBack()}
        />
        <View style={LoginStyles.loginText}>
          <Text style={LoginStyles.login}>{login[language].login}</Text>
          <Text style={LoginStyles.welcome}>{login[language].welcome}</Text>
        </View>
        <View style={LoginStyles.input}>
          <View style={styles.whiteLongBox}>
            <Icons.Ionicons name="person-sharp" size={16} style={LoginStyles.loginIcon} color="rgba(0,0,0,0.5)" />
            <TextInput
              style={{ flex: 1, paddingLeft: 12, paddingRight: 30 }}
              onChangeText={(text) => setId(text)}
              value={id}
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
          <Pressable>
            <Text style={LoginStyles.find}>
              {login[language].findId} {login[language].findPassword}
            </Text>
          </Pressable>
        </View>
        <View style={LoginStyles.loginBtn}>
          <Pressable style={LoginStyles.button}>
            <Text style={LoginStyles.buttonText}>{login[language].login}</Text>
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
    fontWeight: '700',
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
    fontFamily: 'GmarketSansTTFMedium',
    fontWeight: '500',
    fontSize: 12,
    lineHeight: 14,
    color: 'white',
    textDecorationLine: 'underline',
    marginTop: 8,
    marginLeft: 110,
  },
  loginBtn: {
    flex: 1,
    alignItems: 'center',
  },
  button: {
    width: 165,
    height: 40,
    backgroundColor: '#B4B4B4',
    borderRadius: 150,
    justifyContent: 'center',
    shadowOffset: { width: 0, height: 5 },
    shadowColor: 'black',
    shadowOpacity: 0.3,
  },
  buttonText: {
    textAlign: 'center',
    fontFamily: 'GmarketSansTTFMedium',
    fontWeight: '500',
    fontSize: 13,
    lineHeight: 15,
    color: 'white',
  },
})

export default Login
