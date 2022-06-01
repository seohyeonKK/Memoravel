import styles from '@/styles'
import React, { useState } from 'react'
import { ImageBackground, Text, View, Pressable, StyleSheet, TextInput } from 'react-native'
import Images from '@assets/images'
import { useSelector } from 'react-redux'
import Back from '@/components/Back'
import InputEmail from '@/components/InputEmail'
import { identification } from '@/constants/language'
import { useInterval } from '@/util'
import Icons from '@assets/Icons'
import { useNavigation } from '@react-navigation/native'

const Identification = () => {
  const language = useSelector((state) => state.languageOption)
  const navigation = useNavigation()
  const [email, setEmail] = useState('')
  const [inputCode, setInputCode] = useState('')
  const [code, setCode] = useState(null)
  const [request, setRequest] = useState(false)
  const [timer, setTimer] = useState(0)
  const [send, setSend] = useState(false)
  const [confirm, setConfirm] = useState(false)

  const getCode = () => {
    if (!request) {
      setRequest(true)
      setTimer(180)
      setSend(true)
      console.log('send')
      // todo: api 추가 response로 인증 코드
    }
  }

  const confirmCode = () => {
    // if (inputCode === code)
    setConfirm(true)
    setTimer(0)
    console.log('confirm')
  }

  const setText = (text) => {
    if (!confirm) {
      if (!request) {
        setEmail(text)
        if (code && code.length > 0) setCode(null)
      }
    }
  }

  const getTimer = () => {
    const time = parseInt(timer / 60) + ' : ' + (timer % 60 < 10 ? '0' : '') + (timer % 60)
    return time
  }

  useInterval(() => {
    if (timer > 0) {
      setTimer(timer - 1)
    }
  }, 1000)

  const codeConfirmInput = (
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
        maxLength={8}
        editable={!confirm}
      />
      {confirm ? (
        <Icons.Ionicons
          name="checkmark"
          size={20}
          style={{
            marginRight: 17,
          }}
          color="#39DB00"
        />
      ) : (
        <Text style={{ paddingRight: 20, color: '#000000', lineHeight: 13, fontWeight: '300', fontSize: 11 }}>
          {send ? getTimer() : null}
        </Text>
      )}
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
          {InputEmail(email, setText, identification[language].email, !request && !confirm)}
          <Pressable
            style={[styles.longBtn, email ? { backgroundColor: '#464646' } : '']}
            onPress={getCode}
            disabled={confirm}>
            <Text style={[styles.mediumText, { textAlign: 'center', color: 'white', lineHeight: 15 }]}>
              {identification[language].sendingCode}
            </Text>
          </Pressable>
          {codeConfirmInput}
          <Pressable
            style={[styles.longBtn, inputCode && send ? { backgroundColor: '#464646' } : '']}
            onPress={confirmCode}
            disabled={!send}>
            <Text style={[styles.mediumText, { textAlign: 'center', color: 'white', lineHeight: 15 }]}>
              {identification[language].confirmCode}
            </Text>
          </Pressable>
        </View>
        <View style={identificationStyles.next}>
          <Pressable
            style={email && inputCode && send && confirm ? styles.button : styles.disabledButton}
            disabled={!confirm}
            onPress={() => navigation.navigate('EnterInfo')}>
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
    flex: 0.8,
    marginTop: 25,
    alignItems: 'center',
  },
})

export default Identification
