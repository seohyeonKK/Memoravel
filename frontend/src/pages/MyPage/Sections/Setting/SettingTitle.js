import { View, Text, TouchableOpacity } from 'react-native'
import React from 'react'
import styles from '@/styles'
import Icons from '@assets/Icons'
import { useNavigation } from '@react-navigation/native'

export default function SettingTitle({ Title }) {
  const navigation = useNavigation()
  return (
    <View style={[styles.sixblock, { alignItems: 'center', paddingLeft: 0, borderBottomColor: '#C4C4C4' }]}>
      <TouchableOpacity onPress={() => navigation.goBack()} style={{ position: 'absolute', left: '5%' }}>
        <Icons.Entypo name="chevron-thin-left" size={20} color="black" />
      </TouchableOpacity>
      <Text style={styles.settingTitle}>{Title}</Text>
    </View>
  )
}
