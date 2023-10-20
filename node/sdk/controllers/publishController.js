import { DaprClient } from "@dapr/dapr";
import express from "express";
import { v4 as uuidv4 } from 'uuid';

const router = express.Router();

export const publishController = router.get("/", async (_req, res) => {
    try {
        const client = new DaprClient();
        const pubSubName = "pubsub";
        const topic = "orders";

        const orderId = uuidv4()
        const data = [
            { "orderId": orderId }
        ]

        await client.pubsub.publish(pubSubName, topic, data);

        res.json({ "msg": `Order published with order id: ${orderId}` })
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})