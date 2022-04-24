import { configureStore } from '@reduxjs/toolkit'
import reducer from '@/redux/rootReducer'
const store = configureStore({ reducer })

export default store
