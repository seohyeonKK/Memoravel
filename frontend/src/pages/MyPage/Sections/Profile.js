import { View, Text, TouchableOpacity, Image, StyleSheet } from 'react-native'
import React, { useState } from 'react'
import NoProfile from './images/NoProfile.png'
export default function Profile() {
  const [Location, setLocation] = useState('서울특별시 광진구')
  return (
    <View>
      <View style={{ justifyContent: 'center', alignItems: 'center', marginTop: 30 }}>
        <TouchableOpacity>
          <View>
            <Image source={NoProfile} style={{ width: 120, height: 120 }} />
          </View>
        </TouchableOpacity>
        <View style={{ marginTop: 10 }}>
          <Text style={{ fontSize: 18 }}>사용자 닉네임</Text>
        </View>
        <View style={inStyle.LocaView}>
          <Text style={{ color: 'white', fontSize: 12 }}>{Location}</Text>
        </View>
        <View style={{ padding: 20 }}>
          <Text style={{ fontSize: 14 }}>
            I love Korea!{'\n'}I want to share a happy experience with you so that you can love Korea like me !
          </Text>
        </View>
      </View>
    </View>
  )
}
const inStyle = StyleSheet.create({
  LocaView: {
    backgroundColor: '#FB7979',
    width: 150,
    height: 30,
    borderRadius: 150,
    justifyContent: 'center',
    alignItems: 'center',
    marginTop: 12,
  },
})
