import { View, Text, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'
import SettingTitle from './SettingTitle'
import styles from '@/styles'
import { useNavigation } from '@react-navigation/native'
export default function Setting() {
  const navigation = useNavigation()
  const Title = '환경설정'
  const Logout = () => {
    navigation.reset({
      index: 0,
      routes: [{ name: 'Front' }],
    })
  }
  return (
    <View style={instyle.MainView}>
      <SettingTitle Title={Title} />
      <TouchableOpacity onPress={() => navigation.navigate('FixInform')}>
        <View style={[styles.sixblock, { borderBottomColor: '#C4C4C4', justifyContent: 'center' }]}>
          <Text style={[styles.GsanMe15, { color: '#464646' }]}>회원정보수정</Text>
        </View>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => navigation.navigate('Notice')}>
        <View style={[styles.sixblock, { borderBottomColor: '#C4C4C4', justifyContent: 'center' }]}>
          <Text style={[styles.GsanMe15, { color: '#464646' }]}>공지사항</Text>
        </View>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => navigation.navigate('FAQ')}>
        <View style={[styles.sixblock, { borderBottomColor: '#C4C4C4', justifyContent: 'center' }]}>
          <Text style={[styles.GsanMe15, { color: '#464646' }]}>FAQ</Text>
        </View>
      </TouchableOpacity>
      <TouchableOpacity onPress={() => navigation.navigate('LanguageSetting')}>
        <View style={[styles.sixblock, { borderBottomColor: '#C4C4C4', justifyContent: 'center' }]}>
          <Text style={[styles.GsanMe15, { color: '#464646' }]}>언어설정</Text>
        </View>
      </TouchableOpacity>
      <TouchableOpacity onPress={Logout}>
        <View style={[styles.sixblock, { borderBottomColor: '#C4C4C4', justifyContent: 'center' }]}>
          <Text style={[styles.GsanMe15, { color: '#464646' }]}>로그아웃</Text>
        </View>
      </TouchableOpacity>
    </View>
  )
}

const instyle = StyleSheet.create({
  MainView: {
    flex: 1,
    backgroundColor: 'white',
    paddingTop: 60,
  },
  TitleText: {
    fontSize: 17,
  },
})
