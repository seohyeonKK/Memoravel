import { Platform, StatusBar } from 'react-native'
import { getStatusBarHeight } from 'react-native-status-bar-height'

export const StatusBarHeight = Platform.OS === 'ios' ? getStatusBarHeight(true) : StatusBar.currentHeight
