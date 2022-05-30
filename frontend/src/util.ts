import AsyncStorage from '@react-native-async-storage/async-storage'
import { useEffect, useRef } from 'react'

export const setJWT = (token: any) => {
  AsyncStorage.setItem('JWT_TOKEN', token)
}

export const JWT_TOKEN = AsyncStorage.getItem('JWT_TOKEN')

export const useInterval = (callback: () => unknown, delay: number | null) => {
  const savedCallback = useRef(callback)

  useEffect(() => {
    savedCallback.current = callback
  }, [callback])

  useEffect(() => {
    function tick() {
      savedCallback.current()
    }
    if (delay !== null) {
      let id = setInterval(tick, delay)
      return () => clearInterval(id)
    }
  }, [delay])
}
