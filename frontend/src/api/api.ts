import { userInfo } from '@/type'
import Send from '@/api/Send'

const postSignup = async (userInfo: userInfo) => {
  return Send({
    method: 'post',
    url: 'api/user/signup',
    data: {
      address: userInfo.address,
      email: userInfo.email,
      gender: userInfo.gender,
      nickname: userInfo.nickname,
      password: userInfo.password,
    },
  })
}

const emailAuthentication = async (email: string) => {
  return Send({
    method: 'get',
    url: `api/account/email-authentication`,
    params: { email: email },
  })
}

export { postSignup, emailAuthentication }
