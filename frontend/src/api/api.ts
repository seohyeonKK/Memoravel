import { userInfo } from '@/type'
import Send from '@/api/Send'

const postSignup = async (userInfo: userInfo) => {
  return Send({
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
}

export { postSignup }
