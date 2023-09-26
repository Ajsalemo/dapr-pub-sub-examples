import axios from "axios";
import Agent from "agentkeepalive";

const keepAliveAgent = new Agent({
    maxSockets: 128, // or 128 / os.cpus().length if running node across multiple CPUs
    maxFreeSockets: 128, // or 128 / os.cpus().length if running node across multiple CPUs
    timeout: 60000, // active socket keepalive for 60 seconds
    freeSocketTimeout: 30000, // free socket keepalive for 30 seconds
  });

export const axiosInstance = axios.create({ 
    baseURL: "http://localhost:3500/v1.0/publish/order-pub-sub",
    httpAgent: keepAliveAgent
})

