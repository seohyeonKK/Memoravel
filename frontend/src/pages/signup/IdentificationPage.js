import styles from '@/styles'
import React, { useState } from 'react'
import { ImageBackground, Text, View, Pressable, StyleSheet, TextInput } from 'react-native'
import Images from '@assets/images'
import { useSelector } from 'react-redux'
import Back from '@/components/Back'
import InputEmail from '@/components/InputEmail'

const Identification = () => {
  const language = useSelector((state) => state.languageOption)
  const [email, setEmail] = useState('')
  const [code, setCode] = useState('')
  // const [request, setRequest] = useState(false)

  const identification = [
    {
      signup: 'SIGN UP',
      travel: `It's time for us to travel`,
      personalIdentification: 'Personal Identification',
      enterInfo: 'Enter Info',
      complete: 'Complete',
      email: 'E-mail',
      sendingCode: 'Sending Code',
      code: 'Code',
      confirmCode: 'Confirm Code',
      next: 'NEXT',
    },
    {
      signup: '회원가입',
      travel: '우리 이제 함께 여행해요 !',
      personalIdentification: '본인인증',
      enterInfo: '회원정보 입력',
      complete: '회원가입 완료',
      email: '이메일',
      sendingCode: '인증번호 보내기',
      code: '인증\n번호',
      confirmCode: '인증번호 확인',
      next: '다음',
    },
  ]
  const codeConfirm = (
    <View style={styles.longBox}>
      <Text style={[styles.mediumText, { paddingLeft: 22, color: '#888888', lineHeight: 14 }]}>
        {identification[language].code}
      </Text>
      <TextInput
        style={[styles.mediumText, { flex: 1, paddingLeft: 10 }]}
        onChangeText={(text) => setCode(text)}
        value={code}
        placeholderTextColor="rgba(0, 0, 0, 0.6)"
        autoCapitalize="none"
      />
    </View>
  )

  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        {Back()}
        <View style={[identificationStyles.loginText, { marginTop: '50%' }]}>
          <Text style={styles.loginTitle}>{identification[language].signup}</Text>
          <Text style={styles.welcome}>{identification[language].travel}</Text>
        </View>
        <View style={identificationStyles.step}>
          <Text style={[styles.stepText, { textDecorationLine: 'underline', fontWeight: '700' }]}>
            {identification[language].personalIdentification}
          </Text>
          <Text style={styles.stepText}>
            {' > '}
            {identification[language].enterInfo}
            {' > '}
          </Text>
          <Text style={styles.stepText}>{identification[language].complete}</Text>
        </View>
        <View style={identificationStyles.input}>
          {InputEmail(email, setEmail, identification[language].email)}
          <Pressable style={[styles.longBtn, email ? { backgroundColor: '#BEDF61' } : '']}>
            <Text style={[styles.mediumText, { textAlign: 'center', color: 'white' }]}>
              {identification[language].sendingCode}
            </Text>
          </Pressable>
          {codeConfirm}
          <Pressable style={[styles.longBtn, code ? { backgroundColor: '#BEDF61' } : '']}>
            <Text style={[styles.mediumText, { textAlign: 'center', color: 'white' }]}>
              {identification[language].confirmCode}
            </Text>
          </Pressable>
        </View>
        <View style={identificationStyles.next}>
          <Pressable style={email && code ? styles.button : styles.disabledButton}>
            <Text style={styles.buttonText}>{identification[language].next}</Text>
          </Pressable>
        </View>
      </ImageBackground>
    </View>
  )
}
const identificationStyles = StyleSheet.create({
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

export default Identification
