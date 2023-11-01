package controllers

import (
	"bytes"
	"encoding/json"
	"fmt"
	"log"
	"net/http"

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
	res, err := http.Post("http://localhost:3500/v1.0/publish/pubsub/orders", "application/json", bytes.NewBuffer(t))

	fmt.Println(res)

	if err != nil {
		log.Fatal(err)
	}

	defer res.Body.Close()
	return cxt.JSON(fiber.Map{"msg": "Order published with order id: " + uuid.String()})
}
