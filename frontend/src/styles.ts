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
    shadowOffset: { width: 1, height: 3 },
    shadowColor: 'black',
    shadowOpacity: 0.2,
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
})

export default styles
