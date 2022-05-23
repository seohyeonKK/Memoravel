import { setEnglish, setKorean } from '@/redux/languageOption'
import Images from '@assets/images'
import { useNavigation } from '@react-navigation/native'
import React from 'react'
import { View, StyleSheet, ImageBackground, Text, Image, Pressable } from 'react-native'
import { useDispatch } from 'react-redux'
import styles from '@/styles'

export const Logo = () => {
  return (
    <View style={styles.logo}>
      <Image source={Images.Logo} style={styles.logoImg} />
      <Text style={styles.logoText}>memoravel</Text>
    </View>
  )
}
export const Front = () => {
  const navigation = useNavigation()
  const dispatch = useDispatch()
  const Korean = () => {
    dispatch(setKorean())
    navigation.navigate('LoginOption')
  }

  const English = () => {
    dispatch(setEnglish())
    navigation.navigate('LoginOption')
  }

  return (
    <View style={styles.container}>
      <ImageBackground source={Images.LoginBackground} resizeMode="cover" style={styles.backgroundImg}>
        <View style={FrontStyles.slogan}>
          <Text style={FrontStyles.sloganText}>기억에 남는 여행,{'\n'}추억이 되는 시간</Text>
          {Logo()}
        </View>
        <View style={FrontStyles.buttons}>
          <Pressable style={styles.whiteLongBox} onPress={Korean}>
            <Text style={styles.boxInnerText}>한국어로 시작하기</Text>
          </Pressable>
          <Pressable style={styles.whiteLongBox} onPress={English}>
            <Text style={styles.boxInnerText}>START IN ENGLISH</Text>
          </Pressable>
        </View>
      </ImageBackground>
    </View>
  )
}

const FrontStyles = StyleSheet.create({
  container: {
    flex: 1,
  },
  backgroundImg: {
    flex: 1,
    justifyContent: 'center',
  },
  slogan: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
  },
  sloganText: {
    color: 'white',
    fontFamily: 'GmarketSansTTFMedium',
    fontSize: 15,
    marginTop: '50%',
    marginBottom: 22,
    textAlign: 'center',
  },
  buttons: {
    flex: 1,
    alignItems: 'center',
  },
})

export default Front
