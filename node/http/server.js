import express from "express";
import { homeController } from "./controllers/homeController.js"
import { publishController } from "./controllers/publishController.js"
import { subscribeController } from "./controllers/subscribeController.js"
import { getMessages } from "./controllers/getMessages.js"

const app = express();
const port = process.env.PORT || 3000;

app.use(homeController)
app.use("/messages", getMessages)
app.use("/api/pub", publishController)
app.use("/dapr/subscribe", subscribeController)

app.listen(port, () => console.log(`Server is listening on port ${port}`))