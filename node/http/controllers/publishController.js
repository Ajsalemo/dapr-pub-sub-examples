import express from "express";
import { axiosInstance } from "../utils/axios.js";

const router = express.Router();

export const publishController = router.get("/", async (_req, res) => {
    try {
        const data = [
            { "orderId": "100" }
        ]
        const response = await axiosInstance.post("/ansalemo-eventhub-topic", data)
        console.log(response.status ?? "no status code returned")
        res.json({ "msg": "publish-controller" })
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})