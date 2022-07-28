import { View, Text } from 'react-native'
import React from 'react'
import styles from '@/styles'
import SettingTitle from '../Setting/SettingTitle'
import Icons from '@assets/Icons'
import FullWidthCourse from '@/components/FullWidthCourse'
export default function RequestedCourse() {
  const Title = '요청한 코스'
  return (
    <View style={styles.MainView}>
      <SettingTitle Title={Title} />
      <FullWidthCourse />
    </View>
  )
}
