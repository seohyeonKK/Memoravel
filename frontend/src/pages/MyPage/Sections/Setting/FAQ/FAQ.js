import { View, Text, StyleSheet, TouchableOpacity } from 'react-native'
import React from 'react'
import styles from '@/styles'
import SettingTitle from '../SettingTitle'

export default function FAQ() {
  const Title = 'FAQ'
  return (
    <View style={styles.MainView}>
      <SettingTitle Title={Title} />
    </View>
  )
}
