import { Animated, ImageBackground, StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native'
import React, { useEffect, useRef, useState } from 'react'
import styles from '@/styles'
import Images from '@assets/images'
import { useDispatch, useSelector } from 'react-redux'
import Back from '@/components/Back'
import { location as locationTxt } from '@/constants/language'
import { geoCode, getLocation, setJWT } from '@/util'
import { postSignup } from '@/api/api'
import { setUserLocation } from '@/redux/userInformation'
import { useNavigation } from '@react-navigation/native'

const Location = () => {
  const language = useSelector((state) => state.languageOption)
  const upAnim = useRef(new Animated.Value(0)).current
  const fadeTxtAnim = useRef(new Animated.Value(0)).current
  const fadeInAnim = useRef(new Animated.Value(0)).current
  const [location, setLocation] = useState(null)
  const [locationName, setLocationName] = useState('')
  const dispatch = useDispatch()
  const user = useSelector((state) => state.userInformation)
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

  const revGeo = async () => {
    const isEnglish = language === 0
    const result = await geoCode(location, isEnglish)
    if (result && result.results) {
      setLocationName(result.results[4].formatted_address)
      dispatch(setUserLocation(location))
    }
  }

  const signUp = async () => {
    const result = await postSignup(user)
    if (result.status === 200) {
      setJWT(result.data)
      navigation.navigate('Mypage')
    }
  }

  useEffect(() => {
    if (!location) getLocation(setLocation)
    else revGeo()
  }, [getLocation, location])

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
            style={[locationStyles.info, { opacity: fadeTxtAnim }, { transform: [{ translateY: upAnim }] }]}>
            <Text style={[styles.gmarketMedium, locationStyles.infoText, { fontWeight: '700' }]}>
              {locationTxt[language].infoBold}
            </Text>
            <Text style={[styles.gmarketMedium, locationStyles.infoText, { fontWeight: '400' }]}>
              {locationTxt[language].infoNormal}
            </Text>
          </Animated.View>
          <Animated.View style={[styles.longBox, { opacity: fadeInAnim }, locationStyles.input]}>
            <TextInput
              style={[styles.mediumText, { flex: 1, paddingLeft: 22, paddingRight: 10 }]}
              value={locationName}
              placeholder={locationTxt[language].current}
              keyboardType="default"
              placeholderTextColor="#888888"
              autoCapitalize="none"
              editable={false}
            />
          </Animated.View>
        </View>
        <Animated.View style={{ opacity: fadeInAnim }}>
          <TouchableOpacity
            style={[{ top: -11 }, locationName.length ? styles.button : styles.disabledButton]}
            disabled={!location}
            onPress={signUp}>
            <Text style={styles.buttonText}>{locationTxt[language].start}</Text>
          </TouchableOpacity>
        </Animated.View>
      </ImageBackground>
    </View>
  )
}

const locationStyles = StyleSheet.create({
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
export default Location
