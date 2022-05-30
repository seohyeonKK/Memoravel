import { useNavigation } from '@react-navigation/native'
import React from 'react'
import { View } from 'react-native'
import Icons from '@assets/Icons'

const Back = () => {
  const navigation = useNavigation()
  return (
    <View style={{ zIndex: 1 }}>
      <Icons.Ionicons
        name="chevron-back"
        size={30}
        color="white"
        style={{
          position: 'absolute',
          top: 57,
          left: 27,
        }}
        onPress={() => {
          navigation.goBack()
        }}
      />
    </View>
  )
}

export default Back
