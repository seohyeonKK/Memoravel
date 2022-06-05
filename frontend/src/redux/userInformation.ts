import {createSlice, PayloadAction} from '@reduxjs/toolkit'
import {userInfo} from "@/type"

const userInformation = createSlice({
  name: 'userInfoReducer',
  initialState: {
    address: '',
    email: '',
    gender: '',
    nickname: '',
    password: ''
  } as userInfo,
  reducers: {
    setUserAddress: (state: userInfo, action: PayloadAction<string>) => {
      state.address = action.payload
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

export const {setUserAddress, setUserEmail, setUserGender, setUserNickname, setUserPassword} = userInformation.actions
export default userInformation.reducer
