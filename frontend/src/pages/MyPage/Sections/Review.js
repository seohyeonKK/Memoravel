import { Image, Text, View } from 'react-native'
import React, { useState } from 'react'
import styles from '@/styles'
import NoProfile from '@assets/img/noProfile.png'

export default function Review() {
  const [RankNum, setRankNum] = useState(4.5)
  return (
    <View style={{ paddingTop: 20 }}>
      <View style={{ width: '100%' }}>
        <View style={{ paddingLeft: 20, flexDirection: 'row', height: 50 }}>
          <View style={{ justifyContent: 'center' }}>
            <Text>4.5점</Text>
          </View>
        </View>
      </View>
      <View style={[styles.sixblock, { borderBottomColor: '#F1F1F1', flexDirection: 'row' }]}>
        <View style={{ justifyContent: 'center' }}>
          <Image source={NoProfile} style={{ width: 40, height: 40 }} />
        </View>
        <View style={{ justifyContent: 'center', marginLeft: 10, width: '75%' }}>
          <Text style={[styles.GsanMe11, { color: 'black' }]}>사용자닉네임</Text>
          <Text style={[styles.GsanMe10, { color: '#464646', marginTop: 10 }]}>후기내용이 들어갈자리</Text>
        </View>
        <View style={{ justifyContent: 'center' }}>
          <Text style={[styles.GsanMe11, { color: '#888888' }]}>{RankNum}</Text>
        </View>
      </View>
    </View>
  )
}
