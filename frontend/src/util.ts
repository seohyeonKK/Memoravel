import AsyncStorage from '@react-native-async-storage/async-storage'
import { useEffect, useRef } from 'react'
import Geolocation from 'react-native-geolocation-service'
import { PermissionsAndroid, Platform } from 'react-native'
import { location } from '@/type'
import axios from 'axios'

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

export const getLocation = (setLocation: Function) => {
  const requestPermission = async () => {
    try {
      if (Platform.OS === 'ios') return await Geolocation.requestAuthorization('always')
      if (Platform.OS === 'android')
        return await PermissionsAndroid.request(PermissionsAndroid.PERMISSIONS.ACCESS_FINE_LOCATION)
    } catch (e) {
      console.log(e)
    }
  }

  requestPermission().then((result: any) => {
    if (result === 'granted') {
      Geolocation.getCurrentPosition(
        (pos) => {
          setLocation({ latitude: pos.coords.latitude, longitude: pos.coords.longitude })
        },
        (error) => {
          console.log(error)
        },
        {
          enableHighAccuracy: true,
          timeout: 3600,
          maximumAge: 3600,
        },
      )
    }
  })
}

export const geoCode = async (location: location) => {
  return axios({
    url:
      'https://naveropenapi.apigw.ntruss.com/map-reversegeocode/v2/gc?coords=' +
      `${location.longitude}, ${location.latitude}` +
      '&orders=addr&output=json',
    method: 'GET',
    headers: {
      'X-NCP-APIGW-API-KEY-ID': '7pvl33db92',
      'X-NCP-APIGW-API-KEY': 'SFf02qBluq3rQ7sAPKDUXYyDuZ9AD1Eo32WSKkSd',
    },
  })
    .then((res) => {
      return res.data
    })
    .catch((err) => {
      return err
    })
}
