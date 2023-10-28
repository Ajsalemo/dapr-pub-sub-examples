package controllers

import (
	"github.com/gofiber/fiber/v2"
)

type Subscription struct {
	PubsubName string            `json:"pubsubname"`
	Topic      string            `json:"topic"`
	Metadata   map[string]string `json:"metadata,omitempty"`
	Route      string            `json:"route"`
}

func SubscribeController(cxt *fiber.Ctx) error {
	subscriptions := []Subscription{
		{
			PubsubName: "pubsub",
			Topic:      "orders",
			Route:      "/orders",
		},
	}

	return cxt.JSON(subscriptions)
}
