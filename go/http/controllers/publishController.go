package controllers

import (
	"github.com/gofiber/fiber/v2"
	"github.com/google/uuid"
)

type Order struct {
	OrderId string            `json:"orderId"`
}

func PublishController(cxt *fiber.Ctx) error {
	uuid := uuid.New()

	orders := []Order{
		{
			OrderId: uuid.String(),
		},
	}

	print(orders)

	return cxt.JSON(fiber.Map{ "msg": "Order published with order id: " + uuid.String() })
}
