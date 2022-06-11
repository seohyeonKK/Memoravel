import {combineReducers} from 'redux'
import languageOption from '@/redux/languageOption'
import userInformation from '@/redux/userInformation'

const reducer = combineReducers({
  userInformation,
  languageOption,
})

export type ReducerType = ReturnType<typeof reducer>
export default reducer
