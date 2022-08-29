import React from 'react'
import { StyleSheet, Text, View } from 'react-native'
import { StatusBarHeight } from '@/constants/constant'
import Guide from '@/pages/Chatting/Sections/Guide'
import ChatList from '@/pages/Chatting/Sections/ChatList'
import { GsansMedium } from '@/styles'
import Images from '@assets/images'

export const Chat = () => {
  return (
    <View style={chatStyle.mainView}>
      <View style={chatStyle.title}>
        <Text style={{ fontFamily: GsansMedium }}>채팅</Text>
      </View>
      <View style={chatStyle.guide}>
        <Guide />
      </View>
      <View style={chatStyle.chatList}>
        <ChatList
          profileImg={Images.DefaultProfileImg}
          name={'장재후2장재후장재후장재후'}
          location={'광진구 군자동'}
          message={
            '메세지 내용입니다.메세지 내용입니다.메세지 내용입니다.메세지 내용입니다.메세지 내용입니다.메세지내용입니다.메세지 내용입니다.'
          }
          time={'오후 3:40'}
          count={1000}
        />
      </View>
    </View>
  )
}

const chatStyle = StyleSheet.create({
  mainView: {
    flex: 1,
    backgroundColor: 'white',
  },
  title: {
    justifyContent: 'center',
    marginTop: StatusBarHeight,
    paddingLeft: 20,
    height: 50,
    backgroundColor: 'white',
  },
  guide: {
    marginTop: 10,
    height: 70,
  },
  chatList: {
    flex: 1,
    marginTop: 10,
  },
})

export default Chat
