import styles from '@/styles'
import React, { useState } from 'react'
import { ImageBackground, Text, View, Pressable, StyleSheet } from 'react-native'
import Images from '@assets/images'
import { useSelector } from 'react-redux'
import Back from '@/components/Back'
import InputEmail from '@/components/InputEmail'
import InputPassword from '@/components/InputPassword'

const Signup = () => {
  const language = useSelector((state) => state.languageOption)
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [confirm, setConfirm] = useState('')

  const signup = [
    {
      signup: 'SIGN UP',
      travel: `It's time for us to travel`,
      enterInfo: 'Enter Info',
      personalIdentification: 'Personal Identification',
      complete: 'Complete',
      email: 'E-mail',
      password: 'Password',
      confirm: 'Confirm Password',
      next: 'NEXT',
    },
    {
      signup: '회원가입',
      travel: '우리 이제 함께 여행해요 !',
      enterInfo: '회원정보 입력',
      personalIdentification: '본인인증',
      complete: '회원가입 완료',
      email: '이메일',
      password: '비밀번호',
      confirm: '비밀번호 확인',
      next: '다음',
    },
  ]

  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        {Back()}
        <View style={[SignupStyles.loginText, { marginTop: '50%' }]}>
          <Text style={styles.loginTitle}>{signup[language].signup}</Text>
          <Text style={styles.welcome}>{signup[language].travel}</Text>
        </View>
        <View style={SignupStyles.step}>
          <Text style={[styles.stepText, { textDecorationLine: 'underline', fontWeight: '700' }]}>
            {signup[language].enterInfo}
          </Text>
          <Text style={styles.stepText}>
            {' > '}
            {signup[language].personalIdentification}
            {' > '}
          </Text>
          <Text style={styles.stepText}>{signup[language].complete}</Text>
        </View>
        <View style={SignupStyles.input}>
          {InputEmail(email, setEmail, signup[language].email)}
          {InputPassword(password, setPassword, signup[language].password, false, password)}
          {InputPassword(confirm, setConfirm, signup[language].confirm, true, password)}
        </View>
        <View style={SignupStyles.next}>
          <Pressable style={email && password && confirm ? styles.button : styles.disabledButton}>
            <Text style={styles.buttonText}>{signup[language].next}</Text>
          </Pressable>
        </View>
      </ImageBackground>
    </View>
  )
}
const SignupStyles = StyleSheet.create({
  loginText: {
    flex: 0.3,
    justifyContent: 'center',
    alignItems: 'center',
  },
  step: {
    flex: 0.1,
    flexDirection: 'row',
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 10,
  },
  input: {
    flex: 1,
    alignItems: 'center',
  },
  next: {
    flex: 1,
    alignItems: 'center',
  },
})

export default Signup
