import { Animated, ImageBackground, Pressable, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native'
import React, { useEffect, useRef, useState } from 'react'
import styles from '@/styles'
import Images from '@assets/images'
import { useDispatch, useSelector } from 'react-redux'
import { nickName } from '@/constants/language'
import Back from '@/components/Back'
import { getNicknameCheck } from '@/api/api'
import Icons from '@assets/Icons'
import { useNavigation } from '@react-navigation/native'
import { setUserNickname } from '@/redux/userInformation'

const Nickname = () => {
  const language = useSelector((state) => state.languageOption)
  const upAnim = useRef(new Animated.Value(0)).current
  const fadeTxtAnim = useRef(new Animated.Value(0)).current
  const fadeInAnim = useRef(new Animated.Value(0)).current
  const [nickname, setNickname] = useState('')
  const [request, setRequest] = useState(false)
  const [check, setCheck] = useState(false)
  const [available, setAvailable] = useState(false)
  const dispatch = useDispatch()
  const navigation = useNavigation()

  const goUp = () => {
    Animated.timing(upAnim, {
      toValue: -50,
      duration: 1000,
      useNativeDriver: true,
    }).start()
  }

  const fadeInTxt = () => {
    Animated.timing(fadeTxtAnim, {
      toValue: 1,
      duration: 1000,
      useNativeDriver: true,
    }).start()
  }
  const fadeIn = () => {
    Animated.timing(fadeInAnim, {
      toValue: 1,
      useNativeDriver: true,
    }).start()
  }

  const checkNickname = async () => {
    if (!request && nickname.length) {
      setRequest(true)
      const checkNickname = await getNicknameCheck(nickname)
      if (checkNickname) setRequest(false)
      if (checkNickname.data) setAvailable(checkNickname.data)
      setCheck(true)
    }
  }

  const next = () => {
    dispatch(setUserNickname(nickname))
    navigation.navigate('Location')
  }

  useEffect(() => {
    fadeInTxt()
    setTimeout(goUp, 1000)
    setTimeout(fadeIn, 2000)
  }, [])

  return (
    <View style={styles.container}>
      {Back()}
      <ImageBackground
        source={Images.LoginBackground}
        resizeMode="cover"
        style={[styles.backgroundImg, { alignItems: 'center' }]}>
        <View>
          <Animated.View
            style={[nicknameStyles.info, { opacity: fadeTxtAnim }, { transform: [{ translateY: upAnim }] }]}>
            <Text style={[styles.gmarketMedium, nicknameStyles.infoText, { fontWeight: '700' }]}>
              {nickName[language].infoBold}
            </Text>
            <Text style={[styles.gmarketMedium, nicknameStyles.infoText, { fontWeight: '400' }]}>
              {nickName[language].infoNormal}
            </Text>
          </Animated.View>
          <Animated.View style={[styles.longBox, { opacity: fadeInAnim }, nicknameStyles.input]}>
            <TextInput
              style={[styles.mediumText, { flex: 1, paddingLeft: 22, paddingRight: 10 }]}
              value={nickname}
              onChangeText={(text) => {
                setNickname(text)
                setAvailable(false)
                setCheck(false)
              }}
              placeholder={nickName[language].nickname}
              keyboardType="default"
              placeholderTextColor="#888888"
              autoCapitalize="none"
            />
            <Pressable style={{ opacity: nickname ? 1 : 0 }} onPress={checkNickname}>
              {available ? (
                <Icons.Ionicons
                  name="checkmark"
                  size={20}
                  style={{
                    marginRight: 17,
                  }}
                  color="#39DB00"
                />
              ) : check ? (
                <Text style={[styles.mediumText, { paddingRight: 19, textDecorationLine: 'underline', color: 'red' }]}>
                  {nickName[language].check}
                </Text>
              ) : (
                <Text style={[styles.mediumText, { paddingRight: 19, textDecorationLine: 'underline' }]}>
                  {nickName[language].check}
                </Text>
              )}
            </Pressable>
          </Animated.View>
          <Text style={[nicknameStyles.notAvailable, { opacity: check && !available ? 1 : 0 }]}>
            {nickName[language].notAvailable}
          </Text>
        </View>
        <Animated.View style={{ opacity: fadeInAnim }}>
          <TouchableOpacity
            style={[{ top: -11 }, available ? styles.button : styles.disabledButton]}
            disabled={!available}
            onPress={next}>
            <Text style={styles.buttonText}>{nickName[language].next}</Text>
          </TouchableOpacity>
        </Animated.View>
      </ImageBackground>
    </View>
  )
}

const nicknameStyles = StyleSheet.create({
  info: {
    alignContent: 'flex-start',
    alignSelf: 'baseline',
    flexDirection: 'row',
  },
  infoText: {
    alignSelf: 'baseline',
    fontSize: 18,
    lineHeight: 18,
    color: '#FFFFFF',
  },
  input: {
    width: 280,
    top: -50,
    marginTop: 12,
    alignContent: 'center',
  },
  notAvailable: {
    top: -40,
    alignSelf: 'center',
    fontFamily: 'GmarketSansTTFBold',
    fontWeight: '400',
    fontSize: 11,
    lineHeight: 11,
    color: '#FFFFFF',
  },
})
export default Nickname
