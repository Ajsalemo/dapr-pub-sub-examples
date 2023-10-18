import axios from "axios";
import Agent from "agentkeepalive";

const keepAliveAgent = new Agent({
    maxSockets: 128, // or 128 / os.cpus().length if running node across multiple CPUs
    maxFreeSockets: 128, // or 128 / os.cpus().length if running node across multiple CPUs
    timeout: 60000, // active socket keepalive for 60 seconds
    freeSocketTimeout: 30000, // free socket keepalive for 30 seconds
  });

export const axiosInstance = axios.create({ 
    // The URL Dapr expects is constructed as follows:
    // http://localhost:3500/v1.0/publish/[pubsub_component_metadata.name]/[eventhub_topic_name]
    baseURL: "http://localhost:3500/v1.0/publish/pubsub",
    httpAgent: keepAliveAgent
})
