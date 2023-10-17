import express from "express";

const router = express.Router();

export const subscribeController = router.get("/", (_req, res) => {
    try {
        res.json([
            {
                pubsubname: "eventhubs-pubsub",
                topic: "ansalemo-eventhub-topic",
                route: "messages"
            }
        ]);
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})