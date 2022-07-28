import { userInfo } from '@/type'
import Send from '@/api/Send'

const postSignup = async (userInfo: userInfo) => {
  return Send({
    method: 'post',
    url: 'api/account/signup',
    data: {
      longitude: userInfo.longitude,
      latitude: userInfo.latitude,
      email: userInfo.email,
      gender: userInfo.gender,
      nickname: userInfo.nickname,
      password: userInfo.password,
    },
  })
}

const getEmailAuthentication = async (email: string) => {
  return Send({
    method: 'get',
    url: `api/account/email/${email}/authentication`,
  })
}

const getNicknameCheck = async (nickname: string) => {
  return Send({
    method: 'get',
    url: `api/account/nickname/${nickname}/check`,
    params: { nickname: nickname },
  })
}

export { postSignup, getEmailAuthentication, getNicknameCheck }
