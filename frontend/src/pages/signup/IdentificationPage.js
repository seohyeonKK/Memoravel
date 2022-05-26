import styles from '@/styles'
import React, { useState } from 'react'
import { ImageBackground, Text, View, Pressable, StyleSheet, TextInput } from 'react-native'
import Images from '@assets/images'
import { useSelector } from 'react-redux'
import Back from '@/components/Back'
import InputEmail from '@/components/InputEmail'
import { identification } from '@/constants/language'

const Identification = () => {
  const language = useSelector((state) => state.languageOption)
  const [email, setEmail] = useState('')
  const [inputCode, setInputCode] = useState('')

  // const [code, setCode] = useState('')
  // const [request, setRequest] = useState(false)
  const codeConfirm = (
    <View style={styles.longBox}>
      <Text style={[styles.mediumText, { paddingLeft: 22, color: '#888888', lineHeight: 14 }]}>
        {identification[language].code}
      </Text>
      <TextInput
        style={[styles.mediumText, { flex: 1, paddingLeft: 10 }]}
        onChangeText={(text) => setInputCode(text)}
        value={inputCode}
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
          <Pressable style={[styles.longBtn, inputCode ? { backgroundColor: '#BEDF61' } : '']}>
            <Text style={[styles.mediumText, { textAlign: 'center', color: 'white' }]}>
              {identification[language].confirmCode}
            </Text>
          </Pressable>
        </View>
        <View style={identificationStyles.next}>
          <Pressable style={email && inputCode ? styles.button : styles.disabledButton}>
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
