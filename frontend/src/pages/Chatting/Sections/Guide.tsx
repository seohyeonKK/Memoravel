import React from 'react'
import { Image, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import Images from '@assets/images'
import styles from '@/styles'
import Icons from '@assets/Icons'

export const Guide = () => {
  return (
    <TouchableOpacity style={guideStyle.guideBox}>
      <Image source={Images.ColorLogo} style={guideStyle.logo} />
      <View style={guideStyle.guideTextSection}>
        <Text style={[guideStyle.guideText, styles.GsanMe13]}>슬기로운 메모러블 생활 !</Text>
        <Text style={[guideStyle.guideText, styles.GsanMe13]}>메모러블 알아보기</Text>
      </View>
      <View style={guideStyle.arrow}>
        <Icons.Entypo name="chevron-thin-right" size={12} color="#464646" />
      </View>
    </TouchableOpacity>
  )
}

const guideStyle = StyleSheet.create({
  guideBox: {
    flexDirection: 'row',
    marginLeft: 20,
    marginRight: 20,
    borderRadius: 10,
    backgroundColor: '#EEEEEE',
  },
  logo: {
    margin: 15,
    width: 40,
    height: 40,
  },
  guideTextSection: {
    justifyContent: 'center',
    flex: 1,
  },
  guideText: {
    color: '#464646',
    fontWeight: '300',
    lineHeight: 20,
  },
  arrow: {
    justifyContent: 'center',
    marginRight: 15,
  },
})

export default Guide
