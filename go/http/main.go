package main

import (
    "log"

    "github.com/gofiber/fiber/v2"
	controllers "dapr-pub-sub-examples-go-http/controllers"
)

func main() {
    app := fiber.New()

    app.Get("/", controllers.IndexController)
    app.Post("/orders", controllers.GetOrdersController)
	app.Get("/api/pub", controllers.PublishController)
	app.Get("/dapr/subscribe", controllers.SubscribeController)

    log.Fatal(app.Listen(":3000"))
}