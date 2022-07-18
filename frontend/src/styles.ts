import { StyleSheet } from 'react-native'

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  MainView: {
    flex: 1,
    backgroundColor: 'white',
    paddingTop: 60,
  },
  gmarketMedium: {
    fontFamily: 'GmarketSansTTFMedium',
  },
  backgroundImg: {
    flex: 1,
    justifyContent: 'center',
  },
  longBox: {
    width: 250,
    height: 50,
    backgroundColor: 'white',
    borderRadius: 150,
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
    marginTop: 15,
  },
  longBtn: {
    width: 250,
    height: 40,
    backgroundColor: '#B4B4B4',
    borderRadius: 150,
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
    marginTop: 15,
  },
  boxInnerText: {
    textAlign: 'center',
    fontFamily: 'GmarketSansTTFMedium',
    fontWeight: '500',
    fontSize: 13,
    lineHeight: 15,
  },
  logo: {
    justifyContent: 'center',
    alignItems: 'center',
  },
  logoImg: {
    width: 90,
    height: 85,
  },
  logoText: {
    fontFamily: 'GmarketSansTTFMedium',
    fontWeight: '500',
    fontSize: 18,
    textAlign: 'center',
    lineHeight: 21,
    marginTop: 5,
    color: 'white',
  },
  button: {
    width: 168,
    height: 50,
    backgroundColor: '#464646',
    borderRadius: 150,
    justifyContent: 'center',
  },
  disabledButton: {
    width: 168,
    height: 50,
    backgroundColor: '#B4B4B4',
    borderRadius: 150,
    justifyContent: 'center',
  },
  buttonText: {
    textAlign: 'center',
    fontFamily: 'GmarketSansTTFBold',
    fontWeight: '700',
    fontSize: 12,
    lineHeight: 12,
    color: 'white',
  },
  loginTitle: {
    fontFamily: 'GmarketSansTTFBold',
    color: 'white',
    fontWeight: '800',
    fontSize: 25,
    lineHeight: 25,
  },
  welcome: {
    textAlign: 'center',
    fontFamily: 'GmarketSansTTFMedium',
    fontWeight: '400',
    fontSize: 13,
    lineHeight: 13,
    marginTop: 10,
    color: '#464646',
  },
  mediumText: {
    fontFamily: 'GmarketSansTTFBold',
    fontWeight: '400',
    fontSize: 12,
    lineHeight: 12,
  },

  GsanMe15: {
    fontFamily: 'GmarketSansTTFMedium',
    fontSize: 15,
  },
  GsanMe14: {
    fontFamily: 'GmarketSansTTFMedium',
    fontSize: 14,
  },
  GsanMe13: {
    fontFamily: 'GmarketSansTTFMedium',
    fontSize: 13,
  },
  GsanMe11: {
    fontFamily: 'GmarketSansTTFMedium',
    fontSize: 11,
  },
  GsanMe10: {
    fontFamily: 'GmarketSansTTFMedium',
    fontSize: 10,
  },
  stepText: {
    fontFamily: 'GmarketSansTTFBold',
    fontWeight: '400',
    fontSize: 12,
    lineHeight: 12,
    color: 'white',
  },
  settingTitle: {
    fontFamily: 'GmarketSansTTFMedium',
    fontSize: 16,
    color: 'black',
  },
  sixblock: {
    height: 60,
    borderBottomWidth: 0.5,
    paddingLeft: 25,
  },
  fullWidthBlock: {
    height: 120,
    borderBottomWidth: 0.5,
    paddingLeft: 25,
  },
  fullInput: {
    width: '100%',
    borderWidth: 1,
    borderColor: '#B4B4B4',
    height: 50,
    borderRadius: 50,
    paddingLeft: 20,
  },
  blackBtn: {
    position: 'absolute',
    bottom: 30,
    marginLeft: '5%',
    backgroundColor: '#464646',
    borderRadius: 50,
    justifyContent: 'center',
    alignItems: 'center',
    height: 50,
    width: '90%',
  },
})

export default styles
