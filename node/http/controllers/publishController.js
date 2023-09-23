import express from "express";

const router = express.Router();

export const publishController = router.get("/", (_req, res) => {
    try {
        res.json({ "msg": "publish-controller" })
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})