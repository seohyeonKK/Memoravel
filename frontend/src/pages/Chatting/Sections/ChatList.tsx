import React from 'react'
import { Image, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import { GsansMedium } from '@/styles'

export const ChatList = (props: {
  profileImg: any
  name: string
  location: string
  message: string
  time: string
  count: number
}) => {
  return (
    <TouchableOpacity style={chatListStyle.mainView}>
      <View style={chatListStyle.profileImgSection}>
        <Image source={props.profileImg} style={chatListStyle.profileImg} />
      </View>
      <View style={chatListStyle.messageSection}>
        <View style={chatListStyle.profile}>
          <Text numberOfLines={1} ellipsizeMode="tail" style={[chatListStyle.name]}>
            {props.name}
          </Text>
          <Text numberOfLines={1} ellipsizeMode="tail" style={chatListStyle.location}>
            {props.location}
          </Text>
        </View>
        <Text numberOfLines={1} ellipsizeMode="tail" style={chatListStyle.message}>
          {props.message}
        </Text>
      </View>
      <View style={chatListStyle.infoSection}>
        <Text style={chatListStyle.time}>{props.time}</Text>
        <View style={chatListStyle.count}>
          <Text style={chatListStyle.countText}>{props.count > 999 ? '999+' : props.count}</Text>
        </View>
      </View>
    </TouchableOpacity>
  )
}

const chatListStyle = StyleSheet.create({
  mainView: {
    flexDirection: 'row',
    backgroundColor: 'white',
    height: 80,
  },
  profileImgSection: {
    marginLeft: 20,
    marginRight: 15,
    justifyContent: 'center',
  },
  profileImg: {
    width: 50,
    height: 50,
  },
  messageSection: {
    flex: 1,
    flexDirection: 'column',
  },
  profile: {
    flexDirection: 'row',
    alignContent: 'center',
    maxWidth: 230,
  },
  name: {
    marginTop: 18,
    fontFamily: GsansMedium,
    fontWeight: '400',
    fontSize: 13,
    lineHeight: 20,
    color: 'black',
    maxWidth: 130,
  },
  location: {
    marginLeft: 8,
    marginTop: 20,
    fontFamily: GsansMedium,
    fontSize: 11,
    fontWeight: '300',
    lineHeight: 16,
    color: 'black',
    maxWidth: 100,
  },
  message: {
    marginTop: 7,
    maxWidth: 230,
    fontFamily: GsansMedium,
    fontSize: 12,
    fontWeight: '300',
    lineHeight: 18,
    color: 'black',
  },
  infoSection: {
    backgroundColor: 'white',
    marginRight: 20,
  },
  time: {
    marginTop: 20,
    fontFamily: GsansMedium,
    fontWeight: '300',
    fontSize: 10,
    lineHeight: 15,
  },
  count: {
    flexDirection: 'row',
    alignSelf: 'flex-end',
    marginTop: 10,
    backgroundColor: '#FB7979',
    borderRadius: 15,
  },
  countText: {
    fontFamily: GsansMedium,
    fontSize: 10,
    fontWeight: '400',
    color: 'white',
    paddingHorizontal: 7,
    paddingVertical: 5,
  },
})

export default ChatList
