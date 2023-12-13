using Microsoft.AspNetCore.Mvc;
using Dapr;

namespace http.Controllers;

[ApiController]
public class SubscribeController : ControllerBase
{
    [Topic("pubsub", "orders")]
    [HttpPost("/orders")]
    public string Subscribe([FromBody] dynamic content)
    {
        string order = "Order recieved with information: " + content.ToString();
        Console.WriteLine(order);
        return order;
    }
}