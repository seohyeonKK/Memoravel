import { View, Text, Image, TouchableOpacity } from 'react-native'
import React from 'react'
import Setting from './images/Setting.png'
import { useNavigation } from '@react-navigation/native'
export default function Header() {
  const navigation = useNavigation()
  return (
    <View>
      <View style={{ width: '100%', flexDirection: 'row' }}>
        <View style={{ width: 320 }}>
          <Text style={{ fontSize: 16 }}>마이페이지</Text>
        </View>
        <TouchableOpacity onPress={() => navigation.navigate('Setting')}>
          <Image source={Setting} style={{ width: 20, height: 20 }} />
        </TouchableOpacity>
      </View>
    </View>
  )
}
