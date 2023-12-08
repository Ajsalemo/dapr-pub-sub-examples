using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json.Linq;

namespace http.Controllers;

[ApiController]
[Route("/api/pub")]
public class PublishController : ControllerBase
{
    [HttpGet]
    public string Publish()
    {
        string guid = Guid.NewGuid().ToString();

        JObject publishObj = new()
        {
            ["orderId"] = "pubsub",
        };

        JArray publishArray = new()
        {
            publishObj
        };

        string msg = "Order published with order id: " + guid;

        return msg;
    }
}