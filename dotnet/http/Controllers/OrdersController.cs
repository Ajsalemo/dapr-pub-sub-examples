using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;

namespace http.Controllers;

[ApiController]
[Route("/dapr/subscribe")]
public class OrdersController : ControllerBase
{
    [HttpGet]
    public Newtonsoft.Json.Linq.JArray Subscribe()
    {
        JObject subscribeObj = new()
        {
            ["pubsubname"] = "pubsub",
            ["topic"] = "orders",
            ["route"] = "orders"
        };

        JArray subscribeArray = new()
        {
            subscribeObj
        };

        return subscribeArray;
    }
}