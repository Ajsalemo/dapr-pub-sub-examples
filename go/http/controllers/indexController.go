package controllers

import (
	"github.com/gofiber/fiber/v2"
)

func IndexController(cxt *fiber.Ctx) error {
	return cxt.JSON(fiber.Map{ "msg": "dapr-pub-sub-examples-go-http" })
}