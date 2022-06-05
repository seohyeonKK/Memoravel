import axios from 'axios'

// axios.defaults.headers.common['Authorization'] = JWT_TOKEN ? `Bearer ${JWT_TOKEN}` : ''

const instance = axios.create({
  baseURL: 'http://localhost:8080/',
  headers: {
    // Authorization: JWT_TOKEN ? `Bearer ${JWT_TOKEN}` : '',
  },
})

instance.interceptors.request.use(
  (config) => {
    return config
  },
  (error) => {
    return Promise.reject(error)
  },
)

instance.interceptors.response.use(
  (response) => {
    return response
  },

  (error) => {
    return Promise.reject(error)
  },
)

export default instance
