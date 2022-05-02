import styles from '@/styles'
import Icons from '../../Icons'
import React, { useState } from 'react'
import { View, TextInput, Pressable } from 'react-native'

const InputPassword = (password: string, setPassword: Function, pwdText: string, confirm: boolean, isSame: boolean) => {
  const [showPassword, setShowPassword] = useState(true)

  return (
    <View style={styles.whiteLongBox}>
      <Icons.MaterialCommunityIcons
        name="lock"
        size={18}
        style={{ justifyContent: 'center', marginLeft: 21 }}
        color="rgba(0,0,0,0.5)"
      />
      <TextInput
        style={{ flex: 1, paddingLeft: 12, paddingRight: 10 }}
        onChangeText={(text) => setPassword(text)}
        value={password}
        placeholder={pwdText}
        keyboardType="default"
        placeholderTextColor="rgba(0, 0, 0, 0.6)"
        autoCapitalize="none"
        secureTextEntry={showPassword}
        textContentType={'password'}
      />
      {confirm ? (
        <View>
          {isSame && (
            <Icons.Ionicons
              name="checkmark"
              size={20}
              style={{
                marginRight: 17,
              }}
              color="#39DB00"></Icons.Ionicons>
          )}
        </View>
      ) : (
        <Pressable onPress={() => setShowPassword((prev) => !prev)}>
          <Icons.MaterialCommunityIcons
            name="eye"
            size={18}
            style={{
              marginRight: 20,
            }}
            color="rgba(0,0,0,0.5)"
          />
        </Pressable>
      )}
    </View>
  )
}
export default InputPassword
