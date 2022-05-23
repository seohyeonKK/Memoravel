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
      personalIdentification: 'Personal Identification',
      enterInfo: 'Enter Info',
      complete: 'Complete',
      phoneNumber: 'Phone number',
      sendingCode: 'Sending Code',
      code: 'code',
      confirmCode: 'Confirm Code',
      next: 'NEXT',
    },
    {
      signup: '회원가입',
      travel: '우리 이제 함께 여행해요 !',
      personalIdentification: '본인인증',
      enterInfo: '회원정보 입력',
      complete: '회원가입 완료',
      phoneNumber: '휴대폰 번호',
      sendingCode: '인증번호 보내기',
      code: '인증번호',
      confirmCode: '인증번호 확인',
      next: '다음',
    },
  ]

  const isSamePwd = () => {
    if (password.length <= 0) return false
    if (confirm === password) return true
    else false
  }

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
            {signup[language].personalIdentification}
          </Text>
          <Text style={styles.stepText}>
            {' > '}
            {signup[language].enterInfo}
            {' > '}
          </Text>
          <Text style={styles.stepText}>{signup[language].complete}</Text>
        </View>
        <View style={SignupStyles.input}>
          {InputEmail(email, setEmail, signup[language].email)}
          {InputPassword(password, setPassword, signup[language].password, false, false)}
          {InputPassword(confirm, setConfirm, signup[language].confirm, true, isSamePwd())}
        </View>
        <View style={SignupStyles.next}>
          <Pressable style={email && isSamePwd() ? styles.button : styles.disabledButton}>
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
