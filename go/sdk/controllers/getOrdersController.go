package controllers

import (
	"encoding/json"
	"fmt"
	"net/url"

	"github.com/gofiber/fiber/v2"
)

func GetOrdersController(cxt *fiber.Ctx) error {
	values, err := url.ParseQuery(string(cxt.Body()))
	if err != nil {
		return err
	}
	// See: https://stackoverflow.com/questions/71396974/how-to-dynamically-parse-request-body-in-go-fiber
	// We need to dynamically parse the request body from the POST request
	obj := map[string]string{}
	for k, v := range values {
		if len(v) > 0 {
			obj[k] = v[0]
		}
	}
	// Marshal obj to JSON
	out, err := json.Marshal(obj)
	if err != nil {
		return err
	}

	fmt.Println(string(out))
	return cxt.JSON(fiber.Map{"msg": "dapr-pub-sub-examples-go-http"})
}
