import React, { useState } from 'react'
import { Text, View, ImageBackground, StyleSheet, TextInput, Pressable } from 'react-native'
import Images from '@assets/images'
import { Logo } from '@/pages/FrontPage'
import Icons from '../../Icons'

const Login = () => {
  const [id, setId] = useState('')
  const [password, setPassword] = useState('')
  const [showPassword, setShowPassword] = useState(true)
  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        <View style={styles.logo}>
          {Logo()}
          <Text style={styles.welcome}>돌아오신 것을 환영해요!</Text>
        </View>
        <View style={styles.input}>
          <View style={styles.inputText}>
            <Icons.Ionicons name="person-sharp" size={16} style={styles.loginIcon} color="rgba(0,0,0,0.5)" />
            <TextInput
              style={{ flex: 1, paddingLeft: 12, paddingRight: 30 }}
              onChangeText={(text) => setId(text)}
              value={id}
              placeholder="ID"
              keyboardType="default"
              placeholderTextColor="rgba(0, 0, 0, 0.6)"
            />
          </View>
          <View style={styles.inputText}>
            <Icons.MaterialCommunityIcons name="lock" size={18} style={styles.passwordIcon} color="rgba(0,0,0,0.5)" />
            <TextInput
              style={{ flex: 1, paddingLeft: 12, paddingRight: 10 }}
              onChangeText={(text) => setPassword(text)}
              value={password}
              placeholder="Password"
              keyboardType="default"
              secureTextEntry={showPassword}
              textContentType={'password'}
              placeholderTextColor="rgba(0, 0, 0, 0.6)"
            />
            <Pressable onPress={() => setShowPassword((prev) => !prev)}>
              <Icons.MaterialCommunityIcons name="eye" size={18} style={styles.showPassword} color="rgba(0,0,0,0.5)" />
            </Pressable>
          </View>
          <Pressable>
            <Text style={styles.find}>아이디/비밀번호 찾기</Text>
          </Pressable>
        </View>
        <View style={styles.login}>
          <Pressable style={styles.button}>
            <Text style={styles.buttonText}>LOGIN</Text>
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
  logo: {
    flex: 0.4,
    paddingTop: '45%',
  },
  welcome: {
    textAlign: 'center',
    fontFamily: 'GmarketSansTTFMEdium',
    fontWeight: '500',
    fontSize: 13,
    lineHeight: 15,
    marginTop: 5,
    color: '#464646',
  },
  input: {
    flex: 0.6,
    alignItems: 'center',
    paddingTop: 5,
  },
  inputText: {
    width: 255,
    height: 50,
    backgroundColor: 'white',
    borderRadius: 150,
    justifyContent: 'center',
    flexDirection: 'row',
    marginTop: 17,
    shadowOffset: { width: 1, height: 3 },
    shadowColor: 'black',
    shadowOpacity: 0.2,
  },
  loginIcon: {
    justifyContent: 'center',
    marginTop: 17,
    marginLeft: 22,
  },
  passwordIcon: {
    justifyContent: 'center',
    marginTop: 15,
    marginLeft: 21,
  },
  showPassword: {
    marginRight: 20,
    marginTop: 15,
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
  login: {
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
