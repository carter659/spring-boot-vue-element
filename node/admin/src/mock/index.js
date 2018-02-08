import axios from 'axios'
import MockAdapter from 'axios-mock-adapter'

let mockAdapter = new MockAdapter(axios)

//会员api
import {
  adapters as member
} from '@/mock/member.js'
member.forEach(item => item(mockAdapter))

export default mockAdapter
