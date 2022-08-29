import { Image, Text, View } from 'react-native'
import React, { useState } from 'react'
import styles from '@/styles'
import NoProfile from '@assets/img/noProfile.png'

export default function FullWidthCourse() {
  const [CourseName, setCourseName] = useState('코스 이름이름')
  const [Location, setLocation] = useState('장소 예: 경복궁')
  const [Language, setLanguage] = useState('ENG')
  const [Date, setDate] = useState('2022/05/03')
  return (
    <View style={[styles.fullWidthBlock, { borderBottomColor: '#F1F1F1', flexDirection: 'row' }]}>
      <View style={{ justifyContent: 'center' }}>
        <Image source={NoProfile} style={{ width: 100, height: 100 }} />
      </View>
      <View style={{ marginLeft: 20, paddingTop: 20, width: '75%' }}>
        <Text style={[styles.GsanMe14, { color: 'black' }]}>{CourseName}</Text>
        <Text style={[styles.GsanMe11, { color: '#464646', marginTop: 10 }]}>{Location}</Text>
        <Text style={[styles.GsanMe11, { color: '#464646', marginTop: 20 }]}>{Language}</Text>
        <Text style={[styles.GsanMe10, { color: '#464646', marginTop: 10 }]}>{Date}</Text>
      </View>

      <View
        style={{
          backgroundColor: '#FB7979',
          width: 65,
          height: 30,
          position: 'absolute',
          right: 15,
          bottom: 15,
          borderRadius: 50,
          justifyContent: 'center',
          alignItems: 'center',
        }}>
        <Text style={[styles.GsanMe10, { color: 'white' }]}>6. 12-15</Text>
      </View>
    </View>
  )
}
