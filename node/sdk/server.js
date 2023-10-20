import express from "express";
import { homeController } from "./controllers/homeController.js";
import { publishController } from "./controllers/publishController.js";
import { getOrdersController } from "./controllers/getOrdersController.js";
import { subscribeController } from "./controllers/subscribeController.js";

const app = express();
const port = process.env.PORT || 8080;

app.use(express.json({ type: 'application/*+json' }));

app.use(homeController)
app.use("/api/pub", publishController)
app.use("/orders", getOrdersController)
app.use("/dapr/subscribe", subscribeController)

app.listen(port, () => console.log(`Server is listening on port ${port}`))