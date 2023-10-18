import express from "express";
import { v4 as uuidv4 } from 'uuid';
import { axiosInstance } from "../utils/axios.js";

const router = express.Router();

export const publishController = router.get("/", async (_req, res) => {
    try {
        const orderId = uuidv4()
        const data = [
            { "orderId": orderId }
        ]
        const response = await axiosInstance.post("/orders", data)
        console.log(response.status ?? "no status code returned")
        res.json({ "msg": `Order published with order id: ${orderId}` })
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})