import styles from '@/styles'
import Icons from '../../Icons'
import React from 'react'
import { View, TextInput } from 'react-native'

const InputEmail = (email: string, setEmail: Function, emailText: string) => {
  return (
    <View style={styles.whiteLongBox}>
      <Icons.MaterialCommunityIcons
        name="email"
        size={16}
        style={{
          justifyContent: 'center',
          marginLeft: 22,
        }}
        color="rgba(0,0,0,0.5)"
      />
      <TextInput
        style={{ flex: 1, paddingLeft: 12, paddingRight: 30 }}
        onChangeText={(text) => setEmail(text)}
        value={email}
        placeholder={emailText}
        keyboardType="email-address"
        placeholderTextColor="rgba(0, 0, 0, 0.6)"
        autoCapitalize="none"
      />
    </View>
  )
}

export default InputEmail
