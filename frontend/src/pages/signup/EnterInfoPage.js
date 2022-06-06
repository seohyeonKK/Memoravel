import styles from '@/styles'
import React, { useState } from 'react'
import { ImageBackground, Pressable, StyleSheet, Text, View } from 'react-native'
import Images from '@assets/images'
import { useDispatch, useSelector } from 'react-redux'
import Back from '@/components/Back'
import InputEmail from '@/components/InputEmail'
import InputPassword from '@/components/InputPassword'
import { enterInfo } from '@/constants/language'
import { useNavigation } from '@react-navigation/native'
import { setUserGender, setUserPassword } from '@/redux/userInformation'

const EnterInfo = () => {
  const language = useSelector((state) => state.languageOption)
  const user = useSelector((state) => state.userInformation)
  const navigation = useNavigation()
  const [email, setEmail] = useState(user.email)
  const [password, setPassword] = useState('')
  const [confirm, setConfirm] = useState('')
  const [male, setMale] = useState(true)
  const dispatch = useDispatch()

  const isSamePwd = () => {
    if (password.length <= 0) return false
    return confirm === password
  }

  const next = () => {
    dispatch(setUserGender(male))
    dispatch(setUserPassword(password))
    navigation.navigate('Nickname')
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
          {InputEmail(email, setEmail, enterInfo[language].email, false)}
          {InputPassword(password, setPassword, enterInfo[language].password, false, false)}
          {InputPassword(confirm, setConfirm, enterInfo[language].confirm, true, isSamePwd())}
          <View style={enterInfoStyles.gender}>
            <View style={{ flexDirection: 'row' }}>
              <Text style={[styles.mediumText, { color: '#FFFFFF', marginRight: 20, lineHeight: 25 }]}>
                {enterInfo[language].male}
              </Text>
              <Pressable style={enterInfoStyles.radio} onPress={() => setMale(true)}>
                <View style={male ? enterInfoStyles.checked : null} />
              </Pressable>
            </View>
            <View style={[{ flexDirection: 'row' }, language ? { marginLeft: 72 } : { marginLeft: 48 }]}>
              <Text style={[styles.mediumText, { color: '#FFFFFF', marginRight: 20, lineHeight: 25 }]}>
                {enterInfo[language].female}
              </Text>
              <Pressable style={enterInfoStyles.radio} onPress={() => setMale(false)}>
                <View style={!male ? enterInfoStyles.checked : null} />
              </Pressable>
            </View>
          </View>
        </View>
        <View style={enterInfoStyles.agree}>
          <Text
            style={[
              styles.mediumText,
              { textAlign: 'center', color: '#464646' },
              language ? { marginBottom: 3 } : { lineHeight: 15 },
            ]}>
            {enterInfo[language].agree}
          </Text>
          <Text
            style={[
              styles.mediumText,
              { textAlign: 'center', color: '#000000', textDecorationLine: 'underline' },
              language ? null : { lineHeight: 15 },
            ]}>
            {enterInfo[language].legal}
          </Text>
        </View>
        <View style={enterInfoStyles.next}>
          <Pressable style={email && isSamePwd() ? styles.button : styles.disabledButton} onPress={next}>
            <Text style={styles.buttonText}>{enterInfo[language].signup}</Text>
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
  gender: {
    flexDirection: 'row',
    justifyContent: 'center',
    alignContent: 'center',
    marginTop: 20,
  },
  radio: {
    width: 25,
    height: 25,
    borderRadius: 30,
    backgroundColor: '#FFFFFF',
  },
  checked: {
    width: 11,
    height: 11,
    borderRadius: 30,
    backgroundColor: '#888888',
    margin: 7,
  },
  agree: {
    marginTop: 30,
    marginBottom: 10,
  },
  next: {
    flex: 0.7,
    alignItems: 'center',
  },
})

export default EnterInfo
