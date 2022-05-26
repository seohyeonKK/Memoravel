import AsyncStorage from '@react-native-async-storage/async-storage'

export const setJWT = (token: any) => {
  AsyncStorage.setItem('JWT_TOKEN', token)
}

export const JWT_TOKEN = AsyncStorage.getItem('JWT_TOKEN')
