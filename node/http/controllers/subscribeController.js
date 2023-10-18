import express from "express";

const router = express.Router();

export const subscribeController = router.get("/", (_req, res) => {
    try {
        res.json([
            {
                pubsubname: "pubsub",
                topic: "orders",
                route: "orders"
            }
        ]);
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})