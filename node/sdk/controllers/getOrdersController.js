import express from "express";

const router = express.Router();

export const getOrdersController = router.post("/", (req, res) => {
    try {
        console.log("Order recieved with information: " + req.body.data[0].orderId)
        res.sendStatus(200);
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})