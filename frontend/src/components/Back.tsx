import { useNavigation } from '@react-navigation/native'
import React from 'react'
import { View } from 'react-native'
import Icons from '../../Icons'

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
          console.log('go back!')
          navigation.goBack()
        }}
      />
    </View>
  )
}

export default Back
