import styles from '@/styles'
import React, { useState } from 'react'
import { ImageBackground, Text, View, Pressable, StyleSheet } from 'react-native'
import Images from '@assets/images'
import { useSelector } from 'react-redux'
import Back from '@/components/Back'
import InputEmail from '@/components/InputEmail'
import InputPassword from '@/components/InputPassword'
import { enterInfo } from '@/constants/language'

const EnterInfo = () => {
  const language = useSelector((state) => state.languageOption)
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [confirm, setConfirm] = useState('')

  const isSamePwd = () => {
    if (password.length <= 0) return false
    if (confirm === password) return true
    else false
  }

  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        {Back()}
        <View style={[enterInfoStyles.loginText, { marginTop: '50%' }]}>
          <Text style={styles.loginTitle}>{enterInfo[language].signup}</Text>
          <Text style={styles.welcome}>{enterInfo[language].travel}</Text>
        </View>
        <View style={enterInfoStyles.step}>
          <Text style={styles.stepText}>
            {enterInfo[language].personalIdentification}
            {' > '}
          </Text>
          <Text style={[styles.stepText, { textDecorationLine: 'underline', fontWeight: '700' }]}>
            {enterInfo[language].enterInfo}
          </Text>
          <Text style={styles.stepText}>
            {' > '}
            {enterInfo[language].complete}
          </Text>
        </View>
        <View style={enterInfoStyles.input}>
          {InputEmail(email, setEmail, enterInfo[language].email, true)}
          {InputPassword(password, setPassword, enterInfo[language].password, false, false)}
          {InputPassword(confirm, setConfirm, enterInfo[language].confirm, true, isSamePwd())}
        </View>
        <View style={enterInfoStyles.next}>
          <Pressable style={email && isSamePwd() ? styles.button : styles.disabledButton}>
            <Text style={styles.buttonText}>{enterInfo[language].next}</Text>
          </Pressable>
        </View>
      </ImageBackground>
    </View>
  )
}
const enterInfoStyles = StyleSheet.create({
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

export default EnterInfo
