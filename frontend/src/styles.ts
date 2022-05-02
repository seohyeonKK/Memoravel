import { StyleSheet } from 'react-native'

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
  gmarketMedium: {
    fontFamily: 'GmarketSansTTFMedium',
  },
  backgroundImg: {
    flex: 1,
    justifyContent: 'center',
  },
  whiteLongBox: {
    width: 255,
    height: 50,
    backgroundColor: 'white',
    borderRadius: 150,
    justifyContent: 'center',
    alignItems: 'center',
    flexDirection: 'row',
    marginTop: 17,
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
    backgroundColor: '#BEDF61',
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
  stepText: {
    fontFamily: 'GmarketSansTTFBold',
    fontWeight: '400',
    fontSize: 12,
    lineHeight: 12,
    color: 'white',
  },
})

export default styles
