import express from "express";

const router = express.Router();

export const getMessages = router.post("/", (req, res) => {
    try {
        console.log(req.body)
        res.sendStatus(200);
    } catch (error) {
        console.error(error)
        res.json({ "err": error })
    }
})