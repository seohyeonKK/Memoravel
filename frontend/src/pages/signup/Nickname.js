import { Animated, ImageBackground, Pressable, StyleSheet, Text, TextInput, View } from 'react-native'
import React, { useEffect, useRef, useState } from 'react'
import styles from '@/styles'
import Images from '@assets/images'
import { useSelector } from 'react-redux'
import { nickName } from '@/constants/language'

const Nickname = () => {
  const language = useSelector((state) => state.languageOption)
  const upAnim = useRef(new Animated.Value(0)).current
  const fadeTxtAnim = useRef(new Animated.Value(0)).current
  const fadeInputAnim = useRef(new Animated.Value(0)).current
  const [nickname, setNickname] = useState('')
  const user = useSelector((state) => state.userInformation)

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
  const fadeInInput = () => {
    Animated.timing(fadeInputAnim, {
      toValue: 1,
      useNativeDriver: true,
    }).start()
  }

  useEffect(() => {
    fadeInTxt()
    setTimeout(goUp, 1000)
    setTimeout(fadeInInput, 2000)
  }, [])

  return (
    <View style={styles.container}>
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
          <Animated.View style={[styles.longBox, { opacity: fadeInputAnim }, nicknameStyles.input]}>
            <TextInput
              style={[styles.mediumText, { flex: 1, paddingLeft: 22, paddingRight: 10 }]}
              value={nickname}
              onChangeText={(text) => setNickname(text)}
              placeholder={nickName[language].nickname}
              keyboardType="default"
              placeholderTextColor="#888888"
              autoCapitalize="none"
            />
            <Pressable>
              <Text style={[styles.mediumText, { paddingRight: 19, textDecorationLine: 'underline' }]}>
                {nickName[language].check}
              </Text>
            </Pressable>
          </Animated.View>
        </View>
        <Text>{console.log(user)}</Text>
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
})
export default Nickname
