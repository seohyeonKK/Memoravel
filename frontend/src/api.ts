import axios, { AxiosRequestConfig } from 'axios'
import { userInfo } from './type'

const request = async (config: AxiosRequestConfig) => {
  try {
    return await axios(config)
  } catch (error) {
    if (axios.isAxiosError(error)) {
      // todo: 공통 에러 처리
    } else {
      console.log(error)
    }
    return null
  }
}

const postSignup = async (userInfo: userInfo) => {
  const response = await request({
    method: 'post',
    url: '/api/user/signup',
    data: {
      address: userInfo.address,
      email: userInfo.email,
      gender: userInfo.gender,
      language: userInfo.language,
      nickname: userInfo.nickname,
      password: userInfo.password,
      phoneNumber: userInfo.phoneNumber,
      photoPath: userInfo.photoPath,
    },
  })
  return response ? true : false
}

export { postSignup }
