import { View, StyleSheet, Image, TouchableOpacity } from 'react-native'
import React from 'react'
import home from './images/home.png'
import homeB from './images/homeB.png'
import search from './images/search.png'
import searchB from './images/searchB.png'
import add from './images/addd.png'
import addB from './images/addB.png'
import chat from './images/chat.png'
import chatB from './images/chatB.png'
import mypage from './images/mypage.png'
import mypageB from './images/mypageB.png'

export default function Footer(props: { setPages: any, Pages: any }) {
  return (
    <View style={{ height: 50 }}>
      <View style={{ flexDirection: 'row' }}>
        <TouchableOpacity onPress={() => props.setPages(0)} style={{ width: '20%' }}>
          <View style={styles.focusSpace}>
            <Image source={props.Pages === 0 ? home : homeB} style={{ width: 20, height: 20 }} />
            {/* <Text style={props.Pages === 0 ? styles.focusText : styles.underText}>Home</Text> */}
          </View>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => props.setPages(1)} style={{ width: '20%' }}>
          <View style={styles.focusSpace}>
            <Image source={props.Pages === 1 ? search : searchB} style={{ width: 20, height: 20 }} />
            {/* <Text style={props.Pages === 0 ? styles.focusText : styles.underText}>Home</Text> */}
          </View>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => props.setPages(2)} style={{ width: '20%' }}>
          <View style={styles.focusSpace}>
            <Image source={props.Pages === 2 ? add : addB} style={{ width: 20, height: 20 }} />
            {/* <Text style={props.Pages === 0 ? styles.focusText : styles.underText}>Home</Text> */}
          </View>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => props.setPages(3)} style={{ width: '20%' }}>
          <View style={styles.focusSpace}>
            <Image source={props.Pages === 3 ? chat : chatB} style={{ width: 20, height: 20 }} />
            {/* <Text style={props.Pages === 0 ? styles.focusText : styles.underText}>Home</Text> */}
          </View>
        </TouchableOpacity>
        <TouchableOpacity onPress={() => props.setPages(4)} style={{ width: '20%' }}>
          <View style={styles.focusSpace}>
            <Image source={props.Pages === 4 ? mypage : mypageB} style={{ width: 20, height: 20 }} />
            {/* <Text style={props.Pages === 0 ? styles.focusText : styles.underText}>Home</Text> */}
          </View>
        </TouchableOpacity>
      </View>
    </View>
  )
}

const styles = StyleSheet.create({
  focusSpace: { width: '100%', alignItems: 'center', opacity: 1 },
})
