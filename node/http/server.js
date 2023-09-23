import express from "express";
import { homeController } from "./controllers/homeController.js"
import { publishController } from "./controllers/publishController.js"
import { subscribeController } from "./controllers/subscribeController.js"

const app = express();
const port = process.env.PORT || 3000;

app.use(homeController)
app.use("/api/pub", publishController)
app.use("/api/sub", subscribeController)

app.listen(port, () => console.log(`Server is listening on port ${port}`))