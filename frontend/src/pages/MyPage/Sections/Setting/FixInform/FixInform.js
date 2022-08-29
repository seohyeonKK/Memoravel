import { View, Text, StyleSheet, TouchableOpacity, TextInput, Image } from 'react-native'
import React, { useState } from 'react'
import styles from '@/styles'
import SettingTitle from '../SettingTitle'
import NoProfile from '../../images/NoProfile.png'
export default function FixInform() {
  const Title = '회원정보수정'
  const [NickName, setNickName] = useState('')
  const [phone, setphone] = useState('01068654547')
  const [Email, setEmail] = useState('jangajaeko45@gamail.com')
  const [address, setaddress] = useState('광진구 군자동')
  return (
    <View style={styles.MainView}>
      <SettingTitle Title={Title} />
      <View style={{ justifyContent: 'center', alignItems: 'center', marginTop: 30 }}>
        <Image source={NoProfile} style={{ width: 120, height: 120 }} />
      </View>
      <View style={{ paddingLeft: 25, paddingRight: 25, marginTop: 40 }}>
        <TextInput
          style={styles.fullInput}
          value={NickName}
          onChangeText={(event) => setNickName(event)}
          autoCapitalize={'none'}
          autoCorrect={false}
        />
        <TouchableOpacity style={{ position: 'absolute', right: 50, top: 18 }}>
          <Text>중복확인</Text>
        </TouchableOpacity>
      </View>
      <View style={{ paddingLeft: 25, paddingRight: 25, marginTop: 20 }}>
        <TextInput
          style={styles.fullInput}
          value={phone}
          onChangeText={(event) => setphone(event)}
          autoCapitalize={'none'}
          autoCorrect={false}
        />
      </View>
      <View style={{ paddingLeft: 25, paddingRight: 25, marginTop: 20 }}>
        <TextInput
          style={styles.fullInput}
          value={Email}
          onChangeText={(event) => setEmail(event)}
          autoCapitalize={'none'}
          autoCorrect={false}
        />
      </View>
      <View style={{ paddingLeft: 25, paddingRight: 25, marginTop: 20 }}>
        <TextInput
          style={styles.fullInput}
          value={address}
          onChangeText={(event) => setaddress(event)}
          autoCapitalize={'none'}
          autoCorrect={false}
        />
      </View>

      <TouchableOpacity style={styles.blackBtn}>
        <Text style={[styles.GsanMe13, { color: 'white' }]}>확인</Text>
      </TouchableOpacity>
    </View>
  )
}
