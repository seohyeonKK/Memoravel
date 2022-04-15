import React, { useState } from 'react'
import { Text, View, TextInput, StyleSheet } from 'react-native'

const Login = () => {
  const [id, setId] = useState<string>()

  return (
    <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
      <Text>login</Text>
      <TextInput
        style={styles.input}
        onChangeText={(text) => setId(text)}
        value={id}
        placeholder="ID"
        keyboardType="default"></TextInput>
    </View>
  )
}

const styles = StyleSheet.create({
  input: {
    backgroundColor: '#FFFFFF',
    borderRadius: 150,
  },
})

export default Login
