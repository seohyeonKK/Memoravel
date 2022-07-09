import { View, Text, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'
import styles from '@/styles'
import SettingTitle from '../SettingTitle'
import Icons from '@assets/Icons'
export default function LanguageSetting() {
  const Title = '언어설정'
  return (
    <View style={styles.MainView}>
      <SettingTitle Title={Title} />

      <TouchableOpacity>
        <View style={instyle.block}>
          <View style={{ width: '85%', justifyContent: 'center' }}>
            <Text style={[styles.GsanMe15, { color: '#464646' }]}>한국어</Text>
          </View>
          <View style={{ justifyContent: 'center' }}>
            <Icons.AntDesign name="check" color="#FB7979" size={25} />
          </View>
        </View>
      </TouchableOpacity>
      <TouchableOpacity>
        <View style={[styles.sixblock, { borderBottomColor: '#C4C4C4', justifyContent: 'center' }]}>
          <Text style={[styles.GsanMe15, { color: '#464646' }]}>영어</Text>
        </View>
      </TouchableOpacity>
    </View>
  )
}

const instyle = StyleSheet.create({
  block: {
    borderBottomColor: '#C4C4C4',
    flexDirection: 'row',
    height: 60,
    borderBottomWidth: 0.5,
    paddingLeft: 25,
  },
})
