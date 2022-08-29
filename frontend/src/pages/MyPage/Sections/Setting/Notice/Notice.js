import { View, Text, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'
import styles from '@/styles'
import SettingTitle from '../SettingTitle'

export default function Notice() {
  const Title = '공지사항'
  return (
    <View style={styles.MainView}>
      <SettingTitle Title={Title} />
    </View>
  )
}
