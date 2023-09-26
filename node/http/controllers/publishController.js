import express from "express";
import { axiosInstance } from "../utils/axios.js";

const router = express.Router();

export const publishController = router.get("/", async (_req, res) => {
    try {
        const data = [
            { "orderId": "100" }
        ]
        const response = await axiosInstance.post("/orders", data)
        console.log(response)
        res.json({ "msg": "publish-controller" })
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})