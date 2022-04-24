import { createSlice } from '@reduxjs/toolkit'
import { Language } from '../../App'

const languageOption = createSlice({
  name: 'languageOptionReducer',
  initialState: 0 as number,
  // 0: English, 1: Korean (인덱싱을 위해 숫자로 표현)
  reducers: {
    setEnglish: () => {
      return Language.ENGLISH
    },
    setKorean: () => {
      return Language.KOREAN
    },
  },
})

export const { setEnglish, setKorean } = languageOption.actions
export default languageOption.reducer
