import styles from '@/styles'
import Icons from '@assets/Icons'
import React from 'react'
import { View, TextInput } from 'react-native'

const InputEmail = (email: string, setEmail: Function, emailText: string, editable: boolean) => {
  return (
    <View style={styles.longBox}>
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
        style={[styles.mediumText, { flex: 1, paddingLeft: 15, paddingRight: 30 }]}
        onChangeText={(text) => setEmail(text)}
        value={email}
        placeholder={emailText}
        keyboardType="email-address"
        placeholderTextColor="rgba(0, 0, 0, 0.6)"
        autoCapitalize="none"
        editable={editable}
      />
    </View>
  )
}

export default InputEmail
