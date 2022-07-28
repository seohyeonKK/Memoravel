import { createSlice, PayloadAction } from '@reduxjs/toolkit'
import { location, userInfo } from '@/type'

const userInformation = createSlice({
  name: 'userInfoReducer',
  initialState: {
    longitude: 0,
    latitude: 0,
    email: '',
    gender: '',
    nickname: '',
    password: '',
  } as userInfo,
  reducers: {
    setUserLocation: (state: userInfo, action: PayloadAction<location>) => {
      state.longitude = action.payload.longitude
      state.latitude = action.payload.latitude
      return state
    },
    setUserEmail: (state: userInfo, action: PayloadAction<string>) => {
      state.email = action.payload
      return state
    },
    setUserGender: (state: userInfo, action: PayloadAction<boolean>) => {
      state.gender = action.payload ? 'man' : 'woman'
      return state
    },
    setUserNickname: (state: userInfo, action: PayloadAction<string>) => {
      state.nickname = action.payload
      return state
    },
    setUserPassword: (state: userInfo, action: PayloadAction<string>) => {
      state.password = action.payload
      return state
    },
  },
})

export const { setUserLocation, setUserEmail, setUserGender, setUserNickname, setUserPassword } =
  userInformation.actions
export default userInformation.reducer
