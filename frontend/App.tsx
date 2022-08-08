/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import Front from '@/pages/FrontPage'
import Identification from '@/pages/signup/IdentificationPage'
import LoginOption from '@/pages/LoginOptionPage'
import Login from '@/pages/LoginPage'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import React from 'react'
import { Provider } from 'react-redux'
import store from './store'
import EnterInfo from '@/pages/signup/EnterInfoPage'
import Nickname from '@/pages/signup/Nickname'
import Location from '@/pages/signup/Location'
import Mypage from '@/pages/MyPage/Mypage'
import Setting from '@/pages/MyPage/Sections/Setting/Setting'
import FixInform from '@/pages/MyPage/Sections/Setting/FixInform/FixInform'
import LanguageSetting from '@/pages/MyPage/Sections/Setting/LanguageSetting/LanguageSetting'
import FAQ from '@/pages/MyPage/Sections/Setting/FAQ/FAQ'
import Notice from '@/pages/MyPage/Sections/Setting/Notice/Notice'
import RequestedCourse from '@/pages/MyPage/Sections/Courses/RequestedCourse'
const Stack = createNativeStackNavigator()

export enum Language {
  ENGLISH = 0,
  KOREAN = 1,
}

const App = () => {
  return (
    <Provider store={store}>
      <NavigationContainer>
        <Stack.Navigator screenOptions={{ headerShown: false }} initialRouteName="Front">
          <Stack.Screen name="Front" component={Front} />
          <Stack.Screen name="LoginOption" component={LoginOption} />
          <Stack.Screen name="Login" component={Login} />

          {/* SignUp */}
          <Stack.Screen name="Signup" component={Identification} />
          <Stack.Screen name="EnterInfo" component={EnterInfo} />
          <Stack.Screen name="Nickname" component={Nickname} />
          <Stack.Screen name="Location" component={Location} />

          {/* MyPage  */}
          <Stack.Screen name="Mypage" component={Mypage} />
          <Stack.Screen name="Setting" component={Setting} />
          <Stack.Screen name="FixInform" component={FixInform} />
          <Stack.Screen name="Notice" component={Notice} />
          <Stack.Screen name="FAQ" component={FAQ} />
          <Stack.Screen name="LanguageSetting" component={LanguageSetting} />
          <Stack.Screen name="RequestedCourse" component={RequestedCourse} />
        </Stack.Navigator>
      </NavigationContainer>
    </Provider>
  )
}

export default App
