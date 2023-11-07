package controllers

import (
	"bytes"
	"context"
	"encoding/json"
	"log"

	dapr "github.com/dapr/go-sdk/client"
	"github.com/gofiber/fiber/v2"
	"github.com/google/uuid"
)

type Order struct {
	OrderId string `json:"orderId"`
}

func PublishController(cxt *fiber.Ctx) error {
	uuid := uuid.New()

	orders := []Order{
		{
			OrderId: uuid.String(),
		},
	}
	// Marshal the orders struct to JSON
	t, err := json.Marshal(orders)
	client, err := dapr.NewClient()

	if err != nil {
		log.Fatal(err)
	}

	ctx := context.Background()

	if err := client.PublishEvent(ctx, "pubsub", "orders", bytes.NewBuffer(t)); err != nil {
		panic(err)
	}

	return cxt.JSON(fiber.Map{"msg": "Order published with order id: " + uuid.String()})
}
