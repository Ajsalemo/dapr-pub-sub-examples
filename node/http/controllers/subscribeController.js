import express from "express";

const router = express.Router();

export const subscribeController = router.get("/", (_req, res) => {
    try {
        res.json({ "msg": "subscribe-controller" })
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})