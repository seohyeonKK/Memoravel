/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import { NavigationContainer } from '@react-navigation/native'
import React from 'react'
import { View } from 'react-native'
import Icons from './Icons'

const App = () => {
  return (
    <NavigationContainer>
      <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
        <Icons.Entypo name="rocket" size={20} color="black" />
      </View>
    </NavigationContainer>
  )
}

export default App
