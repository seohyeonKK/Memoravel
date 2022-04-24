import { combineReducers } from 'redux'
import languageOption from '@/redux/languageOption'

const reducer = combineReducers({
  languageOption,
})

export type ReducerType = ReturnType<typeof reducer>
export default reducer
