import {View, Text, StyleSheet} from 'react-native';
import React from 'react';

export default function Course() {
  return (
    <View
      style={{
        width: '100%',
        height: 100,
        borderWidth: 1,
        borderTopColor: '#F1F1F1',
        borderBottomColor: '#F1F1F1',
        borderLeftColor: 'white',
        borderRightColor: 'white',
        flexDirection: 'row',
      }}>
      <View style={inStyle.courseView}>
        <Text style={inStyle.NumText}>0</Text>
        <Text style={inStyle.courseText}>등록한 코스</Text>
      </View>
      <View style={inStyle.courseView}>
        <Text style={inStyle.NumText}>0</Text>
        <Text style={inStyle.courseText}>요청한 코스</Text>
      </View>
      <View style={inStyle.courseView}>
        <Text style={inStyle.NumText}>0</Text>
        <Text style={inStyle.courseText}>여행한 코스</Text>
      </View>
      <View style={inStyle.courseView}>
        <Text style={inStyle.NumText}>0</Text>
        <Text style={inStyle.courseText}>관심코스 코스</Text>
      </View>
    </View>
  );
}
const inStyle = StyleSheet.create({
  courseView: {
    justifyContent: 'center',
    width: '25%',
    alignItems: 'center',
  },
  NumText: {fontSize: 28, color: '#B4B4B4'},
  courseText: {
    fontSize: 12,
    color: '#464646',
    marginTop: 15,
  },
});
